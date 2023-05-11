package Forms;

import DbModels.Order;
import Services.OrderService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarrantyWorker extends JFrame{
    private JPanel WarrantyWorker;
    private JScrollPane warrantyList;
    private JButton acceptButton;
    private JButton rejectButton;
    private JButton returnButton;
    private JList list1;
    DefaultListModel model = new DefaultListModel();

    public WarrantyWorker(){
        setSize(500,500);
        setTitle("Warranty Claims");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(WarrantyWorker);
        list1.setModel(model);
        initializeList();
        reutrnButtonListener();
        rejectButtonListener();
        acceptButtonListener();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void reutrnButtonListener(){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public void rejectButtonListener(){
        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderService.updateOrderStatus(((Order)list1.getSelectedValue()).order_id,"WARRANTY_NEGATIVE");
                model.remove(list1.getSelectedIndex());
                initializeList();
            }
        });
    }

    void acceptButtonListener(){
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderService.updateOrderStatus(((Order)list1.getSelectedValue()).order_id,"WARRANTY_POSITIVE");
                model.remove(list1.getSelectedIndex());
                initializeList();
            }
        });
    }
    private void initializeList(){
        for (Order orders : OrderService.getOrdersByStatus("WARRANTY_CLAIM")) {
            model.addElement(orders);
        }
    }
}
