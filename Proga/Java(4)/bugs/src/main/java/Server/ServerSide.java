package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerSide extends Remote {
    public String clientMove(int x, int y) throws RemoteException;
    public String serverMove() throws RemoteException;
    public boolean end() throws RemoteException;
    public String getField() throws RemoteException;
}
