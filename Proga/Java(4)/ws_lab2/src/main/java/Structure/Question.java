package Structure;

import java.util.ArrayList;

public final class Question{
    String name = "";
    ArrayList<Answer> variants;
    
    public Question(String name){
        this.name = name;
        variants = new ArrayList<>();
    }

    public ArrayList<Answer> getVariants(){
        if(variants != null)
            return variants;
        else{
            variants.add(new Answer("Not_variants_pls_write_you_teacher", false, 0, 0, 0, 0));
            return variants;
        }
    }
    
    public String getName(){
        String res = "";
        res += name;
        for(Answer ans : variants){
            res += "\n" + "*" + ans.getAns() + "\n";
        }
        return res;
    }

    public void addAnswer(Answer ans){
        if(!variants.contains(ans))
            variants.add(ans);
    }

    public int answerQuestion(ArrayList<Integer> ans){
        int res = 0;
        ArrayList<Integer> antiAns = new ArrayList<>();
        for(int x : ans){
            if(variants.get(x).right){
                res+=variants.get(x).peekRight;
            } else {
                res-=variants.get(x).peekFalse;
            }     
        }
        for(int i = 0; i<variants.size(); i++){
            if(!ans.contains(i)){
                antiAns.add(i);
            }
        }
        for(int x : antiAns){
            if(variants.get(x).right){
                res-=variants.get(x).notPeekRight;
            } else {
                res+=variants.get(x).notPeekFalse;
            }     
        }
        return res;
    }
}