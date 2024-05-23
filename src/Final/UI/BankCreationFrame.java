package Final.UI;

import Final.DataPersist;
import Final.Logic.Bank;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankCreationFrame {
    public BankCreationFrame(JFrame previous, DataPersist dataPersist){
        init(previous, dataPersist);
    }
    public void init(JFrame previous, DataPersist dataPersist){
        JFrame frame = new JFrame();
        frame.setTitle("Create New Bank");
        frame.setSize(1000,600);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel body = new JPanel(new GridLayout(0,1,0,1));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JTextField bankName = new JTextField();
        JTextField bankAdress = new JTextField();
        JTextField bankInterestRate = new JTextField();

        bankName.setEditable(true);
        bankAdress.setEditable(true);
        bankInterestRate.setEditable(true);

        JLabel nameL = new JLabel("Enter bank name here");
        JLabel adL = new JLabel("Enter bank adress here");
        JLabel inL = new JLabel("Enter bank interest rate here");

        body.add(nameL);
        body.add(bankName);
        body.add(adL);
        body.add(bankAdress);
        body.add(inL);
        body.add(bankInterestRate);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previous.dispose();
                String name = bankName.getText();
                String adress = bankAdress.getText();
                int iR = Integer.parseInt(bankInterestRate.getText());
                Bank bank = new Bank(iR,adress,name);
                dataPersist.addToBanks(bank);
                dataPersist.updateDatabase();
                AllBanksFrame allBanksFrame = new AllBanksFrame(frame, dataPersist);
            }
        });
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        buttonPanel.add(saveButton);
        buttonPanel.add(closeButton);
        frame.add(body, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
