package TCP.Ex1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePrinter {

    String fname;

    public FilePrinter(String f) {
        this.fname = f;
    }

    public void write(String s) throws IOException {

        PrintWriter out = new PrintWriter(new FileWriter(fname));

        out.println(s);        // write into file
        out.close();           // close the file

        System.out.println("Message written in file");
    }
}
