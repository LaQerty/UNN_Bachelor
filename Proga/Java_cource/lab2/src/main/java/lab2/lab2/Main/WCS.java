/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.lab2.Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import lab2.lab2.Alarm.ABTimer;
import lab2.lab2.Alarm.AlarmType;
import lab2.lab2.Alarm.BaseAlarm;
import lab2.lab2.Watch.MyException;


/**
 *
 * @author Admin
 */
public class WCS extends Thread implements IObserver{
    
    Socket cs;
    Model m;
    
    OutputStream os;
    InputStream is;
    DataInputStream dis;
    DataOutputStream dos;
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public WCS(Socket s, Model m) {
        this.cs = s;
        this.m = m;
        try {
            os = cs.getOutputStream();
            dos = new DataOutputStream(os);
        } catch (IOException ex) {
            Logger.getLogger(WCS.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addO(this);
        this.start();
        
    }
    
    public void send(String s) {
        try {
            dos.writeUTF(s);
        } catch (IOException ex) {
            Logger.getLogger(WCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        try {
            is = cs.getInputStream();
            dis = new DataInputStream(is);
            
            while (true) {
                String obj = dis.readUTF();
                Msg msg = gson.fromJson(obj, Msg.class);
                String al = msg.getMsg();
                if (al.startsWith("a")) {
                    al = al.substring(1);
                    try {
                        BaseAlarm a = ABTimer.build(AlarmType.Second);
                        a.setHour(Integer.parseInt(al.substring(0,2)));
                        a.setMin(Integer.parseInt(al.substring(3,5)));
                        a.setSec(Integer.parseInt(al.substring(6)));
                        m.add(a);
                    } catch (IOException | UnsupportedOperationException | MyException e) {}
                } else if (al.startsWith("d")) {
                    al = al.substring(1);
                    try {
                        BaseAlarm a = ABTimer.build(AlarmType.Second);
                        a.setHour(Integer.parseInt(al.substring(0,2)));
                        a.setMin(Integer.parseInt(al.substring(3,5)));
                        a.setSec(Integer.parseInt(al.substring(6)));
                        m.deleteAlarm(a);
                    } catch (IOException | UnsupportedOperationException | MyException e) {}
                } else if (al.startsWith("c")) {
                    al = al.substring(1);
                    if (al.startsWith("p"))
                        m.pause1();
                    if (al.startsWith("c"))
                        m.continue1();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(WCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void update(Model m) {
        send("t" + m.getTime().toString());
        send(m.getAlarms());
        if (m.isAlarm()) {
            send("ca");
        }
    }
}
