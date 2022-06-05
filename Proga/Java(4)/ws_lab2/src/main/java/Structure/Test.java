package Structure;

import java.util.ArrayList;
import java.util.HashMap;

public class Test{
    String name = "";
    HashMap<Integer, Question> questions;
    int numOfQuestions = 0;
    int curQuestion = 1;
    int score = 0;
    
    public Test(String name){
        this.name = name;
        questions = new HashMap<>();
    }
    public int getScore(){
        return score;
    }

    public int addQuestion(Question q){
        numOfQuestions++;
        questions.put(numOfQuestions, q);
        return numOfQuestions;
    }
    
    public Question getQuestion(int id){
        if( id == -1)
            return questions.get(curQuestion);
        return questions.get(id);
    }

    public Question nextQuestion(){
        curQuestion++;
        return questions.get(curQuestion);
    }

    public final String getName(){
        if(!"".equals(name)){
            return name;
        } else return "No Test!";
    }
    
    public void finish(){
        for(Question q : questions.values()){
           q.answerQuestion(new ArrayList(0)); 
        }
    }
            
    public void answerQuestion(ArrayList<Integer> ans){
        Question corr = getQuestion(curQuestion);
        score += corr.answerQuestion(ans);
        nextQuestion();
    }
}
