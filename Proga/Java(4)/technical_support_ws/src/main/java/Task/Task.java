package Task;

public class Task {
    String name;
    String email;
    String date;
    String descr;
    String status;
    public Task(String name, String email, String date, String descr) {
        this.name = name;
        this.email = email;
        this.date = date;
        this.descr = descr;
        this.status = "CREATE";
    }
    
    public void setStatus(String st){
        status = st;
    }
    
    public String getStatus(){
        return status;
    }
    
    public String getDate(){
        return date;
    }
    
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getDescr(){
        return descr;
    }
    
    public void addDescr(String mes){
        descr += mes;
    }
}
