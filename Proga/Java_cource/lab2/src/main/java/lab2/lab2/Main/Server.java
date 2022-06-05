                                                                        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.lab2.Main;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Server {
    int port = 3124;
    InetAddress host;
    
    Model m;
    
    public Server() {
        
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ServerSocket ss = new ServerSocket(port, 0, host);
            System.out.println("Server started");
            
            int count = 0;
            m = new Model();
            while (true) {
                Socket cs = ss.accept();
                
                count++;
                System.out.println("client connected");
                WCS wcs = new WCS(cs, m);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void main (String[] args) {
        new Server();
    }
    
}
