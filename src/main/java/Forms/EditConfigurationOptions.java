package Forms;

import DbModels.*;
import Services.CarConfigurationService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditConfigurationOptions extends JFrame{
    private JPanel editConfigurationOptions;
    private JButton enginesButton;
    private JButton colorsButton;
    private JButton gearboxesButton;
    private JButton modelsButton;
    private JButton wheelsButton;
    private JButton removeButton;
    private JButton addButton;
    private JButton returnButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JLabel Option1Label;
    private JLabel Option2Label;
    private JLabel Option3Label;
    private JLabel Option4Label;
    private JLabel Option5Label;
    private JLabel Option6Label;
    private JLabel Option7Label;
    private JLabel Option8Label;
    private JList list1;
    DefaultListModel model = new DefaultListModel();
    int selectedType = 0;

    public EditConfigurationOptions(){
        setTitle("Edit Car Configuration Options");
        this.setSize(800,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(editConfigurationOptions);
        hideAllOptionLabelsAndInputs();
        initializeColorsButtonActionListener();
        initializeGearboxesButtonActionListener();
        initializeEnginesButtonActionListener();
        initializeModelsButtonActionListener();
        initializeWheelsButtonActionListener();
        initializeRemoveButton();
        initializeReturnButton();
        initializeAddButton();
        initializeList();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void hideAllOptionLabelsAndInputs(){
        this.Option1Label.setVisible(false);
        this.Option2Label.setVisible(false);
        this.Option3Label.setVisible(false);
        this.Option4Label.setVisible(false);
        this.Option5Label.setVisible(false);
        this.Option6Label.setVisible(false);
        this.Option7Label.setVisible(false);
        this.Option8Label.setVisible(false);
        this.textField1.setVisible(false);
        this.textField2.setVisible(false);
        this.textField3.setVisible(false);
        this.textField4.setVisible(false);
        this.textField5.setVisible(false);
        this.textField6.setVisible(false);
        this.textField7.setVisible(false);
        this.textField8.setVisible(false);
        this.textField1.setText("");
        this.textField2.setText("");
        this.textField3.setText("");
        this.textField4.setText("");
        this.textField5.setText("");
        this.textField6.setText("");
        this.textField7.setText("");
        this.textField8.setText("");
    }

    private void initializeList(){
        list1.setModel(model);
    }

    private void initializeModelsButtonActionListener(){
        this.modelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedType = 5;
                hideAllOptionLabelsAndInputs();
                Option1Label.setVisible(true);
                Option2Label.setVisible(true);
                Option3Label.setVisible(true);
                Option4Label.setVisible(true);
                textField1.setVisible(true);
                textField2.setVisible(true);
                textField3.setVisible(true);
                textField4.setVisible(true);

                Option1Label.setText("Body type");
                Option2Label.setText("Brand Name");
                Option3Label.setText("Model Name");
                Option4Label.setText("price");
                refresh();


            }
        });
    }


    private void initializeEnginesButtonActionListener(){
        this.enginesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedType = 4;
                hideAllOptionLabelsAndInputs();
                Option1Label.setVisible(true);
                Option2Label.setVisible(true);
                Option3Label.setVisible(true);
                Option4Label.setVisible(true);
                Option5Label.setVisible(true);
                Option6Label.setVisible(true);
                Option7Label.setVisible(true);
                textField1.setVisible(true);
                textField2.setVisible(true);
                textField3.setVisible(true);
                textField4.setVisible(true);
                textField5.setVisible(true);
                textField6.setVisible(true);
                textField7.setVisible(true);

                Option1Label.setText("Capacity");
                Option2Label.setText("Engine Code");
                Option3Label.setText("Fuel");
                Option4Label.setText("Horse Power");
                Option5Label.setText("Power");
                Option6Label.setText("Torque");
                Option7Label.setText("Price");
                refresh();


            }
        });
    }

    private void initializeWheelsButtonActionListener(){
        this.wheelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedType = 3;
                hideAllOptionLabelsAndInputs();
                Option1Label.setVisible(true);
                Option2Label.setVisible(true);
                Option3Label.setVisible(true);
                Option4Label.setVisible(true);
                Option5Label.setVisible(true);
                Option6Label.setVisible(true);
                Option7Label.setVisible(true);
                textField1.setVisible(true);
                textField2.setVisible(true);
                textField3.setVisible(true);
                textField4.setVisible(true);
                textField5.setVisible(true);
                textField6.setVisible(true);
                textField7.setVisible(true);

                Option1Label.setText("Color Id");
                Option2Label.setText("Diameter");
                Option3Label.setText("ET");
                Option4Label.setText("Producer");
                Option5Label.setText("Weight");
                Option6Label.setText("Width");
                Option7Label.setText("Price");

                refresh();


            }
        });
    }

    private void initializeGearboxesButtonActionListener(){
        this.gearboxesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedType = 2;
                hideAllOptionLabelsAndInputs();
                Option1Label.setVisible(true);
                Option2Label.setVisible(true);
                Option3Label.setVisible(true);
                Option4Label.setVisible(true);
                textField1.setVisible(true);
                textField2.setVisible(true);
                textField3.setVisible(true);
                textField4.setVisible(true);

                Option1Label.setText("Gearbox Code");
                Option2Label.setText("Gearbox type");
                Option3Label.setText("Gears Number");
                Option4Label.setText("Price");

                refresh();



            }
        });
    }


    private void initializeColorsButtonActionListener(){
        this.colorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
;
                selectedType = 1;
                hideAllOptionLabelsAndInputs();
                Option1Label.setVisible(true);
                Option2Label.setVisible(true);
                Option3Label.setVisible(true);
                textField1.setVisible(true);
                textField2.setVisible(true);
                textField3.setVisible(true);

                Option1Label.setText("Color Name");
                Option2Label.setText("Color Type");
                Option3Label.setText("Price");

                refresh();



            }
        });
    }

    private void refresh(){
        model.clear();
        switch (selectedType) {
            case 1 -> {
                for (Color color : CarConfigurationService.getColors()) {
                    model.addElement(color);
                }
            }
            case 2 -> {
                for(Gearbox gearbox : CarConfigurationService.getGearboxes()){
                    model.addElement(gearbox);
                }
            }
            case 3 -> {
                for(Wheel wheel : CarConfigurationService.getWheels()){
                    model.addElement(wheel);
                }
            }
            case 4 -> {
                for(Engine engine : CarConfigurationService.getEngines()){
                    model.addElement(engine);
                }
            }
            case 5 -> {
                for(Model carModel : CarConfigurationService.getModels()){
                    model.addElement(carModel);
                }
            }
        }
    }


    private void initializeReturnButton(){
        this.returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void initializeRemoveButton(){
        this.removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list1.getSelectedValue() != null){
                switch (selectedType) {
                    case 1 -> CarConfigurationService.removeColor(((Color)list1.getSelectedValue()).getId());
                    case 2 -> CarConfigurationService.removeGearBox(((Gearbox)list1.getSelectedValue()).getId());
                    case 3 -> CarConfigurationService.removeWheel(((Wheel)list1.getSelectedValue()).getId());
                    case 4 -> CarConfigurationService.removeEngine(((Engine)list1.getSelectedValue()).getId());
                    case 5 -> CarConfigurationService.removeModel(((Model)list1.getSelectedValue()).getId());
                }
                refresh();

                }
            }
        });
    }

    private void initializeAddButton(){
        this.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (selectedType) {
                    case 1 -> addColor();
                    case 2 -> addGearBox();
                    case 3 -> addWheel();
                    case 4 -> addEngine();
                    case 5 -> addModel();
                }
            }
        });
    }


    private void addColor(){
        if (
                textField1.getText().length()>1
                &&textField2.getText().length()>1
                &&textField3.getText().length()>1
        ){
            CarConfigurationService.addColor(textField1.getText(),textField2.getText(),textField3.getText());
            refresh();
        }
    }


    private void addEngine(){
        if (
                textField1.getText().length()>1
                        &&textField2.getText().length()>1
                        &&textField3.getText().length()>1
                        &&textField4.getText().length()>1
                        &&textField5.getText().length()>1
                        &&textField6.getText().length()>1
                        &&textField7.getText().length()>1
        ){
            CarConfigurationService.addEngine(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText(),textField6.getText(),textField7.getText());
            refresh();
        }
    }

    private void addWheel(){
        if (
                textField1.getText().length()>1
                        &&textField2.getText().length()>1
                        &&textField3.getText().length()>1
                        &&textField4.getText().length()>1
                        &&textField5.getText().length()>1
                        &&textField6.getText().length()>1
                        &&textField7.getText().length()>1
        ){
            CarConfigurationService.addWheel(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText(),textField6.getText(),textField7.getText());
            refresh();
        }
    }


    private void addModel(){
        if (
                textField1.getText().length()>1
                        &&textField2.getText().length()>1
                        &&textField3.getText().length()>1
                        &&textField4.getText().length()>1
        ){
            CarConfigurationService.addModel(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText());
            refresh();
        }
    }

    private void addGearBox(){
        if (
                textField1.getText().length()>1
                        &&textField2.getText().length()>1
                        &&textField3.getText().length()>1
                        &&textField4.getText().length()>1
        ){
            CarConfigurationService.addGearBox(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText());
            refresh();
        }
    }





}
