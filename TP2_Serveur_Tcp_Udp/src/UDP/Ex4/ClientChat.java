<<<<<<< HEAD
package UDP.Ex4;
import java.net.*;


public class ClientChat {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ClientChat <pseudo>");
            return;
        }

        String pseudo = args[0];
        String multicastAddress = "224.0.0.1";
        int port = 8686;

        try {
            InetAddress group = InetAddress.getByName(multicastAddress);
            MulticastSocket socket = new MulticastSocket(port);
            // Forcer l'interface de loopback
            socket.setInterface(InetAddress.getByName("127.0.0.1"));
            socket.joinGroup(group);

            System.out.println("Bienvenue " + pseudo + "! Vous êtes connecté au chat.");

            // Lancer le thread de réception
            Thread receiver = new Thread(new ReceiverThread(socket, group));
            receiver.start();

            // Lancer le thread d'envoi
            Thread sender = new Thread(new SenderThread(socket, group, port, pseudo));
            sender.start();

            // Les threads fonctionnent en parallèle, main peut rester vide
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
=======
package UDP.Ex4;
import java.net.*;


public class ClientChat {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ClientChat <pseudo>");
            return;
        }

        String pseudo = args[0];
        String multicastAddress = "224.0.0.1";
        int port = 8686;

        try {
            InetAddress group = InetAddress.getByName(multicastAddress);
            MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(group);

            System.out.println("Bienvenue " + pseudo + "! Vous êtes connecté au chat.");

            // Lancer le thread de réception
            Thread receiver = new Thread(new ReceiverThread(socket, group));
            receiver.start();

            // Lancer le thread d'envoi
            Thread sender = new Thread(new SenderThread(socket, group, port, pseudo));
            sender.start();

            // Les threads fonctionnent en parallèle, main peut rester vide
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
>>>>>>> 7d0ad848fd483ffe1c27ea872302ef8e45c3d6fd
