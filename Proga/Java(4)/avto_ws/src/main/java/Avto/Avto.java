package Avto;


public class Avto {
    public String model;
    public int mileage;
    public String condition;
    public int price;
    public boolean inRent;
    
    public Avto(String m, int mi, String c, int p){
        this.condition = c;
        this.mileage = mi;
        this.model = m;
        this.price = p;
        this.inRent = false;
    }
    
    public void changeСharacteristics(int mi, String c){
        this.mileage = mi;
        this.condition = c;
    }
    
    public String getCar(int days){
        if(!this.inRent){
            return "Price: " + this.price*days;
        } else return "This car now in rent!\n";
    }
    
    public void returnCar(){
        this.inRent = false;
    }
    
    public String toString(){
        return "Model: " + this.model + "\nMileage: " + this.mileage + "000\nCondition: " + this.condition + "\nPrice: " + this.price + "000 RU\n";
    }
}
