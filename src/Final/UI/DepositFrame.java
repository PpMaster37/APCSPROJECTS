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

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter deposit amount below");
        JTextField depositField = new JTextField();
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
