package SerCli;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import SerCli.ServInt;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientUser {
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
        System.out.println("Connected to server \n");
        while(true) {
            System.out.print("Chose function: close, create_task, get_status, close_task, reopen_task \n");
            message = in.nextLine();
            if(user(port, message) == 1)
                break;
        }
        in.close();
    }
    public static int user(ServInt port, String mes){
        String[] message = mes.trim().split(" ");
        if("create_task".equals(message[0])){
            System.out.print(port.createTask(message[1], message[2], message[3], message[4]) + "\n");
            return 0;
        }
        if("close".equals(message[0])){
            System.out.print("Client closed!\n");
            return 1;
        }
        if("get_status".equals(message[0])){
            int id = -1;
            try{
                id = Integer.parseInt(message[1]);
            } catch (Exception e){
                return 1;
            }
            System.out.print(port.getStatus(id) + "\n");
            return 0;
        }
        
        if("close_task".equals(message[0])){
            int id = -1;
            try{
                id = Integer.parseInt(message[1]);
            } catch (Exception e){
                return 1;
            }
            System.out.print(port.closeTask(id) + "\n");
            return 0;
        }
        
        if("reopen_task".equals(message[0])){
            int id = -1;
            try{
                id = Integer.parseInt(message[1]);
            } catch (Exception e){
                return 1;
            }
            System.out.print(port.reopenTask(id, message[2]) + "\n");
            return 0;
        }
        
        System.out.print("Uncorectly \n");
        return 0;
    }
}
