package lab2.lab2.Alarm;

public class ABTimer {
    public static BaseAlarm build(AlarmType type){
        if(type == AlarmType.First)
            return new AlarmFirst();
        if (type == AlarmType.Second)
            return new AlarmSecond();
        return null;
    }
}
