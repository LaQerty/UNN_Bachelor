package lab2.lab2.Watch;

import java.io.IOException;

public interface BaseWatch {
     void setHour()throws MyException, IOException;
     void setMin()throws MyException, IOException;
     void setSec()throws MyException, IOException;
     void setHour(int _hour)throws MyException, IOException;
     void setMin(int _min)throws MyException, IOException;
     void setSec(int _sec)throws MyException, IOException;

     void getModel();
     void getCost();

     void moveHour()throws MyException, IOException;
     void moveMin()throws MyException, IOException;
     void moveSec()throws MyException, IOException;
     void moveHour(int _hour)throws MyException, IOException;
     void moveMin(int _min)throws MyException, IOException;
     void moveSec(int _sec)throws MyException, IOException;

     int getHour();
     int getMin();
     int getSec()throws MyException, IOException;
}

