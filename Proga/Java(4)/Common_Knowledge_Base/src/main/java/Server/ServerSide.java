package Server;

import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ServerSide {
    @WebMethod
    public int createEntry(String name, String text);
    @WebMethod
    public void addMarks(int id, ArrayList<Integer> marksId);
    @WebMethod
    public void addFile(int id, String name, ArrayList<Byte> file);
    @WebMethod
    public int createMark(String name);
    @WebMethod
    public ArrayList<Byte> getFile(int id, String name);
    @WebMethod
    public void deleteMark(int id);
    @WebMethod
    public String getAllMark();
    @WebMethod
    public String getAllEntry();
    @WebMethod
    public String getEntryByMark(int id);
}
