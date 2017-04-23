package concurrentUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by chen.Tian on 2017/4/13.
 */
public class MyClient {
    public static void main(String[] args) {
        try {
            MyClient client = new MyClient();
            client.work(8085);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    SocketChannel socketChannel = null;
    Selector selector = null;
    //发送接收数据缓冲区
    ByteBuffer send = ByteBuffer.wrap("data from client".getBytes());
    ByteBuffer receive = ByteBuffer.allocate(1024);

    public void work(int port) throws IOException {
        try {
            socketChannel = SocketChannel.open();
            selector = Selector.open();

            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 8080));

            socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            if (selector.select() == 0) {
                continue;
            }
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                socketChannel = (SocketChannel) key.channel();
                if (key.isConnectable()) {
                    if (socketChannel.isConnectionPending()) {
                        //连接结束
                        socketChannel.finishConnect();
                        System.out.println("connect completely");
                        socketChannel.write(send);
                    }
                } else if (key.isReadable()) {
                    try {
                        receive.clear();
                        socketChannel.read(receive);
                        System.out.println(new String(receive.array()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (key.isWritable()) {
                    receive.flip();
                    try {
                        send.flip();
                        socketChannel.write(send);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

}
