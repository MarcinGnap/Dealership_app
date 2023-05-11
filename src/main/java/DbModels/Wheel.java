package DbModels;

public class Wheel {
    public String wheel_id;
    public String color_id;
    public String diameter;
    public String ET;
    public String producer;
    public String weight;
    public String width;
    public String price;

    public Wheel() {
    }

    public Wheel(String wheelId, String colorId, String diameter, String ET, String producer, String weight, String width, String price) {
        this.wheel_id = wheelId;
        this.color_id = colorId;
        this.diameter = diameter;
        this.ET = ET;
        this.producer = producer;
        this.weight = weight;
        this.width = width;
        this.price = price;
    }

    @Override
    public String toString(){
        return this.producer+" "+this.diameter+"'"+this.weight+"kg "+this.width+"'";
    }

    public String getId(){
        return  this.wheel_id;
    }

}
