package Ex3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Implémentation serveur RMI pour les analytics de ventes
public class RemoteVenteAnalytics extends UnicastRemoteObject implements IRemoteVenteAnalytics {

    private final List<Vente> ventes;

    public RemoteVenteAnalytics() throws RemoteException {
        super();
        this.ventes = new ArrayList<>();
    }

    @Override
    public synchronized void addVente(Vente v) throws RemoteException {
        ventes.add(v);
    }

    @Override
    public synchronized double getChiffreAffairesTotal() throws RemoteException {
        double total = 0.0;
        for (Vente v : ventes) {
            total += v.getAmount();
        }
        return total;
    }

    @Override
    public synchronized double getChiffreAffairesParRegion(String region) throws RemoteException {
        double total = 0.0;
        for (Vente v : ventes) {
            if (v.getRegion().equalsIgnoreCase(region)) {
                total += v.getAmount();
            }
        }
        return total;
    }

    @Override
    public synchronized String getProduitLePlusVendu() throws RemoteException {
        if (ventes.isEmpty()) {
            return null;
        }
        Map<String, Double> montantParProduit = new HashMap<>();
        for (Vente v : ventes) {
            montantParProduit.merge(v.getProduct(), v.getAmount(), Double::sum);
        }
        String bestProduct = null;
        double max = -1.0;
        for (Map.Entry<String, Double> e : montantParProduit.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                bestProduct = e.getKey();
            }
        }
        return bestProduct;
    }

    @Override
    public synchronized List<Vente> getVentesSuperieures(double montant) throws RemoteException {
        List<Vente> result = new ArrayList<>();
        for (Vente v : ventes) {
            if (v.getAmount() > montant) {
                result.add(v);
            }
        }
        return result;
    }

    @Override
    public synchronized List<Vente> getAllVentes() throws RemoteException {
        return new ArrayList<>(ventes);
    }
}

