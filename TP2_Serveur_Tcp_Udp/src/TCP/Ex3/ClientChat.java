package Ex3;

import java.net.*;
import java.io.*;

public class ClientChat {

    public static void main(String[] args) {

        // Paramètres de connexion au serveur local
        String serveur = "localhost";
        int port = 5000;

        try {
            // Demande de connexion et établissement du socket avec le serveur
            Socket socket = new Socket(serveur, port);

            // Flux pour capturer ce que l'utilisateur tape au clavier
            BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

            // Flux pour lire les messages provenant du serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Flux pour envoyer des données au serveur (le "true" active l'auto-flush)
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Entrer votre pseudo : ");
            String pseudo = clavier.readLine();

            // Envoie le pseudo comme tout premier message pour identifier le client
            out.println(pseudo);

            // Création d'un thread dédié uniquement à la réception des messages
            Thread reception = new Thread(new Runnable() {
                public void run() {
                    try {
                        String message;
                        // Écoute en continu le serveur sans bloquer le reste du programme
                        while ((message = in.readLine()) != null) {
                            System.out.println(message);
                        }
                    } catch (IOException e) {
                        System.out.println("Connexion fermée");
                    }
                }
            });

            // Démarre l'écoute en arrière-plan
            reception.start();

            // Le thread principal reste bloqué ici à attendre les saisies clavier pour les envoyer
            String msg;
            while ((msg = clavier.readLine()) != null) {
                out.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}