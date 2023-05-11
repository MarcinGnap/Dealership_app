package DbModels;

public class Car {
    public String car_id;
    public String drivetrain;
    public String engine_id;
    public String gearbox_id;
    public String additional_color_id;
    public String interior_color_id;
    public String main_color_id;
    public String model_id;
    public String wheel_id;

    public Car() {
    }

    @Override
    public String toString(){
        return ("Position: "+this.car_id+", Drivetrian: "+this.drivetrain+", Engine: "+this.engine_id+", Gearbox: "+this.gearbox_id+", Additional color: "+this.additional_color_id+", Interior color: "+this.interior_color_id+", Main color: "+this.main_color_id+", Model: "+this.model_id+", Wheels: "+this.wheel_id);
    }
    public Car(String drivetrain, String engineId, String gearboxId, String additionalColorId, String interiorColorId, String mainColorId, String modelId, String wheelId) {
        this.drivetrain = drivetrain;
        this.engine_id = engineId;
        this.gearbox_id = gearboxId;
        this.additional_color_id = additionalColorId;
        this.interior_color_id = interiorColorId;
        this.main_color_id = mainColorId;
        this.model_id = modelId;
        this.wheel_id = wheelId;
    }

    public String getId(){
        return  this.car_id;
    }
}
