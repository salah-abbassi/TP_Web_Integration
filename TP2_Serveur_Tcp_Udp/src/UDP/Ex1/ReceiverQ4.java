package UDP.Ex1;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class ReceiverQ4 {

        public static void main(String[] args) {

            if(args.length != 1){
                System.out.println("Usage: java Receiver <port>");
                return;
            }

            int port = Integer.parseInt(args[0]);

            try {

                DatagramSocket socket = new DatagramSocket(port);
                byte[] buffer = new byte[1024];

                System.out.println("Receiver en attente sur le port " + port);

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                socket.receive(packet);

                String message = new String(packet.getData(),0,packet.getLength());

                System.out.println("Message reçu : " + message);

                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
