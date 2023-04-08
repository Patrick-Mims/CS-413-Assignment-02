package edu.sfsu;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Network {
    private final JFrame jframe;
    private final JLabel label;
    private final JButton clear_button, reset_button, submit_button;
    private final JPanel panel;
    private final JTextField textFieldID;
    Network() {
        jframe = new JFrame("Inventory");
        label = new JLabel("Start Homework 1");
        panel = new JPanel();
        clear_button = new JButton("Stop");
        reset_button = new JButton("Reset");
        submit_button = new JButton("Go");
        textFieldID = new JTextField(2);
    }

    void launch() {
        Border border = BorderFactory.createTitledBorder("Assignment Two");

        jframe.setSize(400, 500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(new FlowLayout());

        panel.setBounds(40, 80, 200,200);
        panel.setBorder(border);

        clear_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Go");
            }
        });

        reset_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               label.setText("Start Homework 2");
            }
        });

        submit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Stop");
            }
        });

        panel.add(clear_button);
        panel.add(reset_button);
        panel.add(submit_button);
        panel.add(label);
        panel.add(textFieldID);
        jframe.add(panel);
        jframe.setVisible(true);
    }
}