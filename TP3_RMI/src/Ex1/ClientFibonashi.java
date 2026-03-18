package Ex1;

import java.rmi.Naming;

// Client RMI pour tester le service de Fibonacci
public class ClientFibonashi {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage : java Ex1.ClientFibonashi <n>");
            return;
        }

        int n = Integer.parseInt(args[0]);

        // Récupère le stub du service distant
        IRemoteFibonashi fib = (IRemoteFibonashi) Naming.lookup("rmi://127.0.0.1:1099/fibonashi");

        long result = fib.calculer(n);
        System.out.println("F(" + n + ") = " + result);
    }
}

