package TCP.Ex1.Ex2;


import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;


public class ServeurWebMultithreading {

        //creer un liste pour stocker les Proverbes
        static String corps = "" ;
        static int nbClients = 0 ;
        static int Port = 8000 ;
        public static void chargerHtml() throws Exception {
            StringBuilder constructeurCorps = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader("Html.txt"))){
                String ligne ;
                while ((ligne = br.readLine()) != null) {
                    constructeurCorps.append(ligne).append("\n");
            }
            corps = constructeurCorps.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
        public void init() {
            try {
                chargerHtml();
                ServerSocket ss = new ServerSocket(Port);
                System.out.println("Serveur web démarré sur le port "+Port);

                while (true) {
                    Socket sc = ss.accept();
                    Thread t = new Thread(new ThreadServeurWebRunnable(sc, corps));
                    t.start();
                    nbClients++;
                    String clientIP = sc.getInetAddress().getHostAddress();
                    System.out.println("Nouveau Client connecter avec l'Adresse IP : " + clientIP);
                    System.out.println("Nombre total de clients : " + nbClients);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static void main(String[] args) {
            ServeurWebMultithreading serveur = new ServeurWebMultithreading();
            serveur.init();
        } }

