package Server;

import Game.Game;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Server implements ServerService{
    public static final String UNIC_BINDING_NAME = "server";
    Game game = new Game();
    
    @Override
    public String move(int x, int y, String str) throws RemoteException {
        return game.move(x, y, str);
    }

    @Override
    public String serverMove() throws RemoteException {
        String res = "";
        String str = "";
        int  x = -1,y = -1;
        boolean flag = true;
        while(flag){
            flag = false;
            res = "Ypu cant move";
            while(res == "Ypu cant move"){
                x = (int) (Math.random()*3);
                y = (int) (Math.random()*3);
                int  c = (int) (Math.random()*4);
                if( c == 0) str= "left";
                if( c == 1) str= "right";
                if( c == 2) str= "up";
                if( c == 3) str= "down";
                res = game.move(x,y,str);
            }
            if("left".equals(str)){
                if(y != 0){
                    if(game.isDone(x,y)){
                        flag = true;
                    } else if(game.isDone(x,y-1)){
                        flag = true;
                        y--;
                    }
                } else flag = game.isDone(x,y);
            }
            if("right".equals(str)){
                if(y != 2){
                    if(game.isDone(x,y)){
                        flag = true;
                    } else if(game.isDone(x,y+1)){
                        flag = true;
                        y++;
                    }
                } else flag = game.isDone(x,y);
            }
            if("up".equals(str)){
                if(x != 0){
                    if(game.isDone(x,y)){
                        flag = true;
                    } else if(game.isDone(x-1,y)){
                        flag = true;
                        x--;
                    }
                } else flag = game.isDone(x,y);
            }
            if("down".equals(str)){
                if(x != 2){
                    if(game.isDone(x,y)){
                        flag = true;
                    } else if(game.isDone(x+1,y)){
                        flag = true;
                        x++;
                    }
                } else flag = game.isDone(x,y);
            }
            if(flag){
                res = game.setWinCell(x, y, 'S');
            }
        }
        return res;
    }

    @Override
    public boolean isGameEnded() throws RemoteException {
        return game.isGameEnd();
    }

    @Override
    public boolean isCellDone(int x, int y) throws RemoteException {
        return game.isDone(x, y);
    }

    @Override
    public String getField() throws RemoteException {
        return game.fieldToString();
    }
    
    @Override
    public String setWinCell(int x, int y, char str) throws RemoteException {
        return game.setWinCell(x, y, str);
    }
    
    public static void main(String[] args) throws Exception {
        final Server service = new Server();
        final Registry registry = LocateRegistry.createRegistry(8080);
        Remote stub = UnicastRemoteObject.exportObject(service, 0);
        registry.bind(UNIC_BINDING_NAME, stub);
    }
}
