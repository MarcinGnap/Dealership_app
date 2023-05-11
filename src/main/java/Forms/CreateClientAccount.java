package Forms;

import Interfaces.PersonType;
import Services.DateService;
import Services.PersonService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateClientAccount extends JFrame{
    private JButton returnButton;
    private JButton proccedButton;
    private JTextField first_name_text;
    private JTextField last_name_text;
    private JTextField birth_date_text;
    private JTextField pesel_text;
    private JTextField postal_code_text;
    private JTextField city_text;
    private JTextField street_text;
    private JTextField building_number_text;
    private JPasswordField password_pass_text;
    private JPanel createClientAccount;
    private String selectedPersonType;

    public CreateClientAccount(String selectedPersonType){
        this.selectedPersonType = selectedPersonType;
        setSize(500,500);
        setTitle("Create Client Account");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(createClientAccount);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        reutrnButtonListener();
        initializeProceedButtonListener();
    }


    private void reutrnButtonListener(){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void initializeProceedButtonListener(){
        this.proccedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(
                        first_name_text.getText().length()>1
                        && last_name_text.getText().length()>1
                        && pesel_text.getText().length() == 11
                        && postal_code_text.getText().length() >1
                        && city_text.getText().length() >1
                        && street_text.getText().length() >1
                        && building_number_text.getText().length() >1
                        && password_pass_text.getText().length() >1){
                    String address = city_text.getText()+" "+street_text.getText()+" "+building_number_text.getText()+" "+postal_code_text.getText();
                    PersonService.addPerson(null, address, birth_date_text.getText(),first_name_text.getText(),last_name_text.getText(),pesel_text.getText(),password_pass_text.getText(),selectedPersonType);
                    dispose();
                }
            }
        });
    }
}
