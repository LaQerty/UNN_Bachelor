package lab2.lab2.lab2.AlarmClock;

import lab2.lab2.Watch.MyException;
import lab2.lab2.Watch.WatchType;
import lab2.lab2.Alarm.BaseAlarm;
import lab2.lab2.Alarm.ABTimer;
import lab2.lab2.Alarm.AlarmType;

import java.io.IOException;
import java.util.ArrayList;
import lab2.lab2.Alarm.AlarmFrame;
import lab2.lab2.Watch.BaseWatch;

public class ClockSecond extends ClockFirst {

    public ClockSecond() {
        realTime = lab2.lab2.Watch.WBTimer.build(WatchType.Second);
        alarms = new ArrayList<BaseAlarm>();
    }
    @Override
    public void addAlarm() {
        try {
            BaseAlarm w = ABTimer.build(AlarmType.Second);
            w.setHour();
            w.setMin();
            w.setSec();
            alarms.add(w);
        } catch (IOException | UnsupportedOperationException | MyException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void setSec() throws MyException, IOException{
        realTime.setSec();
        notifyAl();
    }

    @Override
    public void setSec(int _sec) throws MyException, IOException{
        realTime.setSec(_sec);
        notifyAl();
    }
    @Override
    public void setTime(int _hour, int _min, int _sec) throws MyException, IOException {
        try {
            realTime.setHour(_hour);
            realTime.setMin(_min);
            realTime.setSec(_sec);
        } catch (IOException | UnsupportedOperationException | MyException e){}
        notifyAl();
    }

    @Override
    public void moveSec() throws MyException, IOException{
        realTime.moveSec();
        notifyAl();
    }

    @Override
    public void moveSec(int _sec) throws MyException, IOException{
        realTime.moveSec(_sec);
        notifyAl();
    }
    @Override
    public void moveTime(int _hour, int _min, int _sec) throws MyException, IOException{
        realTime.moveHour((this.realTime.getMin() + _min + (this.realTime.getSec() + _sec) / 60) / 60 + _hour);
        realTime.moveMin(_min + (this.realTime.getSec() + _sec) / 60);
        realTime.moveSec(_sec);
        notifyAl();
    }

    @Override
    public int getSec()throws MyException, IOException{
        return realTime.getSec();
    }
    @Override
    public BaseWatch getWatch() {
        return realTime;
    }
    @Override
    public void notifyAl() {
        for (int i = 0; i < alarms.size(); i++){
            BaseAlarm al = (BaseAlarm)alarms.get(i);
            /*if (al.updatew(realTime)) {
                deleteAlarm(al);
                AlarmFrame a;
            }*/
        }
    }
    @Override
    public String toString() {
        return realTime.toString();
    }
    @Override
    public void deleteAl() {
        for (int i = 0; i < alarms.size(); i++){
            BaseAlarm al = (BaseAlarm)alarms.get(i);
            try {
                if ((al.getTime().getHour() == realTime.getHour()) && (al.getTime().getMin() == realTime.getMin()) && (al.getTime().getSec() + 1 == realTime.getSec())) {
                    alarms.remove(al);
                }
            } catch (IOException | UnsupportedOperationException | MyException e){
                System.err.println(e.getMessage());
            }
        }
    }
    
    @Override
    public boolean isAlarm() {
        //boolean isal = false;
        for (int i = 0; i < alarms.size(); i++){
            BaseAlarm al = (BaseAlarm)alarms.get(i);
            try {
                if ((al.getTime().getHour() == realTime.getHour()) && (al.getTime().getMin() == realTime.getMin()) && (al.getTime().getSec() == realTime.getSec())) {
                    return true;
                }
            } catch (IOException | UnsupportedOperationException | MyException e){
                System.err.println(e.getMessage());
            }
        }
        return false;
    }
    
    @Override
    public String AtoString() {
        String a = "";
        for (int i = 0; i < alarms.size(); i++){
            BaseAlarm al = (BaseAlarm)alarms.get(i);
            a += al.AtoString() + " ";
        }
        return a;
    }
    
    @Override
    public void deleteAlarm() {
        alarms.clear();
    }
    
    @Override
    public void deleteAlarm(BaseAlarm w) { 
        for (int i = 0; i < alarms.size(); i++){
            BaseAlarm al = (BaseAlarm)alarms.get(i);
            try {
                if ((al.getTime().getHour() == w.getTime().getHour()) && (al.getTime().getMin() == w.getTime().getMin()) && (al.getTime().getSec() == w.getTime().getSec()))
                    alarms.remove(i);
            } catch (IOException | UnsupportedOperationException | MyException e){
                System.err.println(e.getMessage());
            }
        }
    }
}
