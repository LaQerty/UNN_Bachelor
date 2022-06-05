package ClientServer;
                
import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out; 

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 4004);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("* this is a cell that needs to be surrounded to get a point. "
                    + "To leave, use the syntax 11l, where 1 is the first cell vertically 1 horizontally"
                    + " l is the left side(r is the right, u is up, d is down). ");  
                String word = "";
                while(word != "exit") {
                    word = reader.readLine();
                    out.write(word + "\n");
                    out.flush();
                    String serverWord = in.readLine();
                    serverWord = serverWord.replaceAll(",", "\n");
                    System.out.println(serverWord);
                }
            } finally {
                System.out.println("Client close...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
