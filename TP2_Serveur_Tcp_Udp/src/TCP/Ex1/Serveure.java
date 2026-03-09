package TCP.Ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Random;

public class Serveure {

    private int nbClients = 0;

    public String[] proverbes = {
            "Qui cherche trouve",
            "Le temps c'est de l'argent",
            "Petit a petit l'oiseau fait son nid",
            "Après la pluie le beau temps",
            "La patience est une vertu"
    };

    public void init() {

        try {
            ServerSocket ss = new ServerSocket(9080);
            System.out.println("Le serveur de proverbes est en marche");

            while (true) {

                System.out.println("En attente d'une connexion...");
                Socket sc = ss.accept();

                nbClients++;

                String clientName = sc.getInetAddress().getHostName();
                String clientIP = sc.getInetAddress().getHostAddress();

                System.out.println("Nouveau client connecté : " + clientName);
                System.out.println("Adresse IP : " + clientIP);
                System.out.println("Nombre total de clients : " + nbClients);

                clientProcess(sc);
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la connexion");
        }
    }

    public void clientProcess(Socket sc) {

        try {

            PrintWriter out = new PrintWriter(sc.getOutputStream(), true);

            Random rand = new Random();
            String proverbe = proverbes[rand.nextInt(proverbes.length)];

            out.println(proverbe);

            sc.close();

        } catch (IOException e) {
            System.out.println("Erreur client");
        }
    }

    public static void main(String[] args) {

        Serveure serveur = new Serveure();
        serveur.init();

    }
}