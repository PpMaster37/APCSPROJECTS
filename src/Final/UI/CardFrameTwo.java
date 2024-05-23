package Final.UI;

import Final.DataPersist;
import Final.Logic.CCard;
import Final.Logic.Card;
import Final.Logic.DCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardFrameTwo {
    public CardFrameTwo(Card card, int pin, DataPersist dataPersist){
        init(card, pin, dataPersist);
    }
    public void init(Card card, int pin, DataPersist dataPersist){
        JFrame frame = new JFrame();
        frame.setTitle("Card");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(500,500));

        JPanel panel = new JPanel(new GridLayout(0,1,0,1));

        JLabel nameLabel = new JLabel(card.getName());
        JLabel label = new JLabel("Enter withdraw amount below");
        JTextField moneyField = new JTextField();
        moneyField.setEditable(true);
        JButton useButton = new JButton("Use");
        JButton closeButton = new JButton("Close");
        JButton cancelCardButton = new JButton("Cancel Card");

        useButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.use(Integer.parseInt(moneyField.getText()),pin);
                dataPersist.updateDatabase();
                dataPersist.updateSets();
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        cancelCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(card.getType().equals("C")){
                    dataPersist.removeFromCCards(card);
                    dataPersist.updateDatabase();
                    dataPersist.updateSets();
                } else if(card.getType().equals("D")){
                    dataPersist.removeFromdCard(card);
                    dataPersist.updateDatabase();
                    dataPersist.updateSets();
                }
                frame.dispose();
            }
        });

        panel.add(nameLabel);
        panel.add(label);
        panel.add(moneyField);
        panel.add(useButton);

        if(card.getType().equals("C")){
            JButton repayButton = new JButton("Repay");
            JLabel repayLabel = new JLabel("Enter repay amount");
            JTextField repayField = new JTextField();
            repayField.setEditable(true);
            panel.add(repayLabel);
            panel.add(repayField);
            panel.add(repayButton, BorderLayout.SOUTH);
            repayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CCard Ccard = (CCard) card;
                    Ccard.repay(Integer.parseInt(repayField.getText()));
                    dataPersist.updateDatabase();
                    dataPersist.updateSets();
                    frame.dispose();
                }
            });
        } else if (card.getType().equals("D")){
            JButton depositButton = new JButton("Deposit");
            JLabel depositAmount = new JLabel("Enter deposit amount");
            JTextField depField = new JTextField();
            depField.setEditable(true);
            panel.add(depositAmount);
            panel.add(depField);
            frame.add(depositButton, BorderLayout.SOUTH);
            depositButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DCard Dcard = (DCard) card;
                    Dcard.deposit(Integer.parseInt(depField.getText()), pin);
                    dataPersist.updateDatabase();
                    dataPersist.updateSets();
                    frame.dispose();
                }
            });
        }

        frame.add(panel,BorderLayout.CENTER);
        frame.add(cancelCardButton, BorderLayout.EAST);
        frame.add(closeButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
