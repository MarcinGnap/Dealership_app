package Forms;

import DbModels.AvailableCar;
import DbModels.CarInfo;
import DbModels.Client;
import DbModels.Person;
import Interfaces.PersonType;
import Services.AvailableCarsService;
import Services.DatabaseConnector;
import Services.OrderService;
import Services.PersonService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class availableCars extends JFrame{
    private JPanel availableCars;
    private JScrollPane availableCarsList;
    private JButton returnButton;
    private JButton buyButton;
    private JList list1;
    DefaultListModel model = new DefaultListModel();

    private Person person = null;

    public availableCars(Person person){
        this.person = person;
        setSize(720,720);
        setTitle("Available Cars");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        list1.setModel(model);
        initializeList();
        reutrnButtonListener();
        buyButtonListener();
        this.setContentPane(availableCars);
        this.setVisible(true);
    }

    private void reutrnButtonListener(){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    void buyButtonListener(){
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                CarInfo value = (CarInfo) list1.getSelectedValue();
                model.remove(index);
                AvailableCarsService.removeAvailableCar(value.getId());
                OrderService.addNewOrderShort(person.person_id, value.car_id, value.price);
            }
        });
    }

    private void initializeList(){
        for (CarInfo avCar : AvailableCarsService.getAvailableCarsInfo()) {
            model.addElement(avCar);
        }
    }
}
