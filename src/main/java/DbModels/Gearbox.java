package DbModels;

public class Gearbox {
    public String gearbox_id;
    public String gearbox_code;
    public String gearbox_type;
    public String gears_number;
    public String price;

    public Gearbox() {
    }

    public Gearbox(String gearboxId, String gearboxCode, String gearboxType, String gearsNumber, String price) {
        this.gearbox_id = gearboxId;
        this.gearbox_code = gearboxCode;
        this.gearbox_type = gearboxType;
        this.gears_number = gearsNumber;
        this.price = price;
    }

    @Override
    public String toString(){
        return this.gearbox_type+" "+this.gearbox_code+" "+this.gears_number+" gears";
    }

    public String getId(){
        return  this.gearbox_id;
    }

}
