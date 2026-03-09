package TCP.Ex1.Ex2;

import java.io.PrintWriter;
import java.net.Socket;


public class ThreadServeurWebRunnable implements Runnable{

        private Socket socket;
        private String corps;

        public ThreadServeurWebRunnable(Socket socket, String corps) {
            this.socket = socket;
            this.corps = corps;
        }

        public void run() {

            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("HTTP/1.0 200 OK");
                out.println("Content-Type: text/html; charset=UTF-8"); // Ligne à ajouter
                out.println(); // Ligne vide obligatoire entre les headers et le corps
                out.println(corps);
                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

