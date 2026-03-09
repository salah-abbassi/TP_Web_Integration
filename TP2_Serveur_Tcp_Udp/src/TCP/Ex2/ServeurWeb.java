package TCP.Ex1.Ex2;

import java.net.*;
import java.io.*;

public class ServeurWeb {

    public void init() {
        try {
            ServerSocket serveur = new ServerSocket(8000);
            System.out.println("Serveur web démarré sur le port 8000");
            while (true) {
                Socket client = serveur.accept();
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                String corps =
                        "<HTML><TITLE>Mon serveur</TITLE>Cette page a été envoyée par mon <B>Serveur </B></HTML>";
                out.println("HTTP/1.0 200 OK");
                out.println();
                out.println(corps);

                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ServeurWeb serveurWeb = new ServeurWeb();
        serveurWeb.init();

    }
}