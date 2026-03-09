import TCP.Ex1.FilePrinter;


//test de creer un fichier avec FilePrinter
public class Main {
  public static void main(String[] args) throws Exception {

      var fp = new FilePrinter("test.txt");
    fp.write("Bonjour tout le monde");

  }
}
