package edu.sfsu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Network {
    public GridBagConstraints c;
    public Network() {
        c = new GridBagConstraints();
    }
    final static boolean fill = true;
    void launch() {
        JFrame jframe = new JFrame("Inventory");
        JPanel panel = new JPanel();

        jframe.setSize(550, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new GridBagLayout());
        /* * * * * * * * * * * * * * * * * * * */

        JLabel label = new JLabel("Linked Lists");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);

        // first row
        JLabel id = new JLabel("ID ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(id, c);

        JTextField textField = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 1;
        panel.add(textField, c);

        // second row
        JLabel weight = new JLabel("Weight");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(weight, c);

        JTextField textField2 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 2;
        panel.add(textField2, c);

        // third row
        JLabel sender = new JLabel("Sender");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 3;
        panel.add(sender, c);

        JTextField textField3 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 3;
        panel.add(textField3, c);

        // fourth row
        JLabel receiver = new JLabel("Receiver");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 4;
        panel.add(receiver, c);

        JTextField textField4 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 4;
        panel.add(textField4, c);

        JLabel description = new JLabel("Description");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 5;
        panel.add(description, c);

        JTextField textField5 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 5;
        panel.add(textField5, c);

        // button
        JButton submitButton = new JButton("Submit");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 6;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Queue");
            }
        });
        panel.add(submitButton, c);
        jframe.add(panel);
        jframe.setVisible(true);
    }
}

        /*
        JButton reset_button = new JButton("Reset");
        JButton submit_button = new JButton("Go");


        JLabel label = new JLabel("Start Homework 1");
        JTextField textFieldID = new JTextField(2);

        Border border = BorderFactory.createTitledBorder("Assignment Two");

        c.fill = GridBagConstraints.HORIZONTAL;

        jframe.setSize(400, 500);
        jframe.setLayout(new GridBagLayout());

        panel.setBounds(40, 80, 200,200);
        panel.setBorder(border);

        clear_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Go");
            }
        });

        c.weightx = 0.5;

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
        */