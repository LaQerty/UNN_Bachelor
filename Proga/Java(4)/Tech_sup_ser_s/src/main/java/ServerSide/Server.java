package ServerSide;

import RequestStructure.Request;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Server implements SerInterface{
    HashMap<Integer, Request> reqs = new HashMap();
    public int random(){
        return (int)(Math.random()*10000);
    }
    
    @WebMethod
    @Override
    public String createRequest(String name, String email, String text) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        int id = 0;
        while(id == 0 || reqs.containsKey(id)){
            id = random();
        }
        reqs.put(id, new Request(name, email,formatter.format(date),text));
        return Integer.toString(id);
    }

    @WebMethod
    @Override
    public String getStatus(int id) {
        return reqs.get(id).status;
    }

    @WebMethod
    @Override
    public void confirmExecution(int id) {
        reqs.get(id).status = "COMPLETED";
    }

    @WebMethod
    @Override
    public void unconfirmExecution(int id, String text) {
        reqs.get(id).text+=text;
        reqs.get(id).status = "UNCOMPLETED";
    }

    @WebMethod
    @Override
    public String allRequest() {
        String res = "REQUESTS: \n";
        for(int i : reqs.keySet()){
            res+=reqs.get(i).toString();
        }
        return res;
    }

    @WebMethod
    @Override
    public void startRequest(int id) {
        reqs.get(id).status = "IN PROGRESS";
    }

    @WebMethod
    @Override
    public void doneRequest(int id, String text) {
        reqs.get(id).status = "DONE";
        reqs.get(id).text = text;
    }
    public static void main(String[] args) {
        Server service = new Server();
        String url = String.format("http://localhost:%d/MyLab", 8000);
        Endpoint.publish(url,service);
        System.out.println("Server start!");
    }
}
