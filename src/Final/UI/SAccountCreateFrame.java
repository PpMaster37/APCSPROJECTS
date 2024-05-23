package Final.UI;

import Final.DataPersist;
import Final.Logic.Bank;
import Final.Logic.BankAccount;
import Final.Logic.CheckingAccount;
import Final.Logic.SavingsAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SAccountCreateFrame {
    public SAccountCreateFrame(DataPersist dataPersist, JFrame pr, Bank bank)
    {
        init(dataPersist,pr, bank);
    }
    public void init(DataPersist dataPersist, JFrame previous, Bank bank){
        JFrame frame = new JFrame();
        frame.setTitle("Create new savings account");
        frame.setSize(1000,500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0,1,0,1));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Enter name below");
        JTextField nameField = new JTextField();
        JLabel withdrawLabel = new JLabel("Enter max withdrawals below");
        JTextField withField = new JTextField();
        nameField.setEditable(true);
        withField.setEditable(true);
        JButton saveButton = new JButton("Save");
        JButton closeButton = new JButton("Close");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = findNewAccNum(dataPersist);
                String name = nameField.getText();
                int max = Integer.parseInt(withField.getText());
                SavingsAccount account = new SavingsAccount(num,name,bank, LocalDateTime.now(), max);
                dataPersist.addToAccounts(account);
                dataPersist.updateDatabase();
                previous.dispose();
                BankFrame bankFrame = new BankFrame(dataPersist, bank);
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(withdrawLabel);
        panel.add(withField);

        buttonPanel.add(saveButton);
        buttonPanel.add(closeButton);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    private int findNewAccNum(DataPersist dataPersist){
        int out = 0;
        ArrayList<BankAccount> accounts = new ArrayList<>(dataPersist.getAccountHashSet());
        for(int i = 0; i<accounts.size();i++){
            if(accounts.get(i).getAccountNumber()==out){
                out++;
                i = 0;
            }
        }
        return out;
    }
}
