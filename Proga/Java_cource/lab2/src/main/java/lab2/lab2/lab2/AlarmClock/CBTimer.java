package lab2.lab2.lab2.AlarmClock;

public class CBTimer {
    public static BaseClock build(ClockType type){
        if(type == ClockType.First)
            return new ClockFirst();
        if (type == ClockType.Second)
            return new ClockSecond();
        return null;
    }
}
