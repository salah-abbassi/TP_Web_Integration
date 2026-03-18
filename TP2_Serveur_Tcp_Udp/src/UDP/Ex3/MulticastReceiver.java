<<<<<<< HEAD
package UDP.Ex3;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {

    public static void main(String[] args) {
        // Adresse IP réservée au multicast (doit être entre 224.0.0.0 et 239.255.255.255)
        String multicastAddress = "224.0.0.76";
        int port = 8686; // Port d'écoute partagé par tous les membres du groupe

        try {
            // Crée un socket spécialisé pour le multicast sur le port défini
            MulticastSocket socket = new MulticastSocket(port);

            // Résout l'adresse IP du groupe de diffusion
            InetAddress group = InetAddress.getByName(multicastAddress);

            // Le récepteur s'abonne officiellement au groupe pour recevoir ses messages
            socket.joinGroup(group);

            System.out.println("MulticastReceiver en attente sur " + multicastAddress + ":" + port);

            // Prépare un espace en mémoire pour les données entrantes
            byte[] buffer = new byte[1024];

            // Boucle infinie pour rester à l'écoute des diffusions du groupe
            while (true) {
                // Prépare une enveloppe vide de la taille du buffer
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Met le programme en pause jusqu'à l'arrivée d'un message destiné au groupe
                socket.receive(packet);

                // Convertit en texte uniquement la partie du buffer contenant des données
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Proverbe reçu : " + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
=======
package UDP.Ex3;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {

    public static void main(String[] args) {
        // Adresse IP réservée au multicast (doit être entre 224.0.0.0 et 239.255.255.255)
        String multicastAddress = "224.0.0.1";
        int port = 8686; // Port d'écoute partagé par tous les membres du groupe

        try {
            // Crée un socket spécialisé pour le multicast sur le port défini
            MulticastSocket socket = new MulticastSocket(port);

            // Résout l'adresse IP du groupe de diffusion
            InetAddress group = InetAddress.getByName(multicastAddress);

            // Le récepteur s'abonne officiellement au groupe pour recevoir ses messages
            socket.joinGroup(group);

            System.out.println("MulticastReceiver en attente sur " + multicastAddress + ":" + port);

            // Prépare un espace en mémoire pour les données entrantes
            byte[] buffer = new byte[1024];

            // Boucle infinie pour rester à l'écoute des diffusions du groupe
            while (true) {
                // Prépare une enveloppe vide de la taille du buffer
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Met le programme en pause jusqu'à l'arrivée d'un message destiné au groupe
                socket.receive(packet);

                // Convertit en texte uniquement la partie du buffer contenant des données
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Proverbe reçu : " + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
>>>>>>> 7d0ad848fd483ffe1c27ea872302ef8e45c3d6fd
