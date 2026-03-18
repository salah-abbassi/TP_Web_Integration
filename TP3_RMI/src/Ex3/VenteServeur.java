package Ex3;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

// Serveur RMI pour le service d'analytics de ventes
public class VenteServeur {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            RemoteVenteAnalytics service = new RemoteVenteAnalytics();

            // Quelques ventes de test
            service.addVente(new Vente(1, "PC", "Nord", 10000.0, "2025-01-10"));
            service.addVente(new Vente(2, "Imprimante", "Sud", 2500.0, "2025-01-11"));
            service.addVente(new Vente(3, "PC", "Nord", 8000.0, "2025-02-01"));
            service.addVente(new Vente(4, "Scanner", "Est", 3000.0, "2025-02-05"));
            service.addVente(new Vente(5, "PC", "Sud", 6000.0, "2025-02-10"));

            Naming.rebind("rmi://localhost:1099/ventes", service);

            System.out.println("Serveur de ventes RMI en marche...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

