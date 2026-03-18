package Ex1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteCalcule extends RemoteCalcule  {

    float calculer(int compte) throws RemoteException;

}
