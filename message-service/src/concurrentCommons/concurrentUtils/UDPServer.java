package concurrentUtils;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by chen.Tian on 2017/4/12.
 */
public class UDPServer {
    private static final int PACKAGR_SIZE = 100;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("usage DatagramServer port");
            return;
        }
        //Convert the argument to ensure that is valid
        int port = Integer.parseInt(args[0]);

        try {
            //Constructor
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("The server is ready...");
            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[PACKAGR_SIZE],PACKAGR_SIZE);
                // receiving a packet, blocking
                socket.receive(packet);
                //print the data
                System.out.println(packet.getAddress() + "  " + packet.getPort() + " : " + new String(packet.getData()));
                //return the packet to sender
                socket.send(packet);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
