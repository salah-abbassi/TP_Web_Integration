package Ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Gère la communication avec un client spécifique dans un thread dédié
class ClientHandler implements Runnable {

    // Connexion au client et flux de communication
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String pseudo;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    // Point d'entrée du thread : exécuté lors du t.start() dans le serveur
    public void run() {

        try {
            // Initialisation des flux pour lire (in) et écrire (out) vers ce client
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Le premier message envoyé par le client est considéré comme son pseudo
            pseudo = in.readLine();

            System.out.println(pseudo + " connecté");
            ChatServer.broadcast(">> " + pseudo + " a rejoint le chat", this);

            String message;

            // Boucle d'écoute : lit chaque nouveau message et le diffuse aux autres
            while ((message = in.readLine()) != null) {
                ChatServer.broadcast(pseudo + " : " + message, this);
            }

        } catch (IOException e) {
            // Gère la déconnexion brutale du client
            System.out.println(pseudo + " déconnecté");
        } finally {
            // Nettoyage des ressources à la fin de la connexion
            try {
                socket.close();
            } catch (IOException e) {}

            // Retire le client de la liste globale et notifie les autres de son départ
            ChatServer.clients.remove(this);
            ChatServer.broadcast(">> " + pseudo + " a quitté le chat", this);
        }
    }

    // Méthode appelée par le serveur pour envoyer un message à ce client précis
    public void sendMessage(String message) {
        out.println(message);
    }
}