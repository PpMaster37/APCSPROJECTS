package Final.UI;

import Final.DataPersist;
import Final.Logic.Bank;
import Final.Logic.BankAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankFrame {
    public BankFrame(DataPersist dataPersist, Bank bank){
        init(dataPersist, bank);
    }
    public void init(DataPersist dataPersist, Bank bank){
        JFrame frame = new JFrame();
        frame.setTitle(bank.getName());
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(1000,500);

        JPanel accPanel = new JPanel();
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton closeButton = new JButton("Close");
        JButton createCCardButton = new JButton("Create new credit card");
        JButton createCheckAcc = new JButton("Create new checking account");
        JButton createSAcc = new JButton("Create new savings account");

        createCCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CCardCreationFrame cCardCreationFrame = new CCardCreationFrame(bank, dataPersist, frame);
            }
        });

        for(BankAccount acc:bank.getSortedAccountList()){
            accPanel.add(accToButton(acc, dataPersist, frame));
        }

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        createCheckAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CAccountCreateFrame a = new CAccountCreateFrame(dataPersist, frame, bank);
            }
        });
        createCheckAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SAccountCreateFrame a = new SAccountCreateFrame(dataPersist, frame, bank);
            }
        });

        buttonPanel.add(createCheckAcc);
        buttonPanel.add(createSAcc);
        frame.add(accPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.EAST);
        frame.add(closeButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    public JButton accToButton(BankAccount account, DataPersist dataPersist, JFrame previous){
        JButton button = new JButton(account.getName());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountFrame accountFrame = new AccountFrame(dataPersist, account);
            }
        });
        button.setToolTipText("Click for more info");
        return button;
    }
}
