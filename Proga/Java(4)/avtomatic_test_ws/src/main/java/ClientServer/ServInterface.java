package ClientServer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
//сам интерфейс, аннотация определяют методы и интерфейс как веб, без них дефолтные методы
@WebService
public interface ServInterface {
    @WebMethod
    public String createTest(String name);
    @WebMethod
    public String addQues(String que, int id);
    @WebMethod
    public void createAns(int testId, int queId, String answer);
    @WebMethod
    public String allTest();
    @WebMethod
    public String startTest(int testId);
    @WebMethod
    public String nextQues(int testId);
    @WebMethod
    public void answ(int quesId, ArrayList<Integer> answers);
    @WebMethod
    public String closeTest(int testId);
    @WebMethod
    public int getScore(int testId);
}
