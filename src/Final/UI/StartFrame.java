package Final.UI;

import Final.DataPersist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame {
    public StartFrame(){
        DataPersist dataPersist = new DataPersist();
        init(dataPersist);
    }
    public void init(DataPersist dataPersist){
        JFrame frame = new JFrame();
        frame.setTitle("Start Page");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));

        JButton bankButton = new JButton("Banks");
        bankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllBanksFrame allBanksFrame = new AllBanksFrame(frame, dataPersist);
            }
        });

        JButton cardButton = new JButton("Cards");
        cardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllCardsFrame allCardsFrame = new AllCardsFrame(frame, dataPersist);
            }
        });

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        panel.add(bankButton);
        panel.add(cardButton);
        panel.add(closeButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
