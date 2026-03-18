import java.rmi.Naming;

// Client RMI : se connecte au serveur pour consommer les services de la banque
public class ClientBankPopulaire {
    public static void main(String[] args) throws Exception {

        // Interroge l'annuaire RMI local (127.0.0.1:1099) pour trouver le service "mabank"
        // Récupère le "stub" (représentant local) et le caste via le contrat commun IRemoteBank
        IRemoteBank bp = (IRemoteBank) Naming.lookup("rmi://127.0.0.1:1099/mabank");

        // Exemple : consulter le nom et le solde du client d'id 1
        System.out.println("Nom du client 1 : " + bp.getName(1));
        System.out.println("Solde du client 1 : " + bp.getSolde(1) + " DHs");

        // Exemple : retrait de 500 DHs du client 1
        boolean retraitOk = bp.retirer(1, 500);
        System.out.println("Retrait 500 DHs client 1 : " + (retraitOk ? "OK" : "ECHEC"));
        System.out.println("Nouveau solde client 1 : " + bp.getSolde(1) + " DHs");

        // Exemple : transfert de 300 DHs du client 1 vers le client 2
        boolean transfertOk = bp.transferer(1, 2, 300);
        System.out.println("Transfert 300 DHs de 1 vers 2 : " + (transfertOk ? "OK" : "ECHEC"));
        System.out.println("Solde client 1 : " + bp.getSolde(1) + " DHs");
        System.out.println("Solde client 2 : " + bp.getSolde(2) + " DHs");

        // Exemple : récupération de l'objet Compte complet
        Compte c1 = bp.getCompte(1);
        System.out.println("Compte 1 -> id=" + c1.getId() + ", nom=" + c1.getName() + ", solde=" + c1.getSolde());
    }
}