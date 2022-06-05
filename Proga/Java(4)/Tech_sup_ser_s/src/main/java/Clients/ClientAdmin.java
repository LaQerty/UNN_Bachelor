package Clients;

import ServerSide.SerInterface;
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class ClientAdmin {
   public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String mes;
        Service service = Service.create(
        new URL(String.format("http://localhost:%d/MyLab?wsdl",8000)),
        new QName("http://ServerSide/", "ServerService"));
        SerInterface port = service.getPort(
        new QName("http://ServerSide/", "ServerPort"),
        SerInterface.class);
        System.out.println("You can: \n1) Get all request\n2) Take request to work \n3) Mark the request as completed\n");
        while((mes = in.nextLine())!= "exit"){
            int id;
            switch(mes){
                case "1":
                    System.out.println(port.allRequest());
                    break;
                case "2":
                    System.out.println("Enter request`s id: \n");
                    id = Integer.valueOf(in.nextLine());
                    port.startRequest(id);
                    break;
                case "3":
                    System.out.println("Enter request`s id: \n");
                    id = Integer.valueOf(in.nextLine());
                    System.out.println("Enter text: \n");
                    String text = in.nextLine();
                    port.doneRequest(id, text);
                    break;
                default :
                    System.out.println("Uncorectly! \n");
                    break;
            }
        }
        in.close();
    } 
}
