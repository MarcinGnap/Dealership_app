package DbModels;

public class Order {
    public String order_id;
    public String client_id;
    public String estimated_delivery_date;
    public String order_car_id;
    public String order_custodian_id;
    public String order_date;
    public String order_status;
    public String price;

    public Order() {
    }

    public Order(String orderId, String clientId, String estimatedDeliveryDate, String orderedCarId, String orderCustodianId, String orderDate, String orderStatus, String price) {
        this.order_id = orderId;
        this.client_id = clientId;
        this.estimated_delivery_date = estimatedDeliveryDate;
        this.order_car_id = orderedCarId;
        this.order_custodian_id = orderCustodianId;
        this.order_date = orderDate;
        this.order_status = orderStatus;
        this.price = price;
    }

    public String getId(){
        return  this.order_id;
    }

    @Override
    public String toString(){
        return "Order ID: "+this.order_id+" , Status: "+this.order_status+" , Delivery date: "+this.estimated_delivery_date+" , Custodian Id: "+this.order_custodian_id;
    }
}
