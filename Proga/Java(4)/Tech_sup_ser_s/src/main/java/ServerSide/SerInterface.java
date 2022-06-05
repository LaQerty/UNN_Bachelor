package ServerSide;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SerInterface {
    @WebMethod
    public String createRequest(String name, String email, String text);
    @WebMethod
    public String getStatus(int id);
    @WebMethod
    public void confirmExecution(int id);
    @WebMethod
    public void unconfirmExecution(int id, String text);
    @WebMethod
    public String allRequest();
    @WebMethod
    public void startRequest(int id);
    @WebMethod
    public void doneRequest(int id, String text);
}
