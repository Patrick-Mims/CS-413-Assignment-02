/*
*  Name: Patrick Mims
*  Date: 04.19.23
*  CSC413: Erwin
*  Assignment 2
*  Notes: The program works according to the spec.
*
*  Changes: The confirmation in step 10, I used a dialog box to alert the
*  user the information has been entered.
* */
package edu.sfsu;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Network {
    public GridBagConstraints c; // GridBagConstraints class is used for layout.
    public Set<String> data;
    public int cnt;
    public Network() {
        c = new GridBagConstraints();
        data = new LinkedHashSet<>(); // The LinkedHashSet<>() is used only for checking if a value has or hasn't been added
    }

    void insertRecord(ArrayList<String> items) throws IOException {
        // Test the program by first ensuring the containerInformation.csv file is empty or does not exist.
        try {
            File file = new File("containerInformation.csv");

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            if(!file.exists()) {
                file.createNewFile();
            }
            // Add a header to the file once
            if(file.length() == 0) {
                pw.print("ID, Weight, Sender, Receiver, Description");
            }

            pw.println("");

            for (String item : items) {
                pw.print(item + ", ");
            }

            pw.close();
            System.out.println("Data Added"); // for testing purposes
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        cnt++; // increment the count value
    }

    void createUI() {
        // Instantiate frame and panel objects and initialize size and layout
        JFrame frame = new JFrame("Inventory");
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        panel.setLayout(new GridBagLayout());

        // create the form. It's verbose but it will do for this assignment
        JLabel label = new JLabel("Inventory Record Count: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 0;
        panel.add(label, c);

        JLabel count = new JLabel(" " + cnt);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 0;
        panel.add(count, c);

        /* First */
        JLabel id = new JLabel("ID ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(id, c);

        JTextField textField1 = new JTextField(5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 1;
        panel.add(textField1, c);

        /* Second */
        JLabel weight = new JLabel("Weight (kg)");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(weight, c);

        JTextField textField2 = new JTextField(5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 2;
        panel.add(textField2, c);

        /* Third */
        JLabel sender = new JLabel("Name of Sender");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 3;
        panel.add(sender, c);

        JTextField textField3 = new JTextField(5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 3;
        panel.add(textField3, c);

        /* Fourth */
        JLabel receiver = new JLabel("Name of Receiver");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 4;
        panel.add(receiver, c);

        JTextField textField4 = new JTextField(5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 4;
        panel.add(textField4, c);

        /* Fifth */
        JLabel description = new JLabel("Description of contents");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 5;
        panel.add(description, c);

        JTextField textField5 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 5;
        panel.add(textField5, c);

        /* Submit Button */
        JButton submitButton = new JButton("Save");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 6;
        // submitButton uses the action listener to call the insertRecord() method
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // If any field is left blank, an error raised and the record won't be entered
                if(textField1.getText().equals("") || textField2.getText().equals("") || textField3.getText().equals("") || textField4.getText().equals("") || textField5.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Error: Incomplete.");
                } else {
                    // Define the ArrayList here so each entry is a fresh set of data
                    ArrayList<String> formData = new ArrayList<>();
                    JOptionPane.showMessageDialog(frame, "New Record Added.");
                    // check if data contains the id, simple console output
                    if(data.contains(textField1.getText())) {
                        // Notify the user that a record already exists.
                        JOptionPane.showMessageDialog(frame, "A record with this ID already exists.");
                    } else {
                        data.add(textField1.getText()); // if the record doesn't exist, then add it the set
                        formData.add(textField1.getText());
                        formData.add(textField2.getText());
                        formData.add(textField3.getText());
                        formData.add(textField4.getText());
                        formData.add(textField5.getText());
                    } // call insertRecord to input the data
                    try {
                        insertRecord(formData);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } // clear the form only when a complete record is submitted.
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");
                    textField5.setText("");
                }
            }
        });

        panel.add(submitButton, c);
        frame.add(panel);
        frame.setVisible(true);
    }
}