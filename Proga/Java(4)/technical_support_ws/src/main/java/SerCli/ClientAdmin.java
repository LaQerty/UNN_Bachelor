package SerCli;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import SerCli.ServInt;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientAdmin {
    public static final int port = 8080;
    public static final String url = "http://localhost:%d/HelloDynamic?wsdl";
    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String message;
        Service service = Service.create(
        new URL(String.format(url,port)),
        new QName("http://SerCli/", "ServerService"));
        ServInt port = service.getPort(
        new QName("http://SerCli/", "ServerPort"),
        ServInt.class);
        System.out.println("Connected to server(Admin) \n");
        while(true) {
            System.out.print("Chose function: close, all_task, work, done_task \n");
            message = in.nextLine();
            if(admin(port, message) == 1)
                break;
        }
        in.close();
    }
    
   public static int admin(ServInt port, String mes){
       String[] message = mes.trim().split(" ");
        if("all_task".equals(message[0])){
            System.out.print(port.allTask() + "\n");
            return 0;
        }
        
        if("work".equals(message[0])){
            int id = -1;
            try{
                id = Integer.parseInt(message[1]);
            } catch (Exception e){
                return 1;
            }
            System.out.print(port.work(id) + "\n");
            return 0;
        }
        
        if("done_task".equals(message[0])){
            int id = -1;
            try{
                id = Integer.parseInt(message[1]);
            } catch (Exception e){
                return 1;
            }
            System.out.print(port.done_task(id) + "\n");
            return 0;
        }
        
        if("close".equals(message[0])){
            System.out.print("Client closed!");
            return 1;
        }
        
        System.out.print("Uncorectly!");
        return 0;
   }
}