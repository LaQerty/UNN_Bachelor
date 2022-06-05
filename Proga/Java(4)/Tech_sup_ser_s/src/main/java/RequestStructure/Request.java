package RequestStructure;

public class Request {
    public String ownerName;
    public String ownerEmail;
    public String date;
    public String text;
    public String status;
    
    public Request(String n, String e, String d, String t){
        this.ownerName = n;
        this.date = d;
        this.ownerEmail = e;
        this.text = t;
        this.status = "NEW";
    }
    
    public String toString(){
        String res = "";
        res+="Owner name: " + this.ownerName +"\nOwner email: " + this.ownerEmail 
                + "\nDate: " + this.date + "\nText: " + this.text + "\nStatus: " + this.status;
        return res;
    }
}
