package Struct;

public class Tec_sup {
    public String FIO;
    public String email;
    public String date;
    public String text;
    public int status;
    public String[] statuses = {"NEW","COMPLETED","REOPEN","AT WORK", "DONE"};
    
    public Tec_sup(String f, String e, String d, String t){
        this.FIO = f;
        this.date = d;
        this.email = e;
        this.text = t;
        this.status = 0;
    }
    
    public String getStatus(){
        return this.statuses[this.status];
    }
    public String toString(){
        return "FIO: " + this.FIO + "\nEmail: " + this.email + "\nStatus: " + this.statuses[this.status] + 
                "\nDate: " + this.date + "\nAbout: " + this.text;
    }
}
