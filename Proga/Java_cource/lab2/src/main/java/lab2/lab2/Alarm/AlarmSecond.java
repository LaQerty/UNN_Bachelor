package lab2.lab2.Alarm;

import lab2.lab2.Watch.WBTimer;
import lab2.lab2.Watch.BaseWatch;
import lab2.lab2.Watch.MyException;
import lab2.lab2.Watch.WatchType;

import java.io.IOException;

public class AlarmSecond implements BaseAlarm {
    protected BaseWatch timeAlarm;

    public AlarmSecond() {
        timeAlarm = WBTimer.build(WatchType.Second);
    }
    public AlarmSecond(int _hour, int _min, int _sec) {
        timeAlarm = WBTimer.build(WatchType.Second);
        try {
            timeAlarm.setHour(_hour);
            timeAlarm.setMin(_min);
            timeAlarm.setSec(_sec);
        } catch (IOException | UnsupportedOperationException | MyException e){
            System.err.println(e.getMessage());
        }
    }
    @Override
    public boolean updatew(BaseWatch w) {
        try { 
            if ((timeAlarm.getHour() == w.getHour()) && (timeAlarm.getMin() == w.getMin()) && (timeAlarm.getSec() == w.getSec())) {
                //System.out.println("ALARM " + timeAlarm.toString());
                //AlarmFrame a = new AlarmFrame();
                return true;
            }
            return false;
        } catch (IOException | UnsupportedOperationException | MyException e){
            System.err.println(e.getMessage());
        }
        return false;
    }
    @Override
    public void setHour(int _hour) throws MyException, IOException {
        timeAlarm.setHour(_hour);
    }
    @Override
    public BaseWatch getTime() {
        return timeAlarm;
    }

    @Override
    public void setMin(int _min) throws MyException, IOException{
        timeAlarm.setMin(_min);
    }

    @Override
    public void setSec(int _sec) throws MyException, IOException {
        timeAlarm.setSec(_sec);
    }
    @Override
    public void setHour() throws MyException, IOException {
        timeAlarm.setHour();
    }

    @Override
    public void setMin() throws MyException, IOException{
        timeAlarm.setMin();
    }

    @Override
    public void setSec() throws MyException, IOException {
        timeAlarm.setSec();
    }
    
    @Override
    public String AtoString() {
        String a = "";
        if (timeAlarm.getHour() < 10) {
            a += "0";
        }
        if (timeAlarm.getMin() < 10) {
            a += timeAlarm.getHour() + ":0" + timeAlarm.getMin();
        } else {
            a += timeAlarm.getHour() + ":" + timeAlarm.getMin();
        }
        try {
            if (timeAlarm.getSec() < 10) {
                return a + ":0" + timeAlarm.getSec();
            }else{
                return a + ":" + timeAlarm.getSec(); 
            } 
        } catch (IOException | UnsupportedOperationException | MyException e) {
            return "";
        }
    }
}
