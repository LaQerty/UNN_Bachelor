package lab2.lab2.Alarm;

import lab2.lab2.Watch.BaseWatch;
import lab2.lab2.Watch.MyException;

import java.io.IOException;

public interface BaseAlarm {
     boolean updatew(BaseWatch w);
     void setHour(int _hour)throws MyException, IOException;
     void setMin(int _min)throws MyException, IOException;
     void setSec(int _sec)throws MyException, IOException;
     void setHour()throws MyException, IOException;
     void setMin()throws MyException, IOException;
     void setSec()throws MyException, IOException;
     BaseWatch getTime();
     String AtoString();
}

