package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ServerService extends Remote {
    public String move(int x, int y, String str) throws RemoteException;
    public String serverMove() throws RemoteException;
    public String setWinCell(int x, int y, char str) throws RemoteException;
    public boolean isGameEnded() throws RemoteException;
    public boolean isCellDone(int x, int y) throws RemoteException;
    public String getField() throws RemoteException;
}
