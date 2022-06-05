package Structure;

public class Answer{
    String answer = "";
    boolean right = false;
    int peekRight = 0;
    int notPeekRight = 0;
    int peekFalse = 0;
    int notPeekFalse = 0;

    public Answer(String answer, boolean right, int peekRight, int notPeekRight, int peekFalse, int notPeekFalse){
        this.answer = answer;
        this.right = right;
        this.peekRight = peekRight;
        this.notPeekRight = notPeekRight;
        this.peekFalse = peekFalse;
        this.notPeekFalse = notPeekFalse;
    }

    public String getAns(){
        return answer;
    }
}