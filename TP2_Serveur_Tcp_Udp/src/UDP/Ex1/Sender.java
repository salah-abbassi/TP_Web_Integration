package UDP.Ex1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// Classe chargée d'expédier un message unique en UDP (mode non connecté)
public class Sender {

    public static void main(String[] args) {
        try {
            // La charge utile (payload) à transmettre
            String message = "bonjour tout le monde";

            // Résolution de l'adresse IP de destination (ici, la machine locale)
            InetAddress adresse = InetAddress.getByName("localhost");
            int port = 8000;

            // Création du socket UDP (le port local de départ est attribué aléatoirement par l'OS)
            DatagramSocket socket = new DatagramSocket();

            // Conversion de la chaîne de caractères en tableau d'octets (format exigé par le réseau)
            byte[] buffer = message.getBytes();

            // Préparation du "colis" : il embarque les données, leur taille exacte, et la destination
            DatagramPacket packet =
                    new DatagramPacket(buffer, buffer.length, adresse, port);

            // Expédition du datagramme sur le réseau (mode "fire and forget", sans garantie de réception)
            socket.send(packet);

            System.out.println("Message envoyé");

            // Fermeture du socket pour libérer le port local
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}