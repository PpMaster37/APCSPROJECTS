package Final.UI;

import Final.DataPersist;
import Final.Logic.Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllBanksFrame {
    public AllBanksFrame(JFrame previous, DataPersist dataPersist){
        init(previous, dataPersist);
    }
    public void init(JFrame previous, DataPersist dataPersist){
        previous.dispose();
        JFrame frame = new JFrame();
        frame.setTitle("All Banks");
        frame.setSize(1000,500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel bankPanel = new JPanel();

        JButton addButton = new JButton("New Bank");
        JButton closeButton = new JButton("Close");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankCreationFrame bankCreationFrame = new BankCreationFrame(frame, dataPersist);
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        for(Bank bank: dataPersist.getBankHashSet()){
            bankPanel.add(bankToButton(bank, dataPersist));
        }
        frame.add(bankPanel, BorderLayout.CENTER);
        frame.add(addButton, BorderLayout.EAST);
        frame.add(closeButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    public JButton bankToButton(Bank bank, DataPersist dataPersist){
        JButton button = new JButton(bank.getName());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankFrame bankFrame = new BankFrame(dataPersist, bank);
            }
        });
        button.setToolTipText("Click for more bank info");
        return button;
    }
}
