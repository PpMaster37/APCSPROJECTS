package Final.UI;

import Final.DataPersist;
import Final.Logic.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CardFrame {
    public CardFrame(Card card, DataPersist dataPersist){
        init(card, dataPersist);
    }
    public void init(Card card, DataPersist dataPersist){
        JFrame frame = new JFrame();
        frame.setTitle("Enter Pin");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(500,200));

        JPanel panel = new JPanel(new GridLayout(0,1,0,5));

        JButton enterButton = new JButton("Enter");
        JLabel label = new JLabel("Enter pin below");
        JButton cancelButton = new JButton("Cancel");
        JTextField pinField = new JTextField();
        pinField.setEditable(true);
        pinField.setSize(new Dimension(500,50));
        JLabel wrong = new JLabel();

        panel.add(label);
        panel.add(pinField);
        panel.add(wrong);
        panel.add(enterButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(cancelButton, BorderLayout.SOUTH);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int entered = Integer.parseInt(pinField.getText());
                if(card.checkPin(entered)){
                    CardFrameTwo frameTwo = new CardFrameTwo(card, entered, dataPersist);
                    frame.dispose();
                } else{
                    wrong.setText("Incorrect pin");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
