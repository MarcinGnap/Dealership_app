package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Accept extends JFrame{
    private JButton acceptButton;
    private JPanel Accept;
    private JButton rejectButton;
    public Accept(){
        setSize(720,720);
        setTitle("Available Cars");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        rejectButtonListener();
        acceptButtonListener();
        this.setContentPane(Accept);
        this.setVisible(true);
    }

    public void rejectButtonListener(){
        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    void acceptButtonListener(){
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("dupa accepted");

                dispose();
            }
        });
    }
}
