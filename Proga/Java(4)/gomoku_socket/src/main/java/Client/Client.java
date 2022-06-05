package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class Client {
    private static Socket clientSocket;
    private static BufferedReader consolReader;
    private static BufferedReader in;
    private static BufferedWriter out; 
    public static void main(String[] args) throws IOException {
        clientSocket = new Socket("localhost", 8000);
        consolReader = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        System.out.println("Enter you symbol: \n");
        String userWord = consolReader.readLine();
        out.write(userWord + "\n");
        out.flush();
        System.out.println(in.readLine().replaceAll("q", "\n"));
        while(!"exit".equals(userWord)) {
            
            userWord = consolReader.readLine();
            out.write(userWord + "\n");
            out.flush();
            System.out.println(in.readLine().replaceAll("q", "\n"));
        }
        System.out.println("Client close...");
        clientSocket.close();
        in.close();
        out.close();
    }
}
