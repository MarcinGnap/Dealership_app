package Services;

import DbModels.Order;
import Interfaces.Status;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrderService {
    public static ArrayList<Order> getOrdersById(String ClientId){
        DatabaseConnector db = new DatabaseConnector();
        try{
            return ResultSetConverter.resultSetToArrayList(db.getOrdersById(ClientId),Order.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    };
    public static ArrayList<Order> getOrdersByStatus(String Status){
        DatabaseConnector db = new DatabaseConnector();
        try{
            return ResultSetConverter.resultSetToArrayList(db.getOrdersByStatus(Status),Order.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    };
    public static ArrayList<Order> getOrders(){
        DatabaseConnector db = new DatabaseConnector();
        try{
            return ResultSetConverter.resultSetToArrayList(db.getOrders(),Order.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    };

    public static void addNewOrderShort(String clientId, String carId, String price){
        DatabaseConnector db = new DatabaseConnector();
        try{
            db.addOrder(new Order(null,clientId,null,carId,null, LocalDate.now().toString(), Status.NEW,price));
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void updateOrderStatus(String orderId, String newValue){
        DatabaseConnector db = new DatabaseConnector();
        try{
            db.updateOrder("order_status",newValue, orderId);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void updateOrderEstimatedDeliveryDate(String orderId, String newValue){
        DatabaseConnector db = new DatabaseConnector();
        try{
            db.updateOrder("estimated_delivery_date",newValue, orderId);
        }catch (Exception e){
            System.out.println(e);
        }
    };
    public static void updateOrderCustodian(String orderId, String newValue){
        DatabaseConnector db = new DatabaseConnector();
        try{
            db.updateOrder("order_custodian_id",newValue, orderId);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
