package Client;

import Server.ServInterface;
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ClientUser {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String mes;
        Service service = Service.create(
        new URL(String.format("http://localhost:%d/HelloDynamic?wsdl",8080)),
        new QName("http://Server/", "ServerService"));
        ServInterface serv = service.getPort(
        new QName("http://Server/", "ServerPort"),
        ServInterface.class);
        System.out.println("You connected like user! \n "
                + "You can: \n 1) Get list of all book \n"
                + "2)Take book \n"
                + "3)Return book");
        while((mes = in.nextLine())!=null){
            switch(mes){
                case "1":
                    System.out.println(serv.getAllBook());
                    break;
                case "2":
                    System.out.println("Enter ISBN: \n");
                    String isbn = in.nextLine();
                    System.out.println(serv.takeBook(isbn));
                    break;
                case "3":
                    System.out.println("Enter ISBN: \n");
                    isbn = in.nextLine();
                    System.out.println(serv.returnBook(isbn));
                    break;
            }
        }
        in.close();
    }
}
