package ClientServer;

import Game.Game;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket clientSocket;
    private static ServerSocket serverSocket;
    private static BufferedReader read;
    private static BufferedWriter write;

    public static void main(String[] args) throws InterruptedException, IOException {
        Game game = new Game();
        serverSocket = new ServerSocket(4040);
        System.out.println("Server Start!");
        clientSocket = serverSocket.accept();
        read = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        write = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        read.readLine();
        write.write(game.fieldToString() + "You move!\n");                
        write.flush();
        String mes = "";
        int i = 0;
        int c = 0;
        boolean end = false;
        while(!mes.equals("exit")){
            boolean flag = true;
            while(flag){
                mes = read.readLine();
                int x = Integer.valueOf(mes.split(" ")[0]);
                int y = Integer.valueOf(mes.split(" ")[1]);
                if(i == 0){
                    if(game.move(x, y, 'X')!= "You cant move!z"){
                        write.write(game.fieldToString()+"Enter next!\n");
                        write.flush();
                        i++;
                        read.readLine();
                        break;
                    } else {
                        write.write("You cant do it!\n");
                        write.flush();
                    }
                } else {
                    if(game.move(x, y, 'X')!= "You cant move!z"){
                        if(game.end(x,y,'X')){
                            write.write("You win!\n");
                            write.flush();
                            end = true;
                            break;
                        }
                        if(c == 1){
                            write.write(game.fieldToString()+"Server move!zEnter next!\n");
                            write.flush();
                            c++;
                            read.readLine();
                        }
                        if(c == 0){
                            write.write(game.fieldToString()+"You move!\n");
                            write.flush();
                            c++;
                        }
                        if( c == 2) {
                            c = 0;
                            flag = false;
                        } 
                    } else {
                        write.write("You cant do it!\n");
                        write.flush();
                    }
                }
            }
            if(end) break;
            flag = true;
            while(flag){
                int x = (int)(Math.random()*10);
                int y = (int)(Math.random()*10);
                if(game.move(x, y, 'O')!= "You cant move!z"){
                    if(game.end(x, y, 'O')){
                        write.write("Server win!\n");
                        write.flush();
                        break;
                    }
                    if(c == 1){
                        write.write(game.fieldToString()+"You move!\n");
                        write.flush();
                        c++;
                    }
                    if(c == 0) {
                        write.write(game.fieldToString()+"Server move! Enter next!\n");
                        write.flush();
                        c++;
                        read.readLine();
                    }
                    if( c == 2) {
                        c = 0;
                        flag = false;
                    }
                }
            }
            if(end) break;
        }
        clientSocket.close();
        read.close();
        write.close();
        System.out.println("Server close");
        serverSocket.close();
    }
}
