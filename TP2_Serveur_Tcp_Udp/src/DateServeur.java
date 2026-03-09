import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServeur {
    private int nbClients = 0;
    public void init() {
        try {
            ServerSocket ss = new ServerSocket(9080);
            System.out.println("Le serveur de Date en marche");

            while (true) {
                System.out.println("En attente d'une connexion...");
                Socket sc = ss.accept();
                nbClients++;

                System.out.println("Le serveur de Date en marche de l'utilisateur...");
                String clientName = sc.getInetAddress().getHostName();
                String clientIP = sc.getInetAddress().getHostAddress();

                System.out.println("Nouveau client connecté : " + clientName);
                System.out.println("Adresse IP : " + clientIP);
                System.out.println("Nombre total de clients : " + nbClients);

                clientProcess(sc);            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la connexion");
        }
    }

    public void clientProcess(Socket sc) {
        try {
            PrintWriter out = new PrintWriter(sc.getOutputStream(), true);
            out.println(new Date());

            sc.close();

        } catch (IOException e) {
            System.out.println("Erreur client");
        }
    }

    public static void main(String[] args) {
        DateServeur serveur = new DateServeur();
        serveur.init();
    }
}