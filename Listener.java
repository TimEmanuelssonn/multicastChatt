import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import javax.swing.JTextArea;

public class Listener implements Runnable  {

    MulticastSocket socket;
    JTextArea chat;
    String ip = "234.235.236.237";
    int port = 12540;
    InetAddress iadr = InetAddress.getByName(ip);
    InetSocketAddress group = new InetSocketAddress(iadr, port);
    NetworkInterface netIf = NetworkInterface.getByName("wlan2");
    
    public Listener(MulticastSocket socket, JTextArea chat) throws SocketException, IOException {
        this.socket = socket;
        this.chat = chat;
    }

    public void run() {
        System.out.println("in run");
        while (!Thread.interrupted()) {
            try {
                socket = new MulticastSocket(port);
                socket.joinGroup(group, netIf);
                byte[] data = new byte[256];
                System.out.println("in run 2");

                DatagramPacket packet = new DatagramPacket(data, data.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                chat.setText(message);
            } catch (IOException e) {
                break;
            }
        }
    }


}
