package Ex1;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Contrat RMI pour le calcul de Fibonacci
// Le client envoie un entier n et le serveur retourne le n-ième terme de la suite de Fibonacci.
public interface IRemoteFibonashi extends Remote {

    long calculer(int n) throws RemoteException;

}
