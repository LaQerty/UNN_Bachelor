package Server;

import java.util.HashMap;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import lib.Lib;

@WebService
public class Server implements ServInterface{
    public HashMap<String, Lib> lib = new HashMap();
    
    @WebMethod
    @Override
    public String getAllBook() {
        String res = "";
        for(String i : lib.keySet()){
            res+=lib.get(i).toString();
        }
        return res;
    }
    
    @WebMethod
    @Override
    public String addNewBook(String ISBN, String autors, String year, String publishing, String name) {
        lib.put(ISBN, new Lib(ISBN, autors, year, publishing, name));
        return "Success";
    }
    
    @WebMethod
    @Override
    public String addBook(String ISBN, int c) {
        lib.get(ISBN).setCount(c);
        return "Success";
    }
    
    @WebMethod
    @Override
    public String takeBook(String ISBN) {
        if(lib.get(ISBN).count > 0){
            lib.get(ISBN).count--;
            return "You take book";
        } else return "This book is over";
    }
    
    @WebMethod
    @Override
    public String returnBook(String ISBN) {
        lib.get(ISBN).count++;
        return "Thanks, you return book!";
    }
    
    public static void main(String[] args) {
        Server service = new Server();
        String url = String.format("http://localhost:%d/HelloDynamic", 8080);
        Endpoint.publish(url,service);
        System.out.println("Server start!");
    }
}
