package Ex1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteCalcule extends UnicastRemoteObject implements IRemoteCalcule {


    protected RemoteCalcule() throws RemoteException {
        super();

    }
}
