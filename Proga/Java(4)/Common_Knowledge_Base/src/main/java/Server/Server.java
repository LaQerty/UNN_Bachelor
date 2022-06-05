package Server;

import KnowledgeBase.Kb;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Server implements ServerSide {
    ArrayList<Kb> kb = new ArrayList();
    ArrayList<String> marks = new ArrayList();
    int kbId = -1;
    int marksId = -1;

    @WebMethod
    @Override
    public int createEntry(String name, String text) {
        kbId++;
        kb.add(new Kb(name, text));
        return kbId;
    }

    @WebMethod
    @Override
    public void addMarks(int id, ArrayList<Integer> marksId) {
        for(int i : marksId){
            kb.get(id).addMarks(marks.get(i));
        }
    }

    @WebMethod
    @Override
    public void addFile(int id, String name, ArrayList<Byte> file) {
        kb.get(id).addFile(name, file);
    }

    @WebMethod
    @Override
    public int createMark(String name) {
        marksId++;
        marks.add(name);
        return marksId;
    }

    @WebMethod
    @Override
    public ArrayList<Byte> getFile(int id, String name) {
        return kb.get(id).getFile(name);
    }

    @WebMethod
    @Override
    public void deleteMark(int id) {
        marksId--;
        marks.remove(id);
    }

    @WebMethod
    @Override
    public String getAllMark() {
        String marksToString ="Marks: \n";
        for(String s : marks){
            int i = 0;
            marksToString+="ID: " + i + "Name: " + s + "\n";
            i++;
        }
        return marksToString;
    }

    @WebMethod
    @Override
    public String getAllEntry() {
        String entryToString ="Marks: \n";
        for(Kb k : kb){
            int i = 0;
            entryToString+="ID: " + i + " Name: " + k.name + "\n";
            i++;
        }
        return entryToString;
    }

    @WebMethod
    @Override
    public String getEntryByMark(int id) {
        String markToFind = marks.get(id);
        String result = "";
        for(Kb k : kb){
            int i = 0;
            if(k.haveMark(markToFind))
                result+= "ID: " + i + " Name: " + k.name + "\n";
        }
        return result;
    }
    
    public static void main(String[] args) {
        Server service = new Server();
        Endpoint.publish("http://localhost:8080/ckb",service);
        System.out.println("Server start!");
    }
    
}
