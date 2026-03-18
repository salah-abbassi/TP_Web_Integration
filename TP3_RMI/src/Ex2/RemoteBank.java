import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

// Classe serveur RMI : contient la logique métier et sera exposée aux clients
public class RemoteBank extends UnicastRemoteObject implements IRemoteBank {

    // Base de données locale en mémoire pour stocker les comptes
    private final List<Compte> cs;

    public RemoteBank() throws RemoteException {
        super();
        cs = new ArrayList<>();
    }

    private Compte findById(int id) {
        for (Compte c : cs) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    // Consulter le solde par id
    @Override
    public int getSolde(int id) throws RemoteException {
        Compte c = findById(id);
        if (c == null) {
            throw new RemoteException("Aucun compte trouvé pour id=" + id);
        }
        return c.getSolde();
    }

    // Retourner le nom du client par id
    @Override
    public String getName(int id) throws RemoteException {
        Compte c = findById(id);
        if (c == null) {
            throw new RemoteException("Aucun compte trouvé pour id=" + id);
        }
        return c.getName();
    }

    // Retrait d'une somme
    @Override
    public boolean retirer(int id, int montant) throws RemoteException {
        if (montant <= 0) {
            return false;
        }
        Compte c = findById(id);
        if (c == null) {
            return false;
        }
        if (c.getSolde() < montant) {
            return false;
        }
        c.setSolde(c.getSolde() - montant);
        return true;
    }

    // Transfert entre deux comptes
    @Override
    public boolean transferer(int fromId, int toId, int montant) throws RemoteException {
        if (montant <= 0) {
            return false;
        }
        Compte from = findById(fromId);
        Compte to = findById(toId);
        if (from == null || to == null) {
            return false;
        }
        if (from.getSolde() < montant) {
            return false;
        }
        from.setSolde(from.getSolde() - montant);
        to.setSolde(to.getSolde() + montant);
        return true;
    }

    // Récupérer un objet Compte par id
    @Override
    public Compte getCompte(int id) throws RemoteException {
        Compte c = findById(id);
        if (c == null) {
            throw new RemoteException("Aucun compte trouvé pour id=" + id);
        }
        return c;
    }

    // Peupler la banque en mémoire
    @Override
    public void bulkCompte(List<Compte> comptes) throws RemoteException {
        cs.addAll(comptes);
    }
}