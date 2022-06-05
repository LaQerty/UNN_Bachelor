package SerCli;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface ServInt {
    @WebMethod
    public String createTask(String date, String descr, String name, String email);
    @WebMethod
    public String getStatus(int id);
    @WebMethod
    public String closeTask(int id);
    @WebMethod
    public String reopenTask(int id, String descr);
    @WebMethod
    public String allTask();
    @WebMethod
    public String work(int id);
    @WebMethod
    public String done_task(int id);
}
