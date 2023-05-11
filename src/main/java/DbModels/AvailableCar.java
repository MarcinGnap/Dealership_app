package DbModels;

public class AvailableCar {
    public String car_id;
    public String price;
    public String production_year;

    public AvailableCar() {}

    @Override
    public String toString(){
        return this.car_id+" "+this.price+" "+this.production_year;
    }

    public AvailableCar(String car_id, String price, String procudtion_year) {
        this.car_id = car_id;
        this.price = price;
        this.production_year = procudtion_year;
    }

    public String getId(){
        return  this.car_id;
    }
}
