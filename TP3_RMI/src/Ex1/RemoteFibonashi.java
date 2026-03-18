package Ex1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteFibonashi extends UnicastRemoteObject implements IRemoteFibonashi {


    protected RemoteFibonashi() throws RemoteException {
        super();

    }

    // Calcul itératif du n-ième terme de Fibonacci (F(0) = 0, F(1) = 1, ...)
    @Override
    public long calculer(int n) {
        if (n < 0) {
            System.out.println("n doit être >= 0");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        long prev = 0;
        long curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
