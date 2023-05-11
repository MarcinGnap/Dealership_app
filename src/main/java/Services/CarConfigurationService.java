package Services;

import DbModels.*;
import Interfaces.ColorType;
import Interfaces.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarConfigurationService {

    public static ArrayList<Model> getModels() {
        DatabaseConnector db = new DatabaseConnector();
        try{
            return ResultSetConverter.resultSetToArrayList(db.getModels(),Model.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Engine> getEngines()  {
        DatabaseConnector db = new DatabaseConnector();
        try{
            return ResultSetConverter.resultSetToArrayList(db.getEngines(),Engine.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    public static ArrayList<Wheel> getWheels() {
        DatabaseConnector db = new DatabaseConnector();
        try{
            return ResultSetConverter.resultSetToArrayList(db.getWheels(), Wheel.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Gearbox> getGearboxes()  {
        DatabaseConnector db = new DatabaseConnector();
        try{
            return ResultSetConverter.resultSetToArrayList(db.getGearboxes(), Gearbox.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Color> getColors() {
        DatabaseConnector db = new DatabaseConnector();
        try{
            return ResultSetConverter.resultSetToArrayList(db.getColors(), Color.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Color> getColorsByType(String type) {
        DatabaseConnector db = new DatabaseConnector();
        try{
            ArrayList<Color> result = ResultSetConverter.resultSetToArrayList(db.getColors(), Color.class);
            List<Color> filterResult = result.stream().filter(color -> color.color_type.equals(type)).collect(Collectors.toList());
            return new ArrayList<Color>(filterResult);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static void addNewOrder(String drivetrain, String engineId, String gearboxId, String additionalColorId, String interiorColorId, String mainColorId, String modelId, String wheelId, String clientId,int price){
        DatabaseConnector db = new DatabaseConnector();
        Car car = new Car(drivetrain,engineId,gearboxId,additionalColorId,interiorColorId,mainColorId,modelId,wheelId);
        String newCarId = db.addCar(car);
        try{
            db.addOrder(new Order(null,clientId,null,newCarId,null,LocalDate.now().toString(), Status.NEW,Integer.toString(price)));
        }catch (Exception e){
            System.out.println(e);
        }

    }


    public static void removeEngine(String Id){
        DatabaseConnector db = new DatabaseConnector();
        db.removeEngine(Id);
    }


    public static void removeWheel(String Id){
        DatabaseConnector db = new DatabaseConnector();
        db.removeWheel(Id);
    }

    public static void removeColor(String Id){
        DatabaseConnector db = new DatabaseConnector();
        db.removeColor(Id);
    }

    public static void removeModel(String Id){
        DatabaseConnector db = new DatabaseConnector();
        db.removeModel(Id);
    }

    public static void removeGearBox(String Id){
        DatabaseConnector db = new DatabaseConnector();
        db.removeGearBox(Id);
    }

    public static void addColor(String colorName, String colorType, String price){
        DatabaseConnector db = new DatabaseConnector();
        db.addColor(new Color(colorName, colorType, price));
    }

    public static void addEngine(String capacity, String engineCode, String fuel, String horsePower, String power, String torque, String price) {
        DatabaseConnector db = new DatabaseConnector();
        db.addEngine(new Engine(null, capacity,engineCode,fuel,horsePower,power,torque,price));
    }

    public static void addModel( String bodyType, String brandName, String modelName, String price) {
        DatabaseConnector db = new DatabaseConnector();
        db.addModel(new Model(null, bodyType, brandName, modelName,price));
    }

    public static void addGearBox( String gearboxCode, String gearboxType, String gearsNumber, String price) {
        DatabaseConnector db = new DatabaseConnector();
        db.addGearbox(new Gearbox(null, gearboxCode, gearboxType , gearsNumber,price));
    }

    public static void addWheel( String colorId, String diameter, String ET, String producer, String weight, String width, String price) {
        DatabaseConnector db = new DatabaseConnector();
        db.addWheel(new Wheel(null,colorId, diameter, ET, producer, weight, width, price ));
    }
}
