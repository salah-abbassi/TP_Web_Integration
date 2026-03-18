package Ex3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

// Interface distante RMI pour les KPIs analytiques sur les ventes
public interface IRemoteVenteAnalytics extends Remote {

    // Ajouter une vente dans le système
    void addVente(Vente v) throws RemoteException;

    // Calculer le chiffre d'affaires total
    double getChiffreAffairesTotal() throws RemoteException;

    // Calculer le chiffre d'affaires par région
    double getChiffreAffairesParRegion(String region) throws RemoteException;

    // Retourner le produit le plus vendu (en terme de montant cumulé)
    String getProduitLePlusVendu() throws RemoteException;

    // Retourner la liste des ventes supérieures à un montant donné
    List<Vente> getVentesSuperieures(double montant) throws RemoteException;

    // Retourner toutes les ventes
    List<Vente> getAllVentes() throws RemoteException;
}

