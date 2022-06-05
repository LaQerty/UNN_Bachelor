
package client_server;
import java.net.*;
import java.io.*;



class ClientSetup{
    
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private BufferedReader inputUser;
    private String addr;
    private int port;

    
    public ClientSetup(String addr, int port) {
        this.addr = addr;
        this.port = port;
        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            new ReadMsg().start();
            new WriteMsg().start();
        } catch (IOException e) {
            ClientSetup.this.downService();
        }
    }
    
    
    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {}
    }
    
    private class ReadMsg extends Thread {
        @Override
        public void run() {
            
            String str;
            try {
                while (true) {
                    str = in.readLine();
                    if (str.equals("stop")) {
                        ClientSetup.this.downService();
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                ClientSetup.this.downService();
            }
        }
    }
    
    public class WriteMsg extends Thread {
        
        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    userWord = inputUser.readLine();
                    if (userWord.equals("stop")) {
                        out.write("stop" + "\n");
                        ClientSetup.this.downService();
                        break;
                    } else {
                        out.write(userWord + "\n");
                    }
                    out.flush();
                } catch (IOException e) {
                    ClientSetup.this.downService();
                    
                }
                
            }
        }
    }
}

public class Client{
    
    public static String ipAddr = "localhost";
    public static int port = 8080;
    public static void main(String[] args) {
        new ClientSetup(ipAddr, port);
    }
}