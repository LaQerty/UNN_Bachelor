package lab2.lab2.lab2.AlarmClock;

import lab2.lab2.Watch.WBTimer;
import lab2.lab2.Watch.BaseWatch;
import lab2.lab2.Watch.MyException;
import lab2.lab2.Watch.WatchType;
import lab2.lab2.Alarm.ABTimer;
import lab2.lab2.Alarm.AlarmType;
import lab2.lab2.Alarm.BaseAlarm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lab2.lab2.Alarm.AlarmFrame;

public class ClockFirst implements BaseClock{
    protected BaseWatch realTime;
    protected ArrayList alarms;

    public ClockFirst() {
        realTime = WBTimer.build(WatchType.First);
        alarms = new ArrayList<BaseAlarm>();
    }
    @Override
    public void addAlarm() {
        BaseAlarm w = ABTimer.build(AlarmType.First);
        try {
        w.setHour();
        w.setMin();
        alarms.add(w);
        } catch (IOException | UnsupportedOperationException | MyException e){
            System.err.println(e.getMessage());
        }
    }
    
    //@Override
    public void deleteAlarm() {
        alarms.clear();
    }
    
    //@Override
    public void deleteAlarm(BaseAlarm w) { 
        alarms.remove(w);
    }
    
    //@Override
    public void deleteAl() {
        for (int i = 0; i < alarms.size(); i++){
            BaseAlarm al = (BaseAlarm)alarms.get(i);
            if (al.updatew(realTime)) {
                alarms.remove(al);
            }
        }
    }
    
    @Override
    public void addAlarm(BaseAlarm w) {
        alarms.add(w);
    }

    @Override
    public void setHour() throws MyException, IOException {
        realTime.setHour();
        notifyAl();
    }

    @Override
    public void setMin() throws MyException, IOException{
        realTime.setMin();
        notifyAl();
    }

    @Override
    public void setSec() throws MyException, IOException {
        throw new UnsupportedOperationException("This watch model doesn't support seconds");
    }

    @Override
    public void setHour(int _hour) throws MyException, IOException {
        realTime.setHour(_hour);
        notifyAl();
    }

    @Override
    public void setMin(int _min) throws MyException, IOException{
        realTime.setMin(_min);
        notifyAl();
    }

    @Override
    public void setSec(int _sec) throws MyException, IOException {
        throw new UnsupportedOperationException("This watch model doesn't support seconds");
    }
    @Override
    public void setTime(int _hour, int _min, int _sec) throws MyException, IOException {
        try {
            realTime.setHour(_hour);
            realTime.setMin(_min);
        } catch (IOException | UnsupportedOperationException | MyException e){}
        notifyAl();
    }

    @Override
    public void moveHour() throws MyException, IOException{
        realTime.moveHour();
        notifyAl();
    }

    @Override
    public void moveMin() throws MyException, IOException{
        realTime.moveMin();
        notifyAl();
    }

    @Override
    public void moveSec() throws MyException, IOException{
        throw new UnsupportedOperationException("This watch model doesn't support seconds");
    }
    @Override
    public void moveHour(int _hour) throws MyException, IOException{
        realTime.moveHour(_hour);
        notifyAl();
    }

    @Override
    public void moveMin(int _min) throws MyException, IOException{
        realTime.moveHour((this.realTime.getMin() + _min) / 60);
        realTime.moveMin(_min);
        notifyAl();
    }

    @Override
    public void moveSec(int _sec) throws MyException, IOException{
        throw new UnsupportedOperationException("This watch model doesn't support seconds");
    }
    @Override
    public void moveTime(int _hour, int _min, int _sec) throws MyException, IOException{
        realTime.moveHour((this.realTime.getMin() + _min) / 60 + _hour);
        realTime.moveMin(_min);
        notifyAl();
    }

    @Override
    public int getHour(){ return realTime.getHour(); }
    @Override
    public int getMin(){
        return realTime.getMin();
    }
    @Override
    public int getSec() throws MyException, IOException{
        throw new UnsupportedOperationException("This watch model doesn't support seconds");
    }
    @Override
    public BaseWatch getWatch() {
        return realTime;
    }
    @Override
    public List getAlarms() {
        return alarms;
    }
    
    @Override
    public void notifyAl() {
        for (int i = 0; i < alarms.size(); i++){
            BaseAlarm al = (BaseAlarm)alarms.get(i);
            if (al.updatew(realTime)) {
                //deleteAlarm(al);
                //AlarmFrame a;
            }
        }
    }
    @Override
    public boolean isAlarm() {
        for (int i = 0; i < alarms.size(); i++){
            BaseAlarm al = (BaseAlarm)alarms.get(i);
            if (al.updatew(realTime)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return realTime.toString();
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
}
