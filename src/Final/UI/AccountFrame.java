package Final.UI;

import Final.DataPersist;
import Final.Logic.Bank;
import Final.Logic.BankAccount;
import Final.Logic.CheckingAccount;
import Final.Logic.StatementWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AccountFrame {
    public AccountFrame(DataPersist dataPersist, BankAccount account){
        init(dataPersist, account);
    }
    public void init(DataPersist dataPersist, BankAccount account){
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle(account.getName());

        JPanel panel = new JPanel();
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton closeButton = new JButton("Close");
        JLabel statement = new JLabel();

        StatementWriter statementWriter = new StatementWriter();
        statementWriter.writeStatement(account);
        statement.setText(statementWriter.getCurrentStatement());

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        if(account.type.equals("C")){
            JButton addCCard = new JButton("Add credit card");
            JButton addDCard = new JButton("Add debit card");
            addCCard.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CheckingAccount ca = (CheckingAccount) account;
                    CCardCreationFrame cframe = new CCardCreationFrame(ca, dataPersist, frame);
                }
            });

            addDCard.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CheckingAccount ca = (CheckingAccount) account;
                    DCardCreationFrame dFrame = new DCardCreationFrame(ca, dataPersist, frame);
                }
            });
            buttonPanel.add(addCCard);
            buttonPanel.add(addDCard);
        }

        panel.add(statement);
        frame.add(buttonPanel, BorderLayout.EAST);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(closeButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
