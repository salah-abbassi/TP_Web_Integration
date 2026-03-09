package UDP.Ex3;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Random;

public class MulticastSender {

    public static void main(String[] args) {

        // Liste des proverbes disponibles pour l'envoi
        String[] proverbes = {
                "Qui ne tente rien n'a rien",
                "Petit à petit l'oiseau fait son nid",
                "Après la pluie vient le beau temps",
                "La patience est une vertu",
                "Tout vient à point à qui sait attendre"
        };

        // Sélectionne un proverbe au hasard dans la liste
        Random rand = new Random();
        String message = proverbes[rand.nextInt(proverbes.length)];

        // Adresse IP de classe D réservée au groupe multicast
        String multicastAddress = "224.0.0.1";
        // Port sur lequel tous les récepteurs du groupe sont à l'écoute
        int port = 8686;

        try {
            // Résout l'adresse IP du groupe cible
            InetAddress group = InetAddress.getByName(multicastAddress);

            // Crée un socket multicast pour l'expédition (pas besoin du port ici)
            MulticastSocket socket = new MulticastSocket();

            // Convertit le texte du message en tableau d'octets
            byte[] buffer = message.getBytes();

            // Prépare le paquet en le destinant à l'adresse du groupe entier
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);

            // Diffuse le paquet sur le réseau à tous les membres abonnés au groupe
            socket.send(packet);

            System.out.println("Proverbe envoyé au groupe multicast : " + message);

            // Ferme le socket pour libérer les ressources système
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
