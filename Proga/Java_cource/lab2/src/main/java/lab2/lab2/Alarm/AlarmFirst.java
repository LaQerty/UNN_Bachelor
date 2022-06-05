package lab2.lab2.Alarm;

import lab2.lab2.Watch.WBTimer;
import lab2.lab2.Watch.BaseWatch;
import lab2.lab2.Watch.MyException;
import lab2.lab2.Watch.WatchType;

import javax.swing.*;
import java.awt.event.*;

import java.io.IOException;

public class AlarmFirst implements BaseAlarm {
    protected BaseWatch timeAlarm;

    public AlarmFirst() {
        timeAlarm = WBTimer.build(WatchType.First);
    }
    public AlarmFirst(int _hour, int _min) {
        timeAlarm = WBTimer.build(WatchType.Second);
        try {
            timeAlarm.setHour(_hour);
            timeAlarm.setMin(_min);
        } catch (IOException | UnsupportedOperationException | MyException e){
            System.err.println(e.getMessage());
        }
    }
    @Override
    public boolean updatew(BaseWatch w) {
        if ((timeAlarm.getHour() == w.getHour()) && (timeAlarm.getMin() == w.getMin())) {
            //System.out.println("ALARM " + timeAlarm.toString());
            //AlarmFrame a;
            return true;
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
        throw new UnsupportedOperationException("This watch model doesn't support seconds");
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
        throw new UnsupportedOperationException("This watch model doesn't support seconds");
    }
    
    @Override
    public String AtoString() {
        if (timeAlarm.getMin() < 10) {
            return timeAlarm.getHour() + ":0" + timeAlarm.getMin();
        } else {
            return timeAlarm.getHour() + ":" + timeAlarm.getMin();
        }
    }
}
