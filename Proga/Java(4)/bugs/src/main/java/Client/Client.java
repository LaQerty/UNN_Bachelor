package Client;

import Server.ServerSide;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws Exception{
        final Registry registry = LocateRegistry.getRegistry(4444);
        ServerSide service = (ServerSide) registry.lookup("server");
        Scanner consInput = new Scanner(System.in);
        System.out.println(service.getField());
        System.out.println("You move!\n");
        String word;
        while(!service.end()){
            for(int i = 0; i < 3; i++){
                word = consInput.nextLine();
                int x = Integer.valueOf(word.split(" ")[0]);
                int y = Integer.valueOf(word.split(" ")[1]);
                String res = service.clientMove(x, y);
                if(res == ""){
                    System.out.println("Incorrect move!");
                    i--;                    
                }
                System.out.println(res);
                if(i != 2)
                    System.out.println("You move!\n");
            }
            System.out.println("Server`s move!\n");
            System.out.println(service.serverMove());
        }
        consInput.close();
    }
}
