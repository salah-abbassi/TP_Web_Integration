package UDP.Ex2;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {

    public static void main(String[] args) {
        int port = 7676; // Port d'écoute fixé pour ce programme

        try {
            // Ouvre le point d'accès réseau sur le port 7676
            DatagramSocket socket = new DatagramSocket(port);

            // Prépare un espace en mémoire pour stocker les données entrantes
            byte[] buffer = new byte[1024];

            System.out.println("Receiver en attente sur le port " + port);

            // Boucle infinie pour rester à l'écoute en permanence
            while (true) {
                // Crée une "enveloppe" vide de la taille du buffer
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Met le programme en pause jusqu'à l'arrivée d'un nouveau paquet
                socket.receive(packet);

                // Convertit en texte uniquement la partie du buffer qui contient des données
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Proverbe reçu : " + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
