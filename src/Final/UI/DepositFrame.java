package Final.UI;

import Final.DataPersist;
import Final.Logic.BankAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositFrame {
    public DepositFrame(BankAccount account, DataPersist dataPersist){
        init(account, dataPersist);
    }
    public void init(BankAccount account, DataPersist dataPersist){
        JFrame frame = new JFrame();
        frame.setTitle("Deposit");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(500,500);

        JPanel panel = new JPanel(new GridLayout(0,1,0,1));
        JLabel label = new JLabel("Enter deposit amount below");
        JTextField depositField = new JTextField();
        depositField.setEditable(true);
        JButton depositButton = new JButton("Deposit");
        JButton cancelButton = new JButton("Cancel");

        panel.add(label);
        panel.add(depositField);
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                account.deposit(Integer.parseInt(depositField.getText()));
                dataPersist.updateDatabase();
                dataPersist.updateSets();
                frame.dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.add(panel, BorderLayout.CENTER);
        frame.add(depositButton, BorderLayout.EAST);
        frame.add(cancelButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
