package Server;

import Game.Game;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements ServerSide{
    Game g = new Game();

    @Override
    public String clientMove(int x, int y) throws RemoteException {
        return g.move('c', x, y);
    }

    @Override
    public String serverMove() throws RemoteException {
        int i = 0;
        while( i != 3){
            int x = (int) (Math.random()*10);
            int y = (int) (Math.random()*10);
            if(g.move('s', x, y) != "")
                i++;
            }
        return g.getField();
    }

    @Override
    public boolean end() throws RemoteException {
        return g.end();
    }

    @Override
    public String getField() throws RemoteException {
        return g.getField();
    }
    
    public static void main(String[] args) throws Exception {
        final Server service = new Server();
        final Registry registry = LocateRegistry.createRegistry(4444);
        Remote stub = UnicastRemoteObject.exportObject(service, 0);
        registry.bind("server", stub);
        System.out.println("Server start!");
    }
}
