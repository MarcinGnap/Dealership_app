package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvailableCarsWorker extends JFrame{
    private JScrollPane listas;
    private JButton returnButton;
    private JComboBox listMode;
    private JTextField paramText1;
    private JLabel param1;
    private JLabel param2;
    private JLabel param3;
    private JLabel param4;
    private JLabel param5;
    private JLabel param6;
    private JLabel param7;
    private JLabel param8;
    private JLabel param9;
    private JTextField paramText2;
    private JTextField paramText3;
    private JTextField paramText4;
    private JTextField paramText5;
    private JTextField paramText6;
    private JTextField paramText7;
    private JTextField paramText8;
    private JTextField paramText9;
    private JButton addButton;
    private JPanel availableCarsWorker;

    public AvailableCarsWorker(){
        setSize(500,500);
        setTitle("Editing Available Cars");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(availableCarsWorker);
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
}
