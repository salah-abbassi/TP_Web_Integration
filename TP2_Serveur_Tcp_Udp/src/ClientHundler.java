import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ClientHundler {
    private Socket socket;

    public  ClientHundler(Socket socket) {
        this.socket = socket;

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
}
