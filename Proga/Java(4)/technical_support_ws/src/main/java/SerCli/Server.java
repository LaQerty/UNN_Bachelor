package SerCli;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import SerCli.ServInt;
import java.util.ArrayList;
import Task.Task;

@WebService
public class Server implements ServInt{
    public static final int port = 8080;    
    int id = 0;
    ArrayList<Task> tasks = new ArrayList();
    
    @WebMethod
    @Override
    public String createTask(String date, String descr, String name, String email){
        tasks.add(new Task(name, email, date, descr));
        id ++;
        return "ID: " + String.valueOf(--id);
    }
    
    @WebMethod
    @Override
    public String getStatus(int id){
        return tasks.get(id).getStatus();
    }
    
    @WebMethod
    @Override
    public String closeTask(int id){
        tasks.get(id).setStatus("CLOSE");
        return "Task was CLOSE";
    }
    
    @WebMethod
    @Override
    public String reopenTask(int id, String descr){
        tasks.get(id).setStatus("REOPEN");
        tasks.get(id).addDescr(descr);
        return "Task was REOPEN";
    }
    
    @WebMethod
    @Override
    public String allTask(){
        int i = 0;
        String res = "";
        for(Task ts : tasks){
            res += "Id: " + String.valueOf(i) + " Status: " + ts.getStatus() + " Description: " 
                    + ts.getDescr() + " Date: " + ts.getDate() + " Owner name: " + ts.getName() + " Owner email: " + ts.getEmail() + "\n";
            i++;
        }
        return res;
    }
    
    @WebMethod
    @Override
    public String work(int id){
        tasks.get(id).setStatus("IN_PROGRESS");
        return "Task was IN_PROGRESS";
    }
    
    @WebMethod
    @Override
    public String done_task(int id){
        tasks.get(id).setStatus("DONE");
        return "Task was DONE";
    }
    
    public static void main(String[] args) {
    Server service = new Server();
    String url = String.format("http://localhost:%d/HelloDynamic", port);
    Endpoint.publish(url,service);
    }
}