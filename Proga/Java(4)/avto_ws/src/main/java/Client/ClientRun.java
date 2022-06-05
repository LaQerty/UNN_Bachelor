package Client;

import Server.SerInterface;
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ClientRun {
    public static void main(String[] args) throws Exception {
        Service service = Service.create(
        new URL("http://localhost:8080/avto?wsdl"),
        new QName("http://Server/", "ServerRunService"));
        SerInterface port = service.getPort(
        new QName("http://Server/", "ServerRunPort"),
        SerInterface.class);
        String userWord ="";
        Scanner console = new Scanner(System.in);
        System.out.println("Enter your role:(admin or user)\n");
        String role = console.nextLine();
        if(role.equals("admin")){
            while(true){
                System.out.println("Hi, admin.\nYou can: \n1)get_cars_model\n2)get_cars_by_model\n3)new_car\n4)change_character\n");
                userWord = console.nextLine();
                if(userWord.equals("get_cars_model")){
                    System.out.println(port.getAllModel());
                } else if(userWord.equals("get_cars_by_model")){
                    System.out.println("Enter model: \n");
                    String model = console.nextLine();
                    System.out.println(port.getAllCarByModel(model));
                } else if(userWord.equals("new_car")){
                    System.out.println("Enter model: \n");
                    String model = console.nextLine();
                    System.out.println("Enter condition: \n");
                    String con = console.nextLine();
                    System.out.println("Enter price:(in thousands)\n");
                    int price = Integer.valueOf(console.nextLine());
                    System.out.println("Enter mileage:(in thousands)\n");
                    int mil = Integer.valueOf(console.nextLine());
                    System.out.println("ID: " + port.newCar(model, mil, con, price));
                }  else if(userWord.equals("change_character")){
                    System.out.println("Enter car`s id: \n");
                    int id = Integer.valueOf(console.nextLine());
                    System.out.println("Enter new mileage: \n");
                    int mil = Integer.valueOf(console.nextLine());
                    System.out.println("Enter new condition: \n");
                    String con = console.nextLine();
                    port.changeCharacteristic(id, con, mil);
                } else if(userWord.equals("exit")){
                    break;
                } else System.out.println("I dont know what you want");
            }
        } else if(role.equals("user")){
            while(true){
                System.out.println("Hi, user.\nYou can: \n1)get_cars_model\n2)get_cars_by_model\n3)take_car\n4)return_car\n");
                userWord = console.nextLine();
                if(userWord.equals("get_cars_model")){
                    System.out.println(port.getAllModel());
                } else if(userWord.equals("get_cars_by_model")){
                    System.out.println("Enter model: \n");
                    String model = console.nextLine();
                    System.out.println(port.getAllCarByModel(model));
                } else if(userWord.equals("take_car")){
                    System.out.println("Enter car`s id: \n");
                    int id = Integer.valueOf(console.nextLine());
                     System.out.println("Enter days: \n");
                    int days = Integer.valueOf(console.nextLine());
                    System.out.println(port.takeCar(id, days));
                }  else if(userWord.equals("return_car")){
                    System.out.println("Enter car`s id: \n");
                    int id = Integer.valueOf(console.nextLine());
                    port.returnCar(id);
                } else if(userWord.equals("exit")){
                    break;
                } else System.out.println("I dont know what you want");
            }
        }
        console.close();
    }
}
