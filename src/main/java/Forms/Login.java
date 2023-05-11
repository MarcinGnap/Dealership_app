package Forms;

import DbModels.Person;
import Interfaces.PersonType;
import Services.DatabaseConnector;
import Services.LoginService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Login extends JFrame {
    private JButton loginButton;
    private JPasswordField passwordTextField;
    private JTextField loginTextField;
    private JButton useAsGuestButton;
    private JPanel LoginPanel;

    public Login(){
        setSize(200,200);
        setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(LoginPanel);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        loginButtonListener();
    }

    private void loginButtonListener(){
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person person = LoginService.login(loginTextField.getText(), passwordTextField.getText());
                String personType = person.person_type;
                if(personType.equals(PersonType.CLIENT)){
                    new ClientPanel(person);
                    dispose();
                }
                if(personType.equals(PersonType.WORKER)){
                    new WorkerPanel(person);
                    dispose();
                }
            }
        });
    }







}
