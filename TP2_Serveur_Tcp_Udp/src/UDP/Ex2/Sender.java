package UDP.Ex2;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class Sender {

    public static void main(String[] args) {

        // Liste des proverbes disponibles
        String[] proverbes = {
                "Qui ne tente rien n'a rien",
                "Petit à petit l'oiseau fait son nid",
                "Après la pluie vient le beau temps",
                "La patience est une vertu",
                "Tout vient à point à qui sait attendre"
        };

        // Sélectionne un proverbe au hasard dans le tableau
        Random rand = new Random();
        String message = proverbes[rand.nextInt(proverbes.length)];

        // Port de destination (doit correspondre à celui du Receiver)
        int port = 7676;

        try {
            // Adresse IP cible (ici, la machine locale)
            InetAddress adresse = InetAddress.getByName("localhost");

            // Crée un socket UDP pour l'envoi
            DatagramSocket socket = new DatagramSocket();

            // Convertit le texte du message en octets
            byte[] buffer = message.getBytes();

            // Prépare le paquet avec les données, la taille, l'IP et le port de destination
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, adresse, port);

            // Envoie le paquet sur le réseau
            socket.send(packet);

            System.out.println("Proverbe envoyé : " + message);

            // Ferme le socket pour libérer les ressources
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}