import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

// Contrat RMI partagé : expose les services demandés dans l'énoncé
public interface IRemoteBank extends Remote {

    // Consulter le solde d'un client par son id
    int getSolde(int id) throws RemoteException;

    // Retourner le nom du client possédant un compte (via id)
    String getName(int id) throws RemoteException;

    // Demander le retrait d'une somme du compte d'un client
    // Retourne true si l'opération a réussi (solde suffisant), false sinon.
    boolean retirer(int id, int montant) throws RemoteException;

    // Transférer une somme d'un client vers un autre (par id)
    // Retourne true si le transfert a réussi, false sinon.
    boolean transferer(int fromId, int toId, int montant) throws RemoteException;

    // Récupérer un objet compte d'un client par id
    Compte getCompte(int id) throws RemoteException;

    // Méthode utilitaire pour peupler la banque côté serveur
    void bulkCompte(List<Compte> comptes) throws RemoteException;
}