package Ex1;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class FibonashiServeure {
    public static void main(String[] args) {
        try {
            // Démarre l'annuaire RMI (registre) sur le port standard 1099
            LocateRegistry.createRegistry(1099);

            // Instancie l'implémentation locale du service de Fibonacci
            RemoteFibonashi service = new RemoteFibonashi();

            // Publie l'objet distant sous le nom "fibonashi" dans le registre RMI
            Naming.rebind("rmi://localhost:1099/fibonashi", service);

            System.out.println("Le serveur fibonashi est maintenant en marche ....");
        } catch (Exception e) {
            e.printStackTrace(); // Affiche les erreurs liées au réseau ou au port déjà utilisé
        }
    }
}
