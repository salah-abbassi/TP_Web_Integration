package TCP.Ex1;

import java.net.*;
import java.io.*;
import java.util.*;

public class ServeurMultithreading {

        //creer un liste pour stocker les Proverbes
        static List<String> proverbes = new ArrayList<>();
        static int nbClients = 0 ;
    private Runnable ThreadClientRunnable;

    public void init() {
        try {

            chargerProverbes();

            ServerSocket ss = new ServerSocket(9080);
            System.out.println("Le serveur de proverbes est en marche");

            Random rand = new Random();

            while (true) {

                System.out.println("En attente d'une connexion...");

                Socket sc = ss.accept();

                nbClients++;

                String clientName = sc.getInetAddress().getHostName();
                String clientIP = sc.getInetAddress().getHostAddress();

                System.out.println("Nouveau client : " + clientName);
                System.out.println("IP : " + clientIP);
                System.out.println("Nombre clients : " + nbClients);

                Thread t = new Thread(new ThreadClientRunnable(sc, proverbes));
                t.start();
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la connexion");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




    public static void chargerProverbes() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("proverbes.txt"));
        String ligne;

        while ((ligne = br.readLine()) != null) {
            proverbes.add(ligne);
        }

        br.close();
    }

        public static void main(String[] args) {
            ServeurMultithreading serveur = new ServeurMultithreading();
            serveur.init();
        }
}
