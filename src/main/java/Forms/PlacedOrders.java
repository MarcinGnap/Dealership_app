package Forms;

import DbModels.Order;
import DbModels.Worker;
import Interfaces.Status;
import Services.OrderService;
import Services.WorkersService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlacedOrders extends JFrame{
    private JPanel PlacedOrders;
    private JButton returnButton;
    private JButton changeStatusButton;
    private JComboBox orderStatus;
    private JList list1;
    private JButton changeEstimatedDeliveryDateButton;
    private JTextField estimatedInput;
    private JButton changeCustodianButton;
    private JComboBox custodianId;
    DefaultListModel model = new DefaultListModel();

    public PlacedOrders(){
        setSize(500,500);
        setTitle("Placed Orders");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(PlacedOrders);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        reutrnButtonListener();
        initializeList();
        initializeStatusData();
        initializeCustodianData();
        initializeChangeStatus();
        initializeChangeEstimatedDate();
        initializeChangeCustodian();
    }

    private void initializeChangeStatus(){
        changeStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderService.updateOrderStatus(((Order)list1.getSelectedValue()).order_id,orderStatus.getSelectedItem().toString());
                initializeList();
            }
        });
    }

    private void initializeChangeEstimatedDate(){
        changeEstimatedDeliveryDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderService.updateOrderEstimatedDeliveryDate(((Order)list1.getSelectedValue()).order_id,estimatedInput.getText());
                initializeList();
            }
        });
    }

    private void initializeChangeCustodian(){
        changeCustodianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderService.updateOrderCustodian(((Order)list1.getSelectedValue()).order_id,((Worker)custodianId.getSelectedItem()).worker_id);
                initializeList();
            }
        });
    }




    private void initializeList(){
        list1.setModel(model);
        model.clear();
        for(Order order : OrderService.getOrders()){
            model.addElement(order);
        }
    }

    private void initializeStatusData(){
        orderStatus.removeAllItems();
        orderStatus.addItem(Status.NEW);
        orderStatus.addItem(Status.CAR_IN_PRODUCTION);
        orderStatus.addItem(Status.CAR_IN_PRODUCTION);
        orderStatus.addItem(Status.ORDER_PICKED);
        orderStatus.addItem(Status.ORDER_CANCELED);
        orderStatus.addItem(Status.CAR_READY);
    }

    private void initializeCustodianData(){
        custodianId.removeAllItems();
        for(Worker custodian : WorkersService.getCustodians()){
            custodianId.addItem(custodian);
        }

    }




    private void reutrnButtonListener(){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
