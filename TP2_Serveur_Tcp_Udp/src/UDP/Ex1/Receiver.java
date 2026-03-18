<<<<<<< HEAD
package UDP.Ex1;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

// Écoute et reçoit des messages via le protocole UDP (mode non connecté)
public class Receiver {

    public static void main(String[] args) {
        try {
            int port = 7676;

            // Création du socket UDP attaché au port d'écoute spécifié
            DatagramSocket socket = new DatagramSocket(port);

            // Tampon (buffer) en mémoire pour stocker les octets bruts qui vont arriver
            byte[] buffer = new byte[1024];

            System.out.println("Receiver en attente sur le port " + port);

            // Prépare une "enveloppe" vide dimensionnée pour accueillir les données entrantes
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Appel bloquant : le programme se met en pause jusqu'à la réception d'un datagramme
            socket.receive(packet);

            // Extraction de la charge utile (payload) et conversion stricte des octets en texte
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Message reçu : " + message);

            // Fermeture du socket pour libérer les ressources réseau
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
=======
package UDP.Ex1;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

// Écoute et reçoit des messages via le protocole UDP (mode non connecté)
public class Receiver {

    public static void main(String[] args) {
        try {
            int port = 7676;

            // Création du socket UDP attaché au port d'écoute spécifié
            DatagramSocket socket = new DatagramSocket(port);

            // Tampon (buffer) en mémoire pour stocker les octets bruts qui vont arriver
            byte[] buffer = new byte[1024];

            System.out.println("Receiver en attente sur le port " + port);

            // Prépare une "enveloppe" vide dimensionnée pour accueillir les données entrantes
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Appel bloquant : le programme se met en pause jusqu'à la réception d'un datagramme
            socket.receive(packet);

            // Extraction de la charge utile (payload) et conversion stricte des octets en texte
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Message reçu : " + message);

            // Fermeture du socket pour libérer les ressources réseau
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
>>>>>>> 7d0ad848fd483ffe1c27ea872302ef8e45c3d6fd
}