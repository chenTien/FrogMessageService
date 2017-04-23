package concurrentUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by chen.Tian on 2017/4/13.
 */
public class MyServer {
    public static void main(String[] args) throws Exception {
        MyServer server = new MyServer(8080);
        server.listen();
    }

    //接受和发送消息缓冲区
    private ByteBuffer send = ByteBuffer.allocate(1024);
    private ByteBuffer receive = ByteBuffer.allocate(1024);

    public int port = 80;

    Selector selector = null;

    public MyServer(int port) throws Exception {
        this.port = port;
        //打开服务器套接字通信
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //服务器设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //检索与此通道关联的套接字
        ServerSocket serverSocket = serverSocketChannel.socket();
        //进行服务绑定
        serverSocket.bind(new InetSocketAddress(port));
        //实例化selector
        selector = Selector.open();
        //注册到selector,等待连接
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server start at port: " + port);
        //向发送缓冲区发送数据
        send.put("data come from server".getBytes());
    }

    //监听
    private void listen() throws IOException {
        while (true) {
            //选择一组键,并将相应的通道打开
            selector.select();
            //返回此选择器的已选结果集
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                //手动remove掉,不如selector中的selectedKeys集合不会自动去除
                iterator.remove();
                dealKey(selectionKey);
            }
        }
    }

    //处理请求
    public void dealKey(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel server = null;
        SocketChannel client = null;
        String receiveText;
        int cout = 0;
        //测试此键的通道是否已经准备好接受新的套接字连接
        if (selectionKey.isAcceptable()) {
            server = (ServerSocketChannel) selectionKey.channel();
            //返回为之创建的套接字通道, 如果有,将处于阻塞模式
            client = server.accept();
            //配置为非阻塞
            client.configureBlocking(false);
            //注册到selector,等待连接
            client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_READ);
        } else {
            if (selectionKey.isReadable()) {
                // 返回为之创建此键的通道。
                client = (SocketChannel) selectionKey.channel();
                //将缓冲区清空以备下次读取
                receive.clear();
                //读取服务器发来的数据到缓冲区
                client.read(receive);
                System.out.println(new String(receive.array()));
                selectionKey.interestOps(SelectionKey.OP_WRITE);
            } else if (selectionKey.isWritable()) {
                //将缓冲区清空以备下次写入
                send.flip();
                //返回为之创建的通道
                client = (SocketChannel) selectionKey.channel();
                //输出到通道
                client.write(send);
                selectionKey.interestOps(SelectionKey.OP_READ);
            }
        }
    }
}
