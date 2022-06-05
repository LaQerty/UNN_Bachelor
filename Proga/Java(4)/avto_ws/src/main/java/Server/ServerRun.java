package Server;

import Avto.Avto;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class ServerRun implements SerInterface {
    ArrayList<Avto> cars = new ArrayList();
    int id = -1;
    
    @WebMethod
    @Override
    public String getAllModel() {
        String models = "";
        for(Avto a : cars){
            models+= a.model + "\n";
        }
        return models;
    }

    @WebMethod
    @Override
    public String getAllCarByModel(String model) {
        String res = "";
        int i = 0;
        for(Avto a : cars){
            if(a.model.equals(model)) {
                res += "ID: " + i + "\n" + a.toString();
            }
            i++;
        }
        return res;
    }

    @WebMethod
    @Override
    public int newCar(String model, int c, String s, int price) {
        id++;
        cars.add(new Avto(model,c, s, price));
        return id;
    }

    @WebMethod
    @Override
    public void changeCharacteristic(int id, String s, int c) {
        cars.get(id).condition = s;
        cars.get(id).mileage = c;
    }

    @WebMethod
    @Override
    public String takeCar(int id, int days) {
        return cars.get(id).getCar(days);
    }

    @WebMethod
    @Override
    public void returnCar(int id) {
        cars.get(id).returnCar();
    }
    
    public static void main(String[] args) {
        ServerRun service = new ServerRun();
        Endpoint.publish("http://localhost:8080/avto",service);
        System.out.println("Server start!");
    }
}
