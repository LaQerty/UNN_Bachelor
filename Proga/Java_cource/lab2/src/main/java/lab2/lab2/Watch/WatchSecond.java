package lab2.lab2.Watch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WatchSecond extends WatchFirst {
    protected int sec = 0;
    protected String model = "Two";
    protected String cost = "2000 $";

    @Override
    public void setSec() throws MyException, IOException{
        System.out.println("Enter seconds (0-59) ");
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Seconds ");
        String input3 = reader.readLine();
        if (!input3.matches("[-+]?\\d+"))
            throw new IOException("!Wrong input!");
        int _sec = Integer.parseInt(input3);

        if ((_sec < 0) || (_sec > 59)) {
            throw new MyException("!Wrong time format!");
        }
        sec = _sec;
    }

    @Override
    public void setSec(int _sec) throws MyException, IOException{
        if ((_sec < 0) || (_sec > 59)) {
            throw new MyException("!Wrong time format!");
        }
        sec = _sec;
    }

    @Override
    public void moveSec() throws MyException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter time offset in seconds (0-59) ");
        String input3 = reader.readLine();
        if (!input3.matches("[-+]?\\d+"))
            throw new IOException("!Wrong input!");
        int _sec = Integer.parseInt(input3);

        if ((_sec < 0) || (_sec > 59)) {
            throw new MyException("!Wrong time format!");
        }
        hour = (hour + (min + (sec + _sec) / 60) / 60) % 24;
        min = (min + (sec + _sec) / 60) % 60;
        sec = (sec + _sec) % 60;       
    }

    @Override
    public void moveSec(int _sec) throws MyException, IOException{
        if ((_sec < 0) || (_sec > 59)) {
            throw new MyException("!Wrong time format!");
        }
        this.hour = (this.hour + (this.min + (this.sec + _sec) / 60) / 60) % 24;
        this.min = (this.min + (this.sec + _sec) / 60) % 60;
        this.sec = (this.sec + _sec) % 60;
    }

    @Override
    public int getSec()throws MyException, IOException{
        return sec;
    }

    @Override
    public String toString() {
        if (sec < 10) {
            return super.toString() + ":0" + sec;
        }else{
            return super.toString() + ":" + sec;}
    }
}
