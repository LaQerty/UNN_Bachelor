package DataBase;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Note {
    public String name;
    public String text;
    public ArrayList<File> files = new ArrayList();
    public ArrayList<Integer> marks = new ArrayList();
    
    public Note(String name, String text) {
        this.name = name;
        this.text = text;
    }
    
    public void addMarks(int[] marks){
        for(int i : marks)
            this.marks.add(i);
    }
    
    public void addFile(String name, String file) {
        this.files.add(new File(name, file));
    }
    
    public String getFile(String name) throws UnsupportedEncodingException {
        for(File f : this.files){
            if(f.name.equals(name))
                return new String(f.file, "UTF-8");
        }
        return "File with name: " + name + " not found";
    }
    
    public class File {
        public byte[] file;
        public String name;
        public File(String name, String file) {
            this.name = name;
            this.file = file.getBytes(StandardCharsets.UTF_8);
        }
    }
}
