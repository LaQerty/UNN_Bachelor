package Client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import Server.ServerInter;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientChild {
public static final int port = 8080;
public static final String url = "http://localhost:%d/HelloDynamic?wsdl";
public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    String mes;
    Service service = Service.create(
    new URL(String.format(url,port)),
    new QName("http://Server/", "ServerService"));
    ServerInter port = service.getPort(
    new QName("http://Server/", "ServerPort"),
    ServerInter.class);
    System.out.println("Connected to server");
    while((mes = in.nextLine())!=null){
        clientSide(port, mes);
    }
    in.close();
}
private static int clientSide(ServerInter port, String mes){
    String[] message = mes.trim().split(" ");
    switch (message[0]) {
        case "all_test":
            System.out.println(port.allTest());
            break;
        case "start":
            if(message.length == 2){
                int id = -1;
                try{
                    id = Integer.parseInt(message[1]);
                } catch (Exception e){
                    return 1;
                }
                System.out.println(port.startCh(id));
                break;
            } else {
                System.out.println("Uncorrectly");
                break;
            }
        case "answer":
            if(message.length >= 2){
                ArrayList<Integer> array = new ArrayList<Integer>();
                for(int i = 1; i < message.length; ++i){
                    int q = -1;
                    try{
                        q = Integer.parseInt(message[i]);
                    } catch (Exception e){
                        System.out.println("Parse error");
                        return 1;
                    }
                     array.add(q);
                }
                System.out.println(port.answer(array));
                break;
            } else {
                System.out.println("Uncorrectly");
                break;
            }
            
        case "finish":
            System.out.println(port.finish());
            break;
        case"get_score":
            System.out.println(port.getScore());
            break;
        default:
            System.out.println("Uncorrectly");
            break;
    }
    return 0;
}
}
