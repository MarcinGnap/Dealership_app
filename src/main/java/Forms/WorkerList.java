package Forms;

import DbModels.Worker;
import Interfaces.JobPosition;
import Interfaces.PersonType;
import Services.WorkersService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerList extends JFrame{
    private JPanel WorkerList;
    private JScrollPane workerListJPanel;
    private JButton addNewWorkerButton;
    private JButton returnButton;
    private JList list1;
    private JButton changeRoleButton;
    private JComboBox changeRoleCombo;
    private JButton refreshButton;
    DefaultListModel model = new DefaultListModel();

    public WorkerList(){
        setSize(500,500);
        setTitle("Workers List");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(WorkerList);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        list1.setModel(model);
        initializeModel();
        reutrnButtonListener();
        initializeAddNewWorker();
        initializeChangeRoleCombo();
        initializeChangeRoleButton();
        initializeRefreshButton();
    }

    private void initializeModel(){
        model.clear();
        for(Worker worker: WorkersService.getWorkers()){
            model.addElement(worker);
        }
    }

    private void initializeRefreshButton(){
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeModel();
            }
        });
    }

    private void initializeChangeRoleCombo(){
        changeRoleCombo.addItem(JobPosition.CUSTODIAN);

        changeRoleCombo.addItem(JobPosition.MENAGER);

        changeRoleCombo.addItem(JobPosition.SALESMAN);
    }

    private void initializeChangeRoleButton(){
        changeRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkersService.updateWorkerJobPosition(changeRoleCombo.getSelectedItem().toString(),((Worker)list1.getSelectedValue()).worker_id);
                initializeModel();
            }
        });
    }

    private void initializeAddNewWorker(){
        addNewWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateClientAccount(PersonType.WORKER);
            }
        });
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
