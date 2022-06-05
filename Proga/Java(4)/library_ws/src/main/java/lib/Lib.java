package lib;


public class Lib {
    String ISBN;
    String autors;
    String years;
    String publishing;
    String name;
    public int count;
    public Lib(String isbn, String au, String yea, String pub, String n){
        this.ISBN=isbn;
        this.autors=au;
        this.years=yea;
        this.publishing=pub;
        this.name=n;
        this.count=0;
    }
    public void setCount(int c){
        this.count+=c;
    }
    @Override
    public String toString(){
        String res = "";
        res+="ISBN: " + this.ISBN + "\n" + "Autors: " + this.autors + "\n" + "Year: " + this.years + "\n" 
                + "Publishing house: " + this.publishing + "\n" + "Name: " + this.name + "\n";
        return res;
    }
}
