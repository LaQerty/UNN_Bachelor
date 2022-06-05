package Client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import Server.ServerInter;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientTeach {
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
    System.out.println("Connected to server(Admin)");
    while((mes = in.nextLine())!= null){
        if(clientSide(port, mes) == 1)
           System.out.println("Uncorrectly");
    }
    in.close();
}
private static int clientSide(ServerInter port, String mes){
    String[] message = mes.trim().split(" ");

    switch (message[0]) {
        case "create_test":
            if(message.length == 2){
                System.out.println(port.createTest(message[1]));
                break;
            } else {
                System.out.println("Uncorrectly");
                break;
            }
        case "create_question":
            if(message.length == 3){
                int id = -1;
                try{
                    id = Integer.parseInt(message[2]);
                } catch (Exception e){
                    return 1;
                }
                System.out.println(port.createQuestion(message[1], id));
                break;
            } else {
                System.out.println("Uncorrectly");
                break;
            }
        case "create_answer" :
            if(message.length >= 5) {
                int test_id = -1;
                int quest_id = -1;
                try{
                    test_id = Integer.parseInt(message[1]);
                    quest_id = Integer.parseInt(message[2]);
                } catch (Exception e){
                    return 1;
                }
                ArrayList<String> arr = new ArrayList();
                for(int i = 3; i < message.length; i++){
                    int j = 0;
                    arr.add(message[i]);
                }
                System.out.println(port.createAnswer(test_id, quest_id, arr));
                break;
            } else {
                System.out.println("Uncorrectly");
                break;
            }
        default : 
            System.out.println("Uncorrectly");
            break;
    }
    return 0;
}
}
