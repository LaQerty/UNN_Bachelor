package pizza;

public class Pizza {
    public String name;
    public String about;
    public int price;
    public Pizza(String name, String a, int p){
        this.name = name;
        this.about = a;
        this.price = p;
    }
    
    public String toString(){
        return "Name: " + this.name + "\nAbout: " + this.about + "\nPrice: " + this.price + " Ru\n";
    }
}
