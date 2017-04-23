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

    //���ܺͷ�����Ϣ������
    private ByteBuffer send = ByteBuffer.allocate(1024);
    private ByteBuffer receive = ByteBuffer.allocate(1024);

    public int port = 80;

    Selector selector = null;

    public MyServer(int port) throws Exception {
        this.port = port;
        //�򿪷������׽���ͨ��
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //����������Ϊ������
        serverSocketChannel.configureBlocking(false);
        //�������ͨ���������׽���
        ServerSocket serverSocket = serverSocketChannel.socket();
        //���з����
        serverSocket.bind(new InetSocketAddress(port));
        //ʵ����selector
        selector = Selector.open();
        //ע�ᵽselector,�ȴ�����
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server start at port: " + port);
        //���ͻ�������������
        send.put("data come from server".getBytes());
    }

    //����
    private void listen() throws IOException {
        while (true) {
            //ѡ��һ���,������Ӧ��ͨ����
            selector.select();
            //���ش�ѡ��������ѡ�����
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                //�ֶ�remove��,����selector�е�selectedKeys���ϲ����Զ�ȥ��
                iterator.remove();
                dealKey(selectionKey);
            }
        }
    }

    //��������
    public void dealKey(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel server = null;
        SocketChannel client = null;
        String receiveText;
        int cout = 0;
        //���Դ˼���ͨ���Ƿ��Ѿ�׼���ý����µ��׽�������
        if (selectionKey.isAcceptable()) {
            server = (ServerSocketChannel) selectionKey.channel();
            //����Ϊ֮�������׽���ͨ��, �����,����������ģʽ
            client = server.accept();
            //����Ϊ������
            client.configureBlocking(false);
            //ע�ᵽselector,�ȴ�����
            client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_READ);
        } else {
            if (selectionKey.isReadable()) {
                // ����Ϊ֮�����˼���ͨ����
                client = (SocketChannel) selectionKey.channel();
                //������������Ա��´ζ�ȡ
                receive.clear();
                //��ȡ���������������ݵ�������
                client.read(receive);
                System.out.println(new String(receive.array()));
                selectionKey.interestOps(SelectionKey.OP_WRITE);
            } else if (selectionKey.isWritable()) {
                //������������Ա��´�д��
                send.flip();
                //����Ϊ֮������ͨ��
                client = (SocketChannel) selectionKey.channel();
                //�����ͨ��
                client.write(send);
                selectionKey.interestOps(SelectionKey.OP_READ);
            }
        }
    }
}
