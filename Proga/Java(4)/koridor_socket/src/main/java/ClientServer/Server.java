package ClientServer;

import Game.Game;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server { 
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedReader in1;
    private static BufferedWriter out;
    public static String random(){
        int one = (int) (Math.random()*3 + 1);
        int two = (int) (Math.random()*3 + 1);
        int three = (int) (Math.random()*4);
        char[] str = {'l','r','d','u'};
        String res = String.valueOf(one) + String.valueOf(two)+str[three];
        return res;
    }
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        int server_point = 0;
        int client_point = 0;
        try {
            try  {
                server = new ServerSocket(4004);
                System.out.println("Server Start!");
                clientSocket = server.accept();
                try { 
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    in1 = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String mes = in.readLine();
                    String q = "";
                    out.write(game.fieldToString() + "\n");                
                    out.flush();
                    while(mes != "exit") {
                            boolean flag = true;
                            while(flag){
                                mes = in.readLine();
                                String res = game.move(mes);
                                if(res == "Good!"){
                                    out.write(game.fieldToString() +"Enter next" + "\n");                
                                    out.flush();
                                    flag=false;
                                    q = in1.readLine();
                                    if(game.getPoint(mes)){
                                        client_point++;
                                        flag=true;
                                        out.write("You get a point. Now you have: " + client_point + " Move more." + "\n");                
                                        out.flush();
                                    }
                                } else {
                                    out.write(res + "\n");                
                                    out.flush();
                                }
                            }
                            out.write("Server attempt.,Enter next!" + "\n");                
                            out.flush();
                            q = in1.readLine();
                            flag = true;
                            while(flag){
                                String move = random();
                                String res = game.move(move);
                                if(res == "Good!") {
                                    flag=false;
                                    if(game.getPoint(move)){
                                        server_point++;
                                        flag=true;
                                        out.write("Server got a point. Now server have: " + server_point + ",Enter next!" + "\n");                
                                        out.flush();
                                        q = in1.readLine();
                                    }
                                    out.write(game.fieldToString() + "\n");                
                                    out.flush();
                                }
                            }
                    }
                } finally {
                    clientSocket.close();
                    in.close();
                    in1.close();
                    out.close();
                }
            } finally {
                System.out.println("Server close");
                    server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }            
    }
}
