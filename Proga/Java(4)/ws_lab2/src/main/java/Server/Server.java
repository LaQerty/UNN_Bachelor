package Server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import Structure.Answer;
import Structure.Question;
import Structure.Test;

import java.util.ArrayList;
import java.util.HashMap;
@WebService
public class Server implements ServerInter{
public static final int port = 8080;
Integer global_id = 0;
Integer test_count = 0;
HashMap<Integer, Test> test_map;
Test active = null;
Server(){
    test_map = new HashMap<Integer, Test>();
}
@WebMethod
@Override
public String startCh(int id){
    if(test_map.containsKey(id) == true ){
        active = test_map.get(id);
        global_id = id;
        return String.format("You chose test: " + test_map.get(id).getName() + " Question 1: " + active.getQuestion(-1).getName());
    }
   return "Test not found"; 
}
@WebMethod
@Override
public String allTest(){
    String res = "";
    for(Test q : test_map.values()){
        int i = 0;
        res += q.getName() + " Id: " + String.valueOf(++i);
    }
    if("".equals(res))
        res = "Null";
    return res;
}
@WebMethod
@Override
public String answer(ArrayList<Integer> array){
    active.answerQuestion(array);
    if(active.nextQuestion() != null)
        return "Question: " + active.getQuestion(-1).getName();
    return "End of test";
}
@WebMethod
@Override
public String finish(){
    active.finish();
    int res = active.getScore();
    return "You finish test with score: " + String.valueOf(res);
}
@WebMethod
@Override
public String getScore(){
    int res = active.getScore();
    return "Your score: " + String.valueOf(res);
}
@WebMethod
@Override
public String createTest(String name){
    test_count++;
    test_map.put(test_count,new Test(name));
    return "You create test with id: " + String.valueOf(test_count);
}
@WebMethod
@Override
public String createQuestion(String que, int id){
    int res = test_map.get(id).addQuestion(new Question(que));
    return "You create question with id: " + String.valueOf(res);
}
@WebMethod
@Override
public String createAnswer(int test_id, int ques_id, ArrayList<String> arr){
    ArrayList<Answer> ansArr = new ArrayList();
    for(int i = 0; i < arr.size(); i++){
        int p1, p2, p3, p4, p5;
        String name = arr.get(i);
        try{
            p1 = Integer.parseInt(arr.get(++i));
            p2 = Integer.parseInt(arr.get(++i));
            p3 = Integer.parseInt(arr.get(++i));
            p4 = Integer.parseInt(arr.get(++i));
            p5 = Integer.parseInt(arr.get(++i));
        } catch (Exception e){
            return "Fail";
        }
        if(p1 == 1) {
            test_map.get(test_id).getQuestion(ques_id).addAnswer(new Answer(name, true, p2, p3, p4, p5));
        }else{
            test_map.get(test_id).getQuestion(ques_id).addAnswer(new Answer(name, false, p2, p3, p4, p5));
        }
    }
    return "You add new answer for question";
}
public static void main(String[] args) {
Server service = new Server();
String url = String.format("http://localhost:%d/HelloDynamic", port);
Endpoint.publish(url,service);
}
}