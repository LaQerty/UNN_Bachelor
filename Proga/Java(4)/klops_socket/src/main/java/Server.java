
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Math;

class ServerSetup extends Thread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    public ServerSetup(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    @Override
    public void run() {
        String word;
        int x = 0;
        int y = 0;
        int count = 0;
        Game newGame = new Game();
        int playerId = newGame.addNewPlayer();
        int serverId = newGame.addNewPlayer();
        String result = fieldToString(newGame.field);
        send(result);
        try {
            try {
                while (true) {
                    word = in.readLine();
                    if(word.equals("stop")) {
                        this.downService();
                        break; 
                    }                
                    x = getMoveFromString(word)[0];
                    y = getMoveFromString(word)[1];
                    if(!newGame.isMyTurn(playerId))
                        send("Your opponent's turn, please wait");
                    while(!newGame.isMyTurn(playerId)) {
                        try{
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                    }
                    boolean success = (x != -1) && (y != -1);
                    if(success){
                        if(!newGame.canSetCell(x, y, playerId)){
                            send("Can't set symbol there");
                        } else{
                            newGame.setCell(x, y, playerId);
                            result = fieldToString(newGame.field);
                            send(result);
                            if(newGame.isGameEnded()){
                                send("You win");
                                send("stop");
                                this.downService();
                                break;
                            }
                            count++;
                        }
                    } 
                    if(count == 3){
                        newGame.endTurn();
                        send("Server`s turn");
                        for(int i = 0; i < 3; i++){
                            int a = (int) (1 + Math.random()*10);
                            int b = (int) (1 + Math.random()*10);
                            while(!newGame.canSetCell(a, b, serverId)){
                                a = (int) (1 + Math.random()*10);
                                b = (int) (1 + Math.random()*10);
                            }
                            newGame.setCell(a, b, serverId);
                            result = fieldToString(newGame.field);
                        }
                        send(result);
                        if(newGame.isGameEnded()){
                            send("You lose");
                            send("stop");
                            this.downService();
                            break;
                        }
                        count = 0;
                        newGame.endTurn();
                    }
                }
            } catch (NullPointerException ignored) {}
        } catch (IOException e) {
            this.downService();
        }
    }
    public static String fieldToString(char[][] field) {
        char[] horizonatal = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        char[] vertical = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String res ="";
        for (int i = 1; i < 11; ++i) {
            res+=vertical[i - 1] + " ";
            for(int j = 1; j < 11; ++j) {
                res+=field[j][i] + " ";
            }
            res+="\n";
        }
        res+="  ";
        for (int i = 0; i < 10; ++i) {
            res+=horizonatal[i] + " ";
        }
        res+="\n";
        return res;
    }
    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {}

    }

    private void downService() {
            try {
            if(!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {}
    }
    public static int[] getMoveFromString(String word) {
        int[] res = {-1, -1};
        char str[] = word.toCharArray();
        int num1 = (int)str[0];
        int num2 = (int)str[1];
        if(num1 < 107 & num1 > 96)
            res[0]=num1-97;
        if(num2 < 58 & num2 > 47)
            res[1]=num2-48;
        return res;
    }
}

public class Server {

    public static final int PORT = 8080;
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server Start" +  "\n" );
        try {
            while (true) {
                Socket socket = server.accept();
                try {
                   new ServerSetup(socket);
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}