package lab2.lab2.Watch;

public class WBTimer {
    public static BaseWatch build(WatchType type){
        if(type == WatchType.First)
            return new WatchFirst();
        if (type == WatchType.Second)
            return new WatchSecond();
        return null;
    }
}
