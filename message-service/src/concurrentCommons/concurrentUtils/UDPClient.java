package concurrentUtils;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by chen.Tian on 2017/4/12.
 */
public class UDPClient {
    private static final int PACKAGE_SIZE = 100;

    public static void main(String[] args) {
        //check the arguments
        if (args.length !=2){
            System.out.println("usage,java DatagramClient host port");
            return;
        }
        DatagramSocket socket = null;
        try {
            InetAddress host = InetAddress.getByName(args[0]);
            int port = Integer.parseInt(args[1]);
            socket = new DatagramSocket();

            byte[] data = "Hello, Server".getBytes();
            DatagramPacket packet = new DatagramPacket(data,data.length,host,port);

            socket.send(packet);
            socket.setSoTimeout(2000);
            packet.setData(new byte[PACKAGE_SIZE]);

            socket.receive(packet);
            System.out.println(new String(packet.getData()));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
        }
    }
}
