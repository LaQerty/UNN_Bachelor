package lab2.lab2.Watch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WatchFirst implements BaseWatch{
    protected int hour = 0;
    protected int min = 0;
    protected String model = "One";
    protected String cost = "1000 $";

    @Override
    public void setHour() throws MyException, IOException {
        System.out.println("Enter hours (0-23) ");
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Hours ");
        String input1 = reader.readLine();
        if (!input1.matches("[-+]?\\d+"))
            throw new IOException("!Wrong input!");
        int _hour = Integer.parseInt(input1);
        if ((_hour < 0) || (_hour > 23)) {
            throw new MyException("!Wrong time format!");
        }
        this.hour = _hour;
    }

    @Override
    public void setMin() throws MyException, IOException{
        System.out.println("Enter minutes (0-59) ");
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Minutes ");
        String input1 = reader.readLine();
        if (!input1.matches("[-+]?\\d+"))
            throw new IOException("!Wrong input!");
        int _min = Integer.parseInt(input1);
        if ((_min< 0) || (_min > 59)) {
            throw new MyException("!Wrong time format!");
        }
        this.min = _min;
    }

    @Override
    public void setSec() throws MyException, IOException {
        throw new UnsupportedOperationException("This watch model doesn't support seconds");
    }

    @Override
    public void setHour(int _hour) throws MyException, IOException {
        if ((_hour < 0) || (_hour > 23)) {
            throw new MyException("!Wrong time format!");
        }
        this.hour = _hour;
    }

    @Override
    public void setMin(int _min) throws MyException, IOException{
        if ((_min< 0) || (_min > 59)) {
            throw new MyException("!Wrong time format!");
        }
        this.min = _min;
    }

    @Override
    public void setSec(int _sec) throws MyException, IOException {
        throw new UnsupportedOperationException("This watch model doesn't support seconds");
    }

    @Override
    public void moveHour() throws MyException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter time offset in hours (0-23) ");
        String input1 = reader.readLine();
        if (!input1.matches("[-+]?\\d+"))
            throw new IOException("!Wrong input!");
        int _hour = Integer.parseInt(input1);

        if ((_hour < 0) || (_hour > 23)) {
            throw new MyException("!Wrong time format!");
        }

        hour = (hour + _hour) % 24;
    }

    @Override
    public void moveMin() throws MyException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter time offset in minutes (0-59) ");
        String input2 = reader.readLine();
        if (!input2.matches("[-+]?\\d+"))
            throw new IOException("!Wrong input!");
        int _min = Integer.parseInt(input2);

        if ((_min > 59) || (_min < 0)) {
            throw new MyException("!Wrong time format!");
        }
        this.min = (this.min + _min) % 60;
        this.hour += ((this.min + _min) / 60);
    }

    @Override
    public void moveSec() throws MyException, IOException{
        throw new UnsupportedOperationException("This watch model doesn't support seconds");
    }

    public void moveHour(int _hour) throws MyException, IOException{
        if ((_hour < 0) || (_hour > 23)) {
            throw new MyException("!Wrong time format!");
        }

        this.hour = (this.hour + _hour) % 24;
    }

    @Override
    public void moveMin(int _min) throws MyException, IOException{
        if ((_min > 59) || (_min < 0)) {
            throw new MyException("!Wrong time format!");
        }
        this.min = (this.min + _min) % 60;
        this.hour = (this.hour + ((this.min + _min) / 60)) % 24;
    }

    @Override
    public void moveSec(int _sec) throws MyException, IOException{
        throw new UnsupportedOperationException("This watch model doesn't support seconds");
    }

    @Override
    public void getModel(){
        System.out.println("Model is " + this.model);
    }

    @Override
    public void getCost(){
        System.out.println("Cost is " + this.cost);
    }

    @Override
    public String toString() {
        if (min < 10) {
            return hour + ":0" + min;
        } else {
            return hour + ":" + min;
        }
    }

    @Override
    public int getHour(){ return hour; }
    @Override
    public int getMin(){
        return min;
    }
    @Override
    public int getSec() throws MyException, IOException{
        throw new UnsupportedOperationException("This watch model doesn't support seconds");
    }
}
