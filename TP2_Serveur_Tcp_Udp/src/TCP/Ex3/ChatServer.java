package Ex3;
import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer {

    // Liste stockant tous les clients connectés au serveur
    static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        int port = 5000;

        try {
            // Création du socket serveur sur le port défini
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Serveur démarré sur le port " + port);

            // Boucle infinie pour maintenir le serveur à l'écoute
            while (true) {
                // Bloque jusqu'à ce qu'un nouveau client se connecte
                Socket socket = serverSocket.accept();
                ClientHandler client = new ClientHandler(socket);

                // Ajoute le nouveau client à la liste globale
                clients.add(client);

                // Lance un thread dédié pour gérer ce client sans bloquer le serveur
                Thread t = new Thread(client);
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Diffuse un message à tous les clients connectés, sauf à celui qui l'a envoyé
    public static void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            // Vérifie que le client cible n'est pas l'expéditeur d'origine
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }
}