package Server;
import Structure.Answer;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface ServerInter {
@WebMethod
String startCh(int id);
@WebMethod
String allTest();
@WebMethod
String answer(ArrayList<Integer> array);
@WebMethod
String finish();
@WebMethod
String getScore();
@WebMethod
String createTest(String name);
@WebMethod
String createQuestion(String que, int id);
@WebMethod
public String createAnswer(int test_id, int ques_id, ArrayList<String> arr);
}