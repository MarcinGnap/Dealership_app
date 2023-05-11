package Forms;

import DbModels.*;
import Interfaces.ColorType;
import Interfaces.Drivetrain;
import Services.CarConfigurationService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarConfiguration extends JFrame{
    private JComboBox firstColor;
    private JPanel CarConfiguration;
    private JComboBox secondaryColor;
    private JComboBox engine;
    private JComboBox model;
    private JComboBox gearBox;
    private JComboBox interiorColor;
    private JComboBox wheels;
    private JButton returnButton;
    private JButton proccedButton;
    private JComboBox drivetrain;
    private JTextField priceTextField;
    private int price=0;
    private String clientId;

    public CarConfiguration(String clientId){
        this.clientId = clientId;
        setSize(500,500);
        setTitle("Car Configuration");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(CarConfiguration);
        initializeEngines();
        initializeModels();
        initializeWheels();
        initializeDrivetrain();
        initializeGearboxes();
        initializeFirstColors();
        initializeSecondColors();
        initializeInteriorColors();
        initializeSelectActionListener();
        initializeProceedActionListener();
        this.priceTextField.setEditable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        reutrnButtonListener();
    }

    private void reutrnButtonListener(){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


    private void initializeProceedActionListener(){
        this.proccedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(engine.getSelectedItem() != null
                        && gearBox.getSelectedItem() != null
                        && model.getSelectedItem() != null
                        && firstColor.getSelectedItem() != null
                        && secondaryColor.getSelectedItem() != null
                        && interiorColor.getSelectedItem() != null
                        && drivetrain.getSelectedItem() != null
                        && wheels.getSelectedItem() != null){
                    String engineId = ((Engine)engine.getSelectedItem()).engine_id;
                    String gearboxId = ((Gearbox)gearBox.getSelectedItem()).gearbox_id;
                    String modelId = ((Model)model.getSelectedItem()).model_id;
                    String firstColorId = ((Color)firstColor.getSelectedItem()).color_id;
                    String secondaryColorId = ((Color)secondaryColor.getSelectedItem()).color_id;
                    String interiorColorId = ((Color)interiorColor.getSelectedItem()).color_id;
                    String driveTrain = drivetrain.getSelectedItem().toString();
                    String wheelId = ((Wheel)wheels.getSelectedItem()).wheel_id;
                    CarConfigurationService.addNewOrder(driveTrain,engineId,gearboxId,secondaryColorId,interiorColorId,firstColorId,modelId,wheelId,clientId,price);
                    dispose();
                }


            }
        });
    }

    private void initializeEngines(){
        this.engine.addItem(null);
        for(Engine engine :CarConfigurationService.getEngines()){
            this.engine.addItem(engine);
        }
    }

    private void initializeModels(){

        this.model.addItem(null);
        for(Model model :CarConfigurationService.getModels()){
            this.model.addItem(model);
        }
    }

    private void initializeWheels(){

        this.wheels.addItem(null);
        for(Wheel wheel  :CarConfigurationService.getWheels()){
            this.wheels.addItem(wheel);
        }
    }


    private void initializeDrivetrain(){

        this.drivetrain.addItem(null);
        this.drivetrain.addItem(Drivetrain._4WD);
        this.drivetrain.addItem(Drivetrain.AWD);
        this.drivetrain.addItem(Drivetrain.FWD);
    }

    private void initializeGearboxes(){
        this.gearBox.addItem(null);
        for(Gearbox gearbox : CarConfigurationService.getGearboxes()){
            this.gearBox.addItem(gearbox);
        }
    }


    private void initializeFirstColors(){

        this.firstColor.addItem(null);
        for(Color color : CarConfigurationService.getColorsByType(ColorType.PRIMARY)){
            this.firstColor.addItem(color);
        }

    }

    private void initializeSecondColors(){

        this.secondaryColor.addItem(null);
        for(Color color : CarConfigurationService.getColorsByType(ColorType.SECONDARY)){
            this.secondaryColor.addItem(color);
        }
    }

    private void initializeInteriorColors(){

        this.interiorColor.addItem(null);
        for(Color color : CarConfigurationService.getColorsByType(ColorType.INTERIOR)){
            this.interiorColor.addItem(color);
        }
    }


    private void recalculateCost(){
        int localPrice = 0 ;

        if(this.engine.getSelectedItem() != null){
            localPrice += Integer.parseInt(((Engine)this.engine.getSelectedItem()).price);
        }
        if(this.gearBox.getSelectedItem() != null){
            localPrice += Integer.parseInt(((Gearbox)this.gearBox.getSelectedItem()).price);
        }
        if(this.model.getSelectedItem() != null){
            localPrice += Integer.parseInt(((Model)this.model.getSelectedItem()).price);
        }
        if(this.firstColor.getSelectedItem() != null){
            localPrice += Integer.parseInt(((Color)this.firstColor.getSelectedItem()).price);
        }
        if(this.secondaryColor.getSelectedItem() != null){
            localPrice += Integer.parseInt(((Color)this.secondaryColor.getSelectedItem()).price);
        }
        if(this.interiorColor.getSelectedItem() != null){
            localPrice += Integer.parseInt(((Color)this.interiorColor.getSelectedItem()).price);
        }
        if(this.wheels.getSelectedItem() != null){
            localPrice += Integer.parseInt(((Wheel)this.wheels.getSelectedItem()).price);
        }
        this.price = localPrice ;
        this.priceTextField.setText(String.valueOf(this.price));
    }
    private void initializeSelectActionListener(){
        this.engine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recalculateCost();
            }
        });
        this.model.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recalculateCost();
            }
        });
        this.interiorColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recalculateCost();
            }
        });
        this.secondaryColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recalculateCost();
            }
        });
        this.interiorColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recalculateCost();
            }
        });
        this.gearBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recalculateCost();
            }
        });
    };



}
