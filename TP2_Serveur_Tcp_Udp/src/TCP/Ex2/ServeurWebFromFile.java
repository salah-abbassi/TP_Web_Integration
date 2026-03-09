package TCP.Ex1.Ex2;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class ServeurWebFromFile {
    static String corps = "" ;

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
            ServerSocket serveur = new ServerSocket(8000);
            System.out.println("Serveur web démarré sur le port 8000");
            while (true) {
                Socket client = serveur.accept();
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println("HTTP/1.0 200 OK");
                out.println("Content-Type: text/html; charset=UTF-8"); // Ligne à ajouter
                out.println(); // Ligne vide obligatoire entre les headers et le corps
                out.println(corps);
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ServeurWebFromFile serveurWebFromFile1 = new ServeurWebFromFile();
        serveurWebFromFile1.init();

    }
}
