<<<<<<< HEAD
package UDP.Ex4;
import java.net.*;
import java.util.Scanner;
// Thread pour envoyer les messages
class SenderThread implements Runnable {
    private MulticastSocket socket;
    private InetAddress group;
    private int port;
    private String pseudo;

    public SenderThread(MulticastSocket socket, InetAddress group, int port, String pseudo) {
        this.socket = socket;
        this.group = group;
        this.port = port;
        this.pseudo = pseudo;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                String msg = scanner.nextLine();
                String fullMsg = pseudo + " : " + msg;
                byte[] buffer = fullMsg.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
=======
package UDP.Ex4;
import java.net.*;
import java.util.Scanner;
// Thread pour envoyer les messages
class SenderThread implements Runnable {
    private MulticastSocket socket;
    private InetAddress group;
    private int port;
    private String pseudo;

    public SenderThread(MulticastSocket socket, InetAddress group, int port, String pseudo) {
        this.socket = socket;
        this.group = group;
        this.port = port;
        this.pseudo = pseudo;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                String msg = scanner.nextLine();
                String fullMsg = pseudo + " : " + msg;
                byte[] buffer = fullMsg.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
>>>>>>> 7d0ad848fd483ffe1c27ea872302ef8e45c3d6fd
