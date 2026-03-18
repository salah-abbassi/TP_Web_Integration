<<<<<<< HEAD
package UDP.Ex4;
import java.net.*;

// Thread pour recevoir les messages
class ReceiverThread implements Runnable {
    private MulticastSocket socket;
    private InetAddress group;

    public ReceiverThread(MulticastSocket socket, InetAddress group) {
        this.socket = socket;
        this.group = group;
    }

    public void run() {
        byte[] buffer = new byte[1024];
        try {
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println(message); // Affichage sur console
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
=======
package UDP.Ex4;
import java.net.*;

// Thread pour recevoir les messages
class ReceiverThread implements Runnable {
    private MulticastSocket socket;
    private InetAddress group;

    public ReceiverThread(MulticastSocket socket, InetAddress group) {
        this.socket = socket;
        this.group = group;
    }

    public void run() {
        byte[] buffer = new byte[1024];
        try {
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println(message); // Affichage sur console
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
>>>>>>> 7d0ad848fd483ffe1c27ea872302ef8e45c3d6fd
