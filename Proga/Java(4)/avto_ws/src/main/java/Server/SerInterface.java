package Server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SerInterface {
    @WebMethod
    public String getAllModel();
    @WebMethod
    public String getAllCarByModel(String model);
    @WebMethod
    public int newCar(String model, int c, String s, int price);
    @WebMethod
    public void changeCharacteristic(int id, String s, int c);
    @WebMethod
    public String takeCar(int id, int days);
    @WebMethod
    public void returnCar(int id);
}
