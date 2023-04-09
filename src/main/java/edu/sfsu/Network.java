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

        jframe.setSize(350, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new GridBagLayout());
        /* * * * * * * * * * * * * * * * * * * */

        JLabel label = new JLabel("San Francisco State Inventory");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);

        /* First */
        JLabel id = new JLabel("ID ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(id, c);

        JTextField textField = new JTextField(5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 1;
        panel.add(textField, c);

        /* Second */
        JLabel weight = new JLabel("Weight");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(weight, c);

        JTextField textField2 = new JTextField(5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 2;
        panel.add(textField2, c);

        /* Third */
        JLabel sender = new JLabel("Sender");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 3;
        panel.add(sender, c);

        JTextField textField3 = new JTextField(5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 3;
        panel.add(textField3, c);

        /* Fourth */
        JLabel receiver = new JLabel("Receiver");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 4;
        panel.add(receiver, c);

        JTextField textField4 = new JTextField(5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 4;
        panel.add(textField4, c);

        /* Fifth */
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

        /* Submit Button */
        JButton submitButton = new JButton("Submit");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 6;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Gators");
            }
        });
        panel.add(submitButton, c);
        jframe.add(panel);
        jframe.setVisible(true);
    }
}