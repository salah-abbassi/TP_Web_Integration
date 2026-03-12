import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

// Contrat RMI partagé : expose les méthodes que le client peut invoquer sur le serveur (RemoteBank)
public interface IRemoteBank extends Remote {

    // Lit le solde à distance via la position du compte dans la liste du serveur
    int getSolde(int index) throws RemoteException;

    // Lit le nom du propriétaire à distance via la position du compte
    String getName(int index) throws RemoteException;

    // Transmet un objet Compte du client vers le serveur (nécessite que Compte implémente Serializable)
    void addCompte(Compte compte) throws RemoteException;

    // Transmet un lot de comptes en une seule requête réseau (optimise les performances)
    void bulkCompte(List<Compte> comptes) throws RemoteException;
}