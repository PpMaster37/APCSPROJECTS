package Final.UI;

import Final.DataPersist;
import Final.Logic.CheckingAccount;
import Final.Logic.DCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DCardCreationFrame {
    public DCardCreationFrame(CheckingAccount account, DataPersist dataPersist, JFrame prev){
        init(account, dataPersist, prev);
    }
    public void init(CheckingAccount account, DataPersist dataPersist, JFrame prev){
        JFrame frame = new JFrame();
        frame.setTitle("Create Debit Card");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(500,500);

        JPanel panel = new JPanel(new GridLayout(0,1,0,1));
        JPanel bPanel = new JPanel(new FlowLayout());
        JLabel pinLabel = new JLabel("Enter new pin below");
        JLabel saveStatus = new JLabel("");
        JTextField pinField = new JTextField();
        JButton saveButton = new JButton("Save");
        JButton closeButton = new JButton("Close");

        panel.add(pinLabel);
        panel.add(pinField);
        pinField.setEditable(true);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pin = Integer.parseInt(pinField.getText());
                DCard card = new DCard(account);
                card.changePin(1111,pin);
                saveStatus.setText("New pin saved");
                dataPersist.addToDCards(card);
                dataPersist.updateDatabase();
                dataPersist.updateSets();
                frame.dispose();
                AccountFrame accountFrame = new AccountFrame(dataPersist, account);
                prev.dispose();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        bPanel.add(closeButton);
        bPanel.add(saveButton);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(bPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
