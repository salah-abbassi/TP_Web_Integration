## Mini-projet RMI - Banque

### Compte
- **Rôle**: représente un compte bancaire.
- **Contenu**: deux attributs (`solde`, `Name`) + constructeurs + getters/setters.

### IRemoteBank
- **Rôle**: interface distante RMI, ce que les clients ont le droit d’appeler à distance.
- **Contenu**: méthodes `getSolde`, `getName`, `addCompte`, `bulkCompte` qui lèvent `RemoteException`.

### RemoteBank
- **Rôle**: implémentation côté serveur de l’interface distante.
- **Contenu**: étend `UnicastRemoteObject`, garde une liste de `Compte`, implémente les méthodes (`getSolde`, `getName`, etc.) qui travaillent sur cette liste.

### BankServeur
- **Rôle**: programme serveur RMI.
- **Ce qu’il fait**:
  - Crée le registre RMI (`LocateRegistry.createRegistry(1099)`),
  - Instancie `RemoteBank`,
  - Ajoute deux comptes de test (`Ahmed`, `Salah`),
  - Publie l’objet sous le nom `"mabank"` dans le registre avec `Naming.rebind(...)`.

### ClientBankPopulaire
- **Rôle**: programme client RMI.
- **Ce qu’il fait**:
  - Va chercher l’objet distant publié dans le registre (`Naming.lookup(...)`),
  - Appelle à distance `getName(0)` et `getSolde(1)` et affiche les résultats.

