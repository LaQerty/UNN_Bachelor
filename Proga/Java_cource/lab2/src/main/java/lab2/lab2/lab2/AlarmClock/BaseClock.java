package lab2.lab2.lab2.AlarmClock;

import lab2.lab2.Watch.MyException;
import lab2.lab2.Watch.BaseWatch;
import lab2.lab2.Alarm.BaseAlarm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface BaseClock {
     void setHour()throws MyException, IOException;
     void setMin()throws MyException, IOException;
     void setSec()throws MyException, IOException;
     void setHour(int _hour)throws MyException, IOException;
     void setMin(int _min)throws MyException, IOException;
     void setSec(int _sec)throws MyException, IOException;
     void setTime(int _hour, int _min, int _sec) throws MyException, IOException;

     void moveHour()throws MyException, IOException;
     void moveMin()throws MyException, IOException;
     void moveSec()throws MyException, IOException;
     void moveHour(int _hour)throws MyException, IOException;
     void moveMin(int _min)throws MyException, IOException;
     void moveSec(int _sec)throws MyException, IOException;
     void moveTime(int _hour, int _min, int _sec) throws MyException, IOException;

     int getHour();
     int getMin();
     int getSec()throws MyException, IOException;
     BaseWatch getWatch();
     List getAlarms();
     boolean isAlarm();

     void notifyAl();
     void addAlarm();
     void addAlarm(BaseAlarm a);
     void deleteAlarm();
     void deleteAl();
     void deleteAlarm(BaseAlarm a);
     
     String AtoString();
}

