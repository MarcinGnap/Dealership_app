package Services;

import DbModels.*;
import Interfaces.Status;
import org.jdbi.v3.core.Jdbi;

import java.sql.*;

public class DatabaseConnector {
    Connection connection;
    Statement statement;
    String url = "jdbc:mysql://25.60.138.167:3306/klapexdealer1";
    String userName = "newuser";
    String password = "dupaGnapa";
    Jdbi jdbiConnection;




    public DatabaseConnector(){
        jdbiConnection = Jdbi.create(url,userName,password);
    }

    private boolean openConnection()  {
        try{
            this.connection = DriverManager.getConnection(url, userName, password);
            this.statement = this.connection.createStatement();
        }catch (SQLException error){
            System.out.println(error);
            return false;
        }
        return true;
    }

    private boolean closeConnection(){
        try{
            this.connection.close();
        }catch (SQLException error){
            System.out.println(error);
            return false;
        }
        return true;
    };


    public boolean insertValueIntoColors(String colorName, String colorType)  {
        if(openConnection()){
            try{
                this.statement.execute("insert into colors values (null,"+colorName+","+colorType+")");
                closeConnection();
                return true;
            }catch (SQLException error){
                System.out.println(error);
                closeConnection();
                return false;
            }
        }else{
            closeConnection();
            return false;
        }

    }


    public boolean insertValueIntoClients(int personId){
        if(openConnection()){
            try{
                return this.statement.execute("insert into clients values (null,"+personId+")");
            }catch (SQLException error){
                System.out.println(error);
                return false;
            }
        }else{
            return false;
        }
    }

    public ResultSet getModels(){
        if(openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM models");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else{
            return null;
        }
    }
    public ResultSet getEngines(){
        if(openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM engines");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else{
            return null;
        }
    }
    public ResultSet getWheels(){
        if(openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM wheels");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else{
            return null;
        }
    }

    public ResultSet getColors(){
        if(openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM colors");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else{
            return null;
        }
    }

    public ResultSet getGearboxes(){
        if(openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM gearboxes");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else{
            return null;
        }
    }

    public ResultSet getAvailableCars(){
        if (openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM available_cars");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else {
            return null;
        }
    }

    public void removeAvailableCar(String id){
        jdbiConnection.withHandle(handle -> {
            return handle.createUpdate("DELETE FROM available_cars WHERE car_id = '"+id+"'")
                    .execute();
        });
    }

    public ResultSet getAvailableCarsInfo(){
        if (openConnection()){
            try{
                return this.statement.executeQuery("SELECT available_cars.car_id, available_cars.price, available_cars.production_year, models.brand_name, models.model_name, models.body_type, engines.capacity, engines.fuel, engines.horse_power, gearboxes.gearbox_type, gearboxes.gears_number, wheels.diameter, colors.color_name FROM cars JOIN available_cars ON cars.car_id = available_cars.car_id JOIN models ON cars.model_id = models.model_id JOIN engines ON cars.engine_id = engines.engine_id JOIN gearboxes ON cars.gearbox_id = gearboxes.gearbox_id JOIN wheels ON cars.wheel_id = wheels.wheel_id JOIN colors ON cars.main_color_id = colors.color_id WHERE cars.car_id IN (SELECT car_id FROM available_cars)");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else {
            return null;
        }
    }

    public ResultSet getClient(int Clientid){
        if(openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM clients WHERE person_id = '"+Clientid+"'");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else{
            return null;
        }
    }

    public void addModel(Model model){
        if(openConnection()){
            try{
                this.statement.execute("INSERT INTO models values (null,'"+model.body_type +"','"+model.brand_name +"','"+model.model_name +"','"+model.price+"')");
            }catch (SQLException error){
                System.out.println(error);
            }
        }
    }

    public void addEngine(Engine engine){
        if(openConnection()){
            try{
                this.statement.execute("INSERT INTO engines values (null,'"+engine.capacity+"','"+engine.engine_code +"','"+engine.fuel+"','"+engine.horse_power +"','"+engine.power+"','"+engine.torque+"','"+engine.price+"')");
            }catch (SQLException error){
                System.out.println(error);
            }
        }
    }

    public void addGearbox(Gearbox gearbox){
        if(openConnection()){
            try{
                this.statement.execute("INSERT INTO gearboxes values (null,'"+gearbox.gearbox_code +"','"+gearbox.gearbox_type +"','"+gearbox.gears_number +"','"+gearbox.price+"')");
            }catch (SQLException error){
                System.out.println(error);
            }
        }
    }

    public void addColor(Color color){
        if(openConnection()){
            try{
                this.statement.execute("INSERT INTO colors values (null,'"+color.color_name +"','"+color.color_type +"','"+color.price+"')");
            }catch (SQLException error){
                System.out.println(error);
            }
        }
    }

    public void addWheel(Wheel wheel){
        if(openConnection()){
            try{
                this.statement.execute("INSERT INTO wheels values (null,'"+wheel.color_id +"','"+wheel.diameter+"','"+wheel.ET+"','"+wheel.producer+"','"+wheel.weight+"','"+wheel.width+"','"+wheel.price+"')");
            }catch (SQLException error){
                System.out.println(error);
            }
        }
    }

    public String addCar(Car car){
        return jdbiConnection.withHandle(handle -> {
            handle.createUpdate("INSERT INTO cars values (null,'"+car.drivetrain+"','"+car.engine_id +"','"+car.gearbox_id +"','"+car.interior_color_id +"','"+car.interior_color_id +"','"+car.main_color_id +"','"+car.model_id +"','"+car.wheel_id +"')")
                    .execute();
            return handle.createQuery("SELECT MAX(car_id) FROM cars").mapTo(String.class).one();
        });
    }

    public void removeEngine(String id){
        jdbiConnection.withHandle(handle -> {
            return handle.createUpdate("DELETE FROM engines WHERE engine_id = '"+id+"'")
                    .execute();
        });
    }


    public void removeWheel(String id){
        jdbiConnection.withHandle(handle -> {
            return handle.createUpdate("DELETE FROM wheels WHERE wheel_id = '"+id+"'")
                    .execute();
        });
    }

    public void removeModel(String id){
        jdbiConnection.withHandle(handle -> {
            return handle.createUpdate("DELETE FROM models WHERE model_id = '"+id+"'")
                    .execute();
        });
    }

    public void removeGearBox(String id){
        jdbiConnection.withHandle(handle -> {
            return handle.createUpdate("DELETE FROM gearboxes WHERE gearbox_id = '"+id+"'")
                    .execute();
        });
    }

    public void removeColor(String id){
        jdbiConnection.withHandle(handle -> {
            return handle.createUpdate("DELETE FROM colors WHERE color_id = '"+id+"'")
                    .execute();
        });
    }

    public void addAvailableCar(AvailableCar availableCar){
        if(openConnection()){
            try{
                this.statement.execute("INSERT INTO available_cars values ("+availableCar.car_id +",'"+availableCar.price+"','"+availableCar.production_year +"')");
            }catch (SQLException error){
                System.out.println(error);
            }
        }
    }

    public void addClient(Client client){
        if(openConnection()){
            try{
                this.statement.execute("INSERT INTO clients values (null,'"+client.person_id +"')");
            }catch (SQLException error){
                System.out.println(error);
            }
        }
    }

    public void addPerson(Person person ){
        if(openConnection()){
            try{
                this.statement.execute("INSERT INTO persons values (null,'"+person.address+"','"+person.birth_date +"','"+person.first_name +"','"+person.last_name+"','"+person.pesel+"','"+person.password+"','"+person.person_type+"')");
            }catch (SQLException error){
                System.out.println(error);
            }
        }
    }

    public void addOrder(Order order){
        if(openConnection()){
            try{
                this.statement.execute("INSERT INTO orders VALUES (null,'"+order.client_id+"',null,'"+order.order_car_id+"',null,'"+order.order_date+"','"+ Status.NEW +"','"+order.price+"')");
            }catch (SQLException error){
                System.out.println(error);
            }
        }
    }

    public ResultSet getOrders(){
        if (openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM orders");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else {
            return null;
        }
    }

    public ResultSet getOrdersById(String clientId){
        if (openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM orders WHERE client_id = '"+clientId+"'");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else {
            return null;
        }
    }

    public ResultSet getOrdersByStatus(String Status){
        if (openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM orders WHERE order_status = '"+Status+"'");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else {
            return null;
        }
    }

    public ResultSet getWorkersByRole(String jobPosition){
        if (openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM workers WHERE job_position = '"+jobPosition+"'");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else {
            return null;
        }
    }

    public ResultSet getWorkers(){
        if (openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM workers");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else {
            return null;
        }
    }

    public void updateOrder(String columnName, String newValue, String orderId){
        jdbiConnection.withHandle(handle -> {
            return handle.createUpdate("UPDATE orders SET "+columnName+" = '"+newValue+"' WHERE order_id = "+orderId+"")
                    .execute();
        });
    }


    public void updateWorkerJobPosition( String newValue, String workerId){
        jdbiConnection.withHandle(handle -> {
            return handle.createUpdate("UPDATE workers SET job_position = '"+newValue+"' WHERE worker_id = "+workerId+"")
                    .execute();
        });
    }

    public ResultSet loginPerson(String pesel, String userPassword){
        if(openConnection()){
            try{
                return this.statement.executeQuery("SELECT * FROM persons WHERE pesel = '"+pesel+"' AND password = '"+userPassword+"'");
            }catch (SQLException error){
                System.out.println(error);
                return null;
            }
        }else{
            return null;
        }
    }

}
