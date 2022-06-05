package Test;

import java.util.ArrayList;

public class Test {
    public String name;
    public ArrayList<Question> ques = new ArrayList();
    public int res;
    public int currentQues;
    public Test(String name) {
        this.name=name;
        this.res=0;
        this.currentQues=0;
    }
    public void addQuest(Question q){
        this.ques.add(q);
    }
    public void ansQues(int id, ArrayList<Integer> ans){
        for(int i = 0; i < ans.size(); i++){
            if(ques.get(id).ans.get(ans.get(i)).correc){
                this.res+=ques.get(id).ans.get(ans.get(i)).score;
            } else  this.res-=ques.get(id).ans.get(ans.get(i)).score;   
        }
        for(int i = 0; i < ques.get(id).ans.size(); i++) {
            if(!ans.contains(i) && ques.get(id).ans.get(i).correc)
                this.res-=ques.get(id).ans.get(i).score;
        }
    }
    
    public Question nextQues(){
        this.currentQues++;
        return this.ques.get(this.currentQues);
    }
}
