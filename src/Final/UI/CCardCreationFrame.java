package Final.UI;

import Final.DataPersist;
import Final.Logic.Bank;
import Final.Logic.CCard;
import Final.Logic.CheckingAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CCardCreationFrame {
    public CCardCreationFrame(CheckingAccount account, DataPersist dataPersist, JFrame prev){
        init(account, dataPersist, prev);
    }
    public CCardCreationFrame(Bank bank, DataPersist dataPersist, JFrame prev){
        init(bank, dataPersist,prev);
    }
    public void init(CheckingAccount account, DataPersist dataPersist, JFrame prev){
        JFrame frame = new JFrame();
        frame.setTitle("Create Credit Card");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(500,500);

        JPanel panel = new JPanel(new GridLayout(0,1,0,1));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JLabel tierLabel = new JLabel("Enter card tier below");
        JTextField tierField = new JTextField();
        JLabel nameLabel = new JLabel("Enter name below");
        JTextField nameField = new JTextField();
        JLabel pinLabel = new JLabel("Enter new pin below");
        JTextField pinField = new JTextField();
        JButton createButton = new JButton("Save");
        JButton closeButton = new JButton("Close");

        tierField.setEditable(true);
        nameField.setEditable(true);
        pinField.setEditable(true);

        panel.add(tierLabel);
        panel.add(tierField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(pinLabel);
        panel.add(pinField);
        buttonPanel.add(createButton);
        buttonPanel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CCard card = new CCard(Integer.parseInt(tierField.getText()),
                        dataPersist.searchForBank(account.getBankName()), nameField.getName());
                card.changePin(1111, Integer.parseInt(pinField.getText()));
                dataPersist.addToCCards(card);
                dataPersist.updateDatabase();
                dataPersist.updateSets();
                frame.dispose();
                prev.dispose();
                AccountFrame ac = new AccountFrame(dataPersist, account);
            }
        });

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public void init(Bank bank, DataPersist dataPersist, JFrame prev){
        JFrame frame = new JFrame();
        frame.setTitle("Create Credit Card");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(500,500);

        JPanel panel = new JPanel(new GridLayout(0,1,0,1));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JLabel tierLabel = new JLabel("Enter card tier below");
        JTextField tierField = new JTextField();
        JLabel nameLabel = new JLabel("Enter name below");
        JTextField nameField = new JTextField();
        JLabel pinLabel = new JLabel("Enter new pin below");
        JTextField pinField = new JTextField();
        JButton createButton = new JButton("Save");
        JButton closeButton = new JButton("Close");

        tierField.setEditable(true);
        nameField.setEditable(true);
        pinField.setEditable(true);

        panel.add(tierLabel);
        panel.add(tierField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(pinLabel);
        panel.add(pinField);
        buttonPanel.add(createButton);
        buttonPanel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CCard card = new CCard(Integer.parseInt(tierField.getText()),
                       bank, nameField.getText());
                card.changePin(1111, Integer.parseInt(pinField.getText()));
                dataPersist.addToCCards(card);
                dataPersist.updateDatabase();
                dataPersist.updateSets();
                frame.dispose();
                prev.dispose();
                BankFrame bf = new BankFrame(dataPersist, bank);
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
