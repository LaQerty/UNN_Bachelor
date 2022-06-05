package lab2.lab2.Main;

import lab2.lab2.Watch.MyException;
import lab2.lab2.lab2.AlarmClock.BaseClock;
import lab2.lab2.lab2.AlarmClock.CBTimer;
import lab2.lab2.lab2.AlarmClock.ClockType;
import  java.io.IOException;


public class Main {
    public static void main(String[] args){
        System.out.println("Alarm Clock Second");
        BaseClock w = CBTimer.build(ClockType.Second);
        try {
            w.setHour(12);
            w.setMin(59);
            w.setSec(58);
            System.out.println(w.toString());
            w.addAlarm();
            System.out.println(w.AtoString());
            for (int i = 0; i < 15; i++) {
                w.moveSec(1);
                System.out.println(w.toString());
            }
        } catch (IOException | UnsupportedOperationException | MyException e){
            System.err.println(e.getMessage());
        }
    }
    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }*/
}
