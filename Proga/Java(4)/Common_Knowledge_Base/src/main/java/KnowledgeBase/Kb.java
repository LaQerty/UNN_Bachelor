package KnowledgeBase;

import java.util.ArrayList;
import java.util.HashMap;

public class Kb {
    public String name;
    public String text;
    public ArrayList<String> marks = new ArrayList();
    public HashMap<String,ArrayList<Byte>> file = new HashMap();
    
    public Kb(String name, String text){
        this.name = name;
        this.text = text;
    }
    public void addMarks(String m){
        this.marks.add(m);
    }
    public void addFile(String name, ArrayList<Byte> file){
        this.file.put(name, file);
    }
    public ArrayList<Byte> getFile(String name){
        return this.file.get(name);
    }
    public boolean haveMark(String m){
        return marks.contains(m);
    }
    
}
