package ClientServer;

import ClientServer.ServInterface;
import Test.Test;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class ClientChild {
    public static void main(String[] args) throws Exception {
        Service service = Service.create(
        new URL(String.format("http://localhost:%d/HelloDynamic?wsdl",8080)),
        new QName("http://ClientServer/", "ServerService"));
        ServInterface port = service.getPort(
        new QName("http://ClientServer/", "ServerPort"),
        ServInterface.class);
        System.out.println("You connecte to server as children!");
        System.out.println("You can: \n 1)All test \n 2)Start test \n 3)Next question \n 4)Answer \n 5)Close test \n 6)Get score \n");
        Scanner in = new Scanner(System.in);
        String mes ="";
        while(mes != "7"){
            mes = in.nextLine();
            switch (mes) {
            case "1":
                System.out.println(port.allTest() + "\n");
                break;
            case "2":
                System.out.println("Enter test id: \n");
                String name = in.nextLine();
                System.out.println(port.startTest(Integer.valueOf(name)) + "\n");
                break;
            case "3":
                System.out.println("Enter test id: \n");
                name = in.nextLine();
                System.out.println(port.nextQues(Integer.valueOf(name)) + "\n");
                break;
            case "4":
                System.out.println("Enter question id: \n");
                name = in.nextLine();
                System.out.println("Enter answer(through a space): \n");
                String ans = in.nextLine();
                String arr[] = ans.split(" ");
                ArrayList<Integer> an = new ArrayList();
                for(int i = 0; i < arr.length; i++){
                    an.add(Integer.valueOf(arr[i]));
                }
                port.answ(Integer.valueOf(name), an);
                System.out.println("Success");
                break;
            case "5":
                System.out.println("Enter test id: \n");
                name = in.nextLine();
                System.out.println(port.closeTest(Integer.valueOf(name)) + "\n");
                break;
            case "6":
                System.out.println("Enter test id: \n");
                name = in.nextLine();
                System.out.println("Your score: " + port.getScore(Integer.valueOf(name)) + "\n");
                break;
            }
        }
    }
}
