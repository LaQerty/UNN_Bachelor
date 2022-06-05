package Clients;

import ServerSide.SerInterface;
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class ClientUser {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String mes;
        Service service = Service.create(
        new URL(String.format("http://localhost:%d/MyLab?wsdl",8000)),
        new QName("http://ServerSide/", "ServerService"));
        SerInterface port = service.getPort(
        new QName("http://ServerSide/", "ServerPort"),
        SerInterface.class);
        System.out.println("You can: \n1) Create request\n2) Get status \n3) Confirm execution \n4) Unconfirm execution\n");
        while((mes = in.nextLine())!= "exit"){
            int id;
            switch(mes){
                case "1":
                    System.out.println("Enter your name: \n");
                    String name = in.nextLine();
                    System.out.println("Enter your email: \n");
                    String email = in.nextLine();
                    System.out.println("Enter text: \n");
                    String text = in.nextLine();
                    System.out.println("ID: " + port.createRequest(name, email, text));
                    break;
                case "2":
                    System.out.println("Enter request`s id: \n");
                    id = Integer.valueOf(in.nextLine());
                    System.out.println(port.getStatus(id));
                    break;
                case "3":
                    System.out.println("Enter request`s id: \n");
                    id = Integer.valueOf(in.nextLine());
                    port.confirmExecution(id);
                    break;
                case "4":
                    System.out.println("Enter request`s id: \n");
                    id = Integer.valueOf(in.nextLine());
                    System.out.println("Enter text: \n");
                    String text1 = in.nextLine();
                    port.unconfirmExecution(id, text1);
                    break;
                default :
                    System.out.println("Uncorectly! \n");
                    break;
            }
        }
        in.close();
    }
}
