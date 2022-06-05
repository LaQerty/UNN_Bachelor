package labStruct;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Lab {
    public String owner;
    public byte[] lab;
    public ArrayList<Integer> grades = new ArrayList();
    public ArrayList<String> estimators = new ArrayList();
    
    public Lab(String owner, String laba) {
        this.owner = owner;
        this.lab = laba.getBytes(StandardCharsets.UTF_8);
    }
    
    public String setMark(String name, int mark){
        if(mark > 1 && mark < 6){
            if(name != this.owner){
                this.estimators.add(name);
                this.grades.add(mark);
                return "Success";
            }else return "You can't set mark yourself";
        } else return "Uncorrectly mark";
    }
    public int getAverageMark(){
        int res = 0;
        for(int i : this.grades){
            res += i;
        }
        res /= this.grades.size();
        return res;
    }  
}
