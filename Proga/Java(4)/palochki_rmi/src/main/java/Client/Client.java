package Client;

import Server.ServerService;
import static java.lang.Thread.sleep;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class Client {
    public static final String UNIC_BINDING_NAME = "server";
    public static void main(String[] args) throws Exception{
        final Registry registry = LocateRegistry.getRegistry(8080);
        ServerService service = (ServerService) registry.lookup(UNIC_BINDING_NAME);
        System.out.println("Your move is to select a cell and select a face " + "\n" 
                + "(the cell has corresponding coordinates, for example, the upper left corner is 0 0, and the center is 1 1)." + "\n"
                + " To select a face after the coordinates, select left, right, up, down. Enter everything with a space. \n");
        Scanner in = new Scanner(System.in);
        String userWorld="";
        System.out.println("Enter you symbol(Server`s symbol is 'S') \n");
        userWorld = in.nextLine();
        char sym = userWorld.charAt(0);
        while(!service.isGameEnded()){
            boolean flag = true;
            while(flag){
                flag = false;
                System.out.println("You move!\n");
                System.out.println(service.getField());
                userWorld = in.nextLine();
                int x = Integer.valueOf(userWorld.split(" ")[0]);
                int y = Integer.valueOf(userWorld.split(" ")[1]);
                System.out.println(service.move(x, y, userWorld.split(" ")[2]) + "\n");
                if("left".equals(userWorld.split(" ")[2])){
                    if(y != 0){
                        if(service.isCellDone(x,y)){
                        flag = true;
                        } else if(service.isCellDone(x,y-1)){
                            flag = true;
                            y--;
                        }
                    } else flag = service.isCellDone(x,y);
                }
                if("right".equals(userWorld.split(" ")[2])){
                    if(y != 2){
                        if(service.isCellDone(x,y)){
                        flag = true;
                        } else if(service.isCellDone(x,y+1)){
                            flag = true;
                            y++;
                        }
                    } else flag = service.isCellDone(x,y);
                }
                if("up".equals(userWorld.split(" ")[2])){
                    if(x != 0){
                        if(service.isCellDone(x,y)){
                        flag = true;
                        } else if(service.isCellDone(x-1,y)){
                            flag = true;
                            x--;
                        }
                    } else flag = service.isCellDone(x,y);
                }
                if("down".equals(userWorld.split(" ")[2])){
                    if(x != 2){
                        if(service.isCellDone(x,y)){
                        flag = true;
                        } else if(service.isCellDone(x+1,y)){
                            flag = true;
                            x++;
                        }
                    }else flag = service.isCellDone(x,y);
                }
                if(flag){
                    System.out.println("You comlete cell!");
                    System.out.println(service.setWinCell(x, y, sym) + "\n");
                }
            }
            System.out.println("Server move!\n");
            sleep(2);
            System.out.println(service.serverMove() + "\n");
        }
    }
}
