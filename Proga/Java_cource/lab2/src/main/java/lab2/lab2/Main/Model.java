/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.lab2.Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lab2.lab2.Alarm.ABTimer;
import lab2.lab2.Alarm.AlarmType;
import lab2.lab2.lab2.AlarmClock.BaseClock;
import lab2.lab2.Watch.BaseWatch;
import lab2.lab2.Alarm.BaseAlarm;
import lab2.lab2.Watch.MyException;
import lab2.lab2.lab2.AlarmClock.CBTimer;
import lab2.lab2.lab2.AlarmClock.ClockType;

/**
 *
 * @author Admin
 */
public class Model {
    BaseClock w = CBTimer.build(ClockType.Second);;
    ArrayList<IObserver> all_o = new ArrayList<>();
    Model m = this;
    boolean pausethis = false;
    
    Connection c;
    
    Thread t;
    
    Model() {
        connect();
        ArrayList<String> tmpal = listFromDB();
        for (String al:tmpal) {
            try {
                BaseAlarm a = ABTimer.build(AlarmType.Second);
                a.setHour(Integer.parseInt(al.substring(0,2)));
                a.setMin(Integer.parseInt(al.substring(3,5)));
                a.setSec(Integer.parseInt(al.substring(6)));
                w.addAlarm(a);
            } catch (IOException | UnsupportedOperationException | MyException e) {}
        }
        
        if (t == null) {
            t = new Thread() {
                @Override
                public void run() {
                    while(true) {
                        try {
                            if (pausethis) {
                                synchronized(m) {
                                    m.wait();
                                }
                                pausethis = false;
                            }
                            w.moveSec(1);
                            update();
                            Thread.sleep(1000);
                        } catch (IOException | UnsupportedOperationException | MyException | InterruptedException e) {}
                    }
                }
            };
            t.start();
        }
    }
    
    void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection ("jdbc:sqlite:C:\\Users\\user\\Desktop\\Учеба\\Прога\\Java_cource\\lab2\\clock.db");
            System.out.println("Nice.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Warning");
        } catch (SQLException ex) {
            System.out.println("Wait client");
        }
    }
    
    public boolean isAlarm() {
        if (w.isAlarm()) {
            try {
                BaseAlarm a = ABTimer.build(AlarmType.Second);
                a.setHour(w.getHour());
                a.setMin(w.getMin());
                a.setSec(w.getSec());
                deleteAlarm(a.AtoString());
            } catch (IOException | UnsupportedOperationException | MyException e) {}
            return true;
        }
        w.deleteAl();
        return false;
    }
    
    ArrayList<String> listFromDB() {
        ArrayList<String> resList = new ArrayList<>();
        
        try {
            Statement st = c.createStatement();
            ResultSet res = st.executeQuery("select * from clock");
            while (res.next()) {
                resList.add(res.getString("alarm"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Warning");
        }
        
        return resList;
    }
    
    void update() {
        for (IObserver o : all_o) {
            o.update(m);
        }
    }
    
    public void saveAlarm(String a) {
        try {
            PreparedStatement pst = c.prepareStatement("INSERT INTO clock(alarm) VALUES(?)");
            pst.setString(1, a);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Warning");
        }
    }
    
    public void deleteAlarm(String a) {
        try {
            PreparedStatement pst = c.prepareStatement(" DELETE FROM clock WHERE alarm = (?)");
            pst.setString(1, a);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Warning");
        }
    }
    
    public void add(BaseAlarm a) {
        w.addAlarm(a);
        saveAlarm(a.AtoString());
        update();
    }
    
    public void deleteAlarm(BaseAlarm a) {//почему-то не удаляется
        w.deleteAlarm(a);
        deleteAlarm(a.AtoString());
        update();
    }
    
    public BaseWatch getTime() {
        return w.getWatch();
    }
    
    public String getAlarms() {
        String alarms = "a";
        List list = w.getAlarms();
        for (int i = 0; i < list.size(); i++){
            BaseAlarm al = (BaseAlarm)list.get(i);
            alarms += al.AtoString() + "\n";
        }
        /*ArrayList<String> list = listFromDB();
        for (String al:list)
            alarms += al + "\n";*/
        
        return alarms;
    }
    
    public void addO(IObserver o) {
        all_o.add(o);
    }
    
    public void pause1() {
        pausethis = true;
    }
    public void continue1() {
        synchronized(m) {
            m.notifyAll();
        }
    }
}
