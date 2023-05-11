package DbModels;

public class Color {
    public String color_id;
    public String color_name;
    public String color_type;
    public String price;

    public Color() {
    }

    public Color(String colorName, String colorType, String price) {
        this.color_name = colorName;
        this.color_type = colorType;
        this.price = price;
    }

    @Override
    public String toString(){
        return this.color_id+":"+this.color_name;
    }

    public String getId(){
        return  this.color_id;
    }

}
