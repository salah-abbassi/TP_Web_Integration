import java.io.*;
import java.io.BufferedReader;


public class FluxInputOutput_Caractaire_Reader {
    String fname ;

    public FluxInputOutput_Caractaire_Reader(String f) {
        fname = f ;
    }

    public void read() {
        String ligne = null ;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fname));
            while((ligne = in.readLine())!=null){
                System.out.println(ligne);
            }
        } catch (Exception  e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new FluxInputOutput_Caractaire_Reader("source.txt");
    }
}
