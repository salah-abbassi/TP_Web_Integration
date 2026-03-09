package TCP.Ex1;

import java.net.*;
import java.io.*;
import java.util.*;
public class ThreadClientRunnable implements Runnable{

        private Socket socket;
        private List<String> proverbes;

        public ThreadClientRunnable(Socket socket, List<String> proverbes) {
            this.socket = socket;
            this.proverbes = proverbes;
        }

        public void run() {

            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                Random rand = new Random();
                String proverbe = proverbes.get(rand.nextInt(proverbes.size()));

                out.println(proverbe);

                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}