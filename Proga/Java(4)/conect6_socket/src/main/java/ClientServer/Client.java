package ClientServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class Client {
    private static Socket clientSocket;
    public static void main(String[] args) throws IOException {
        clientSocket = new Socket("localhost", 4040);
        BufferedReader consol = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader read = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        System.out.println("Enter start!\n");
        String userWord = consol.readLine();
        write.write(userWord + "\n");
        write.flush();
        System.out.println(read.readLine().replaceAll("z", "\n"));
        while(!"exit".equals(userWord)) {
            userWord = consol.readLine();
            write.write(userWord + "\n");
            write.flush();
            System.out.println(read.readLine().replaceAll("z", "\n"));
        }
        System.out.println("Client close...");
        clientSocket.close();
        read.close();
        write.close();
        consol.close();
    }
}
