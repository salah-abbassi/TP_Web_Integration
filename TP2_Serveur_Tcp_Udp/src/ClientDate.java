import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.in;

public class ClientDate {

    public static void main(String[] args) {
        try{
            Socket s =new Socket("localhost",9080);
            Scanner in = new Scanner(s.getInputStream());
            System.out.println("La date recue paar le serveur est  :"+ in.nextLine()   );
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
