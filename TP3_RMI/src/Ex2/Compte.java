import java.io.Serializable; // Import obligatoire pour le transfert réseau

// Objet métier transféré entre le client et le serveur.
// L'interface Serializable indique à Java que cet objet peut être transformé en octets (pour le réseau).
// Un client est caractérisé par : id, nom et solde.
public class Compte implements Serializable {

    // Attributs encapsulés contenant les données du compte
    private int id;
    private int solde;
    private String name;

    // Constructeur pour initialiser rapidement un compte (utilisé dans le Serveur)
    public Compte(int id, int solde, String name) {
        this.id = id;
        this.solde = solde;
        this.name = name;
    }

    // Constructeur par défaut vide (bonne pratique, souvent requise par la sérialisation)
    public Compte() {
    }

    // --- Accesseurs (Getters / Setters) standards ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}