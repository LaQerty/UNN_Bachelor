package Server;

import Gomoku.Gomoku;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;
    
    public static int random(){
        return (int)(Math.random()*10);
    }
    
    public static void main(String[] args) throws InterruptedException, IOException {
        Gomoku g = new Gomoku();
        char clientMark;
        server = new ServerSocket(8000);
        System.out.println("Server Start!");
        clientSocket = server.accept();
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        clientMark = in.readLine().charAt(0);
        out.write(g.fieldToString() + "You Turn! \n");                
        out.flush();
        String cliMes = "";
        while(!"exit".equals(cliMes)){
            boolean end = false;
            while(true){
                cliMes = in.readLine();
                int x = Integer.valueOf(cliMes.split(" ")[0]);
                int y = Integer.valueOf(cliMes.split(" ")[1]);
                if("You cant do it!".equals(g.takeMove(x, y, clientMark))){
                    out.write("You cant do it! \n");                
                    out.flush();
                } else{
                    if(!g.isGameEnd(x, y, clientMark)){
                        break;
                    } else {
                        end = true;
                        out.write("You win! \n");                
                        out.flush();
                        break;
                    }
                }
            }
            if(end) break;
            while(true){
                int x = random();
                int y = random();
                if(!"You cant do it!".equals(g.takeMove(x, y, 's'))){
                    if(!g.isGameEnd(x, y, 's')){
                        out.write(g.fieldToString() + "You Turn! \n");                
                        out.flush();
                        break;
                    } else {
                        end = true;
                        out.write("Server win! \n");                
                        out.flush();
                        break;
                    }
                }
            }
            if(end) break;
        }
        clientSocket.close();
        in.close();
        out.close();
        System.out.println("Server close");
        server.close();
    }
}
