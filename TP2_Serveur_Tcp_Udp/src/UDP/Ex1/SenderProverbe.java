package UDP.Ex1;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;
import java.util.Scanner;

// Ce programme envoie un message choisi au hasard vers un port défini par l'utilisateur en UDP
public class SenderProverbe {

    public static void main(String[] args) {

        try {

            // Base de données locale de messages sous forme de tableau de chaînes
            String[] proverbes = {
                    "Qui ne tente rien n'a rien",
                    "Petit a petit l'oiseau fait son nid",
                    "Après la pluie vient le beau temps",
                    "La patience est une vertu",
                    "Tout vient à point à qui sait attendre"
            };

            // Génère un index aléatoire pour piocher un proverbe dans le tableau
            Random rand = new Random();
            String message = proverbes[rand.nextInt(proverbes.length)];

            // Utilisation d'un Scanner pour rendre le port de destination dynamique
            // Le programme se met en pause ici en attendant la saisie au clavier
            Scanner sc = new Scanner(System.in);
            System.out.print("Entrer le port du receiver: ");
            int port = sc.nextInt();

            // Résolution de l'adresse de destination (ici la machine locale)
            InetAddress adresse = InetAddress.getByName("localhost");

            // Création du point de sortie réseau (le port source sera attribué par l'OS)
            DatagramSocket socket = new DatagramSocket();

            // Préparation de la charge utile : conversion du texte en tableau d'octets
            byte[] buffer = message.getBytes();

            // Création du paquet UDP encapsulant les données, leur taille et la destination
            DatagramPacket packet =
                    new DatagramPacket(buffer, buffer.length, adresse, port);

            // Expédition immédiate du paquet sur le réseau
            socket.send(packet);

            System.out.println("Proverbe envoyé : " + message);

            // Libération des ressources réseau et fermeture du scanner (bonne pratique)
            socket.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}