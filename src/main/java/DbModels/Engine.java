package DbModels;

public class Engine {
    public String engine_id;
    public String capacity;
    public String engine_code;
    public String fuel;
    public String horse_power;
    public String power;
    public String torque;
    public String price;

    public Engine() {
    }

    public Engine(String engine_id, String capacity, String engineCode, String fuel, String horsePower, String power, String torque, String price) {
        this.engine_id = engine_id;
        this.capacity = capacity;
        this.engine_code = engineCode;
        this.fuel = fuel;
        this.horse_power = horsePower;
        this.power = power;
        this.torque = torque;
        this.price = price;
    }

    @Override
    public String toString(){
        return this.fuel+" "+this.engine_code+" "+this.horse_power+"HP";
    }

    public String getId(){
        return  this.engine_id;
    }

}
