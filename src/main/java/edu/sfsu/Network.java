package edu.sfsu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Network {
    // GridBagConstraints class is used for layout.
    public GridBagConstraints c;
    public ArrayList<String> data;
    public Network() {
        c = new GridBagConstraints();
        data = new ArrayList<>();
    }

    void insertRecord(ArrayList<String> items) {
        System.out.println(items);
        for(String i:items) {
            System.out.println("items: " + i);
        }
    }

    void createUI() {
        // Instantiate frame and panel objects and initialize size and layout
        JFrame frame = new JFrame("Inventory");
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        panel.setLayout(new GridBagLayout());

        // Create the form. It's verbose but it will do
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

        JTextField textField1 = new JTextField(5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 1;
        panel.add(textField1, c);

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

        // Action Listener submits the form
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "New Record Added");
                data.add(textField1.getText());
                data.add(textField2.getText());
                data.add(textField3.getText());
                data.add(textField4.getText());
                data.add(textField5.getText());
                insertRecord(data);
            }
        });
        panel.add(submitButton, c);
        frame.add(panel);
        frame.setVisible(true);
    }
}