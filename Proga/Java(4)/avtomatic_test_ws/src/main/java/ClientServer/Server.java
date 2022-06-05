package ClientServer;

import Test.Question;
import Test.Test;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Server implements ServInterface {
    int testId = -1;
    int quesId = -1;
    int currentTest = -1;
    ArrayList<Test> tests = new ArrayList();
    
    @WebMethod
    @Override
    public String createTest(String name) {
        testId++;
        tests.add(new Test(name));
        return "Test id: " + Integer.toString(testId);
    }
    
    @WebMethod
    @Override
    public String addQues(String que, int id) {
        quesId++;
        tests.get(id).addQuest(new Question(que));
        return "Question id: " +Integer.toString(quesId);
    }
    
    @WebMethod
    @Override
    public void createAns(int testId, int queId, String answer) {
        tests.get(testId).ques.get(queId).addAns(answer);
    }
    
    @WebMethod
    @Override
    public String allTest() {
        String res = "";
        for(int i = 0; i < tests.size(); i++) 
            res += "Test id: " + i + " - " + tests.get(i).name + "\n";
        return res;
    }
    
    @WebMethod
    @Override
    public String startTest(int testId) {
        currentTest = testId;
        return tests.get(testId).ques.get(0).toString();
    }

    @WebMethod
    @Override
    public String nextQues(int testId) {
        return tests.get(testId).nextQues().toString();
    }

    @WebMethod
    @Override
    public void answ(int quesId, ArrayList<Integer> answers) {
        if(currentTest != -1) {
            tests.get(currentTest).ansQues(quesId, answers);
        }
    }

    @WebMethod
    @Override
    public String closeTest(int testId) {
        if(currentTest != -1) {
            currentTest = -1;
            tests.get(testId).res -= tests.get(testId).ques.size() - tests.get(testId).currentQues;
            return "You close test. Your score: " + tests.get(testId).res;
        } else return "This test already closed";
    }

    @WebMethod
    @Override
    public int getScore(int testId) {
        return tests.get(testId).res;
    }
    
    public static void main(String[] args) {
        //создаем сервис
        Server service = new Server();
        //url port
        String url = String.format("http://localhost:%d/HelloDynamic", 8080);
        Endpoint.publish(url,service); //публикуем
        System.out.println("Server start!");
    }
}
