package Test;

import java.util.ArrayList;


public class Question {
    public String name;
    public ArrayList<Answer> ans = new ArrayList();
    public Question(String name){
        this.name = name;
    }
    public void addAns(String ans){
        String arr[] = ans.split(" ");
        for(int i = 0; i < arr.length; i+=3){
            this.ans.add(new Answer(arr[i],Boolean.parseBoolean(arr[i+1]),Integer.valueOf(arr[i+2])));
        }
    }
    @Override
    public String toString(){
        String res="";
        res+=this.name + "\n";
        for(int i = 0; i < this.ans.size(); i++) {
            res+=i + ") " + ans.get(i).name + "\n";
        }
        return res;
    }
}
