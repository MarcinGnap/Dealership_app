package DbModels;

public class Model {
    public String model_id;
    public String body_type;
    public String brand_name;
    public String model_name;
    public String price;

    public Model(){}

    public Model(String modelId, String bodyType, String brandName, String modelName, String price) {
        this.model_id = modelId;
        this.body_type = bodyType;
        this.brand_name = brandName;
        this.model_name = modelName;
        this.price = price;
    }

    @Override
    public String toString(){
        return this.brand_name+" "+this.model_name+" "+this.body_type;
    }

    public String getId(){
        return  this.model_id;
    }
}
