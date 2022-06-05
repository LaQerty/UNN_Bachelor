package ClientServer;

import ClientServer.ServInterface;
import Test.Answer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class ClientTeacher {
    public static void main(String[] args) throws Exception {
        //подклбчение к сервису
        Service service = Service.create(
        new URL(String.format("http://localhost:%d/HelloDynamic?wsdl",8080)), //wsdl html подобный язык, описывает наш сервис.
        new QName("http://ClientServer/", "ServerService"));
        //порт через который обращаемся
        ServInterface port = service.getPort(
        new QName("http://ClientServer/", "ServerPort"),
        ServInterface.class);
        System.out.println("You connecte to server as teacher!");
        System.out.println("You can: \n 1)Create new test \n 2)Create new question \n 3)Create answer \n 4)Exit");
        Scanner in = new Scanner(System.in);
        String mes ="";
        while(mes != "4"){
            mes = in.nextLine();
            switch (mes) {
            case "1":
                System.out.println("Enter test name: \n");
                String name = in.nextLine();
                //обращаемся к методу сервиса
                System.out.println(port.createTest(name) + "\n");
                break;
            case "2":
                System.out.println("Enter question: \n");
                name = in.nextLine();
                System.out.println("Enter test id: \n");
                String testId = in.nextLine();
                System.out.println(port.addQues(name, Integer.valueOf(testId)) + "\n");
                break;
            case "3":
                System.out.println("Enter question id: \n");
                name = in.nextLine();
                System.out.println("Enter test id: \n");
                testId = in.nextLine();
                System.out.println("Enter answer(answers text true/false points): \n");
                String ans = in.nextLine();
                port.createAns(Integer.valueOf(testId), Integer.valueOf(name), ans);
                System.out.println("Success");
                break;
            }
        }
    }
}
