package Final.UI;

import Final.DataPersist;
import Final.Logic.CCard;
import Final.Logic.Card;
import Final.Logic.DCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AllCardsFrame {
    public AllCardsFrame(JFrame previous, DataPersist dataPersist){
        init(previous, dataPersist);
    }
    public void init(JFrame previous, DataPersist dataPersist){
        previous.dispose();
        JFrame frame = new JFrame();
        frame.setTitle("All Cards");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(1000,1000));

        JPanel cardPanel = new JPanel();
        JButton closeButton = new JButton("Close");

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        for(JButton button : createCardButtons(dataPersist)){
            cardPanel.add(button);
        }

        JLabel warningLabel = new JLabel("Cards can only be used here, not created");

        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(warningLabel, BorderLayout.NORTH);
        frame.add(closeButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    private ArrayList<JButton> createCardButtons(DataPersist dataPersist){
        ArrayList<JButton> output = new ArrayList<>();
        for(CCard card : dataPersist.getcCardHashSet()){
            JButton button = new JButton(card.getName());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardFrame cardFrame = new CardFrame(card, dataPersist);
                }
            });
            output.add(button);
        }
        for(DCard card : dataPersist.getdCardHashSet()){
            JButton button = new JButton(card.getName());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardFrame cardFrame = new CardFrame(card, dataPersist);
                }
            });
            output.add(button);
        }
        return output;
    }
}
