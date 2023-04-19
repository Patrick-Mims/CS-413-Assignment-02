package edu.sfsu;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Network {
    // GridBagConstraints class is used for layout.
    public GridBagConstraints c;
    public Set<String> data;
    public Network() {
        c = new GridBagConstraints();
        data = new LinkedHashSet<>();
    }

    //public Set<String> data = new HashSet<String>();

    /**
     *
     * @param items
     * @throws IOException
     */
    void insertRecord(ArrayList<String> items) throws IOException {
    //void insertRecord(Set<String> items) throws IOException {
        System.out.println("[items] " + items);
        // Test the program by first ensuring the containerInformation.csv file is empty or does not exist.
        try {
            File file = new File("containerInformation.csv");

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            if(!file.exists()) {
                file.createNewFile();
            }

            if(file.length() == 0) {
                pw.print("ID,Weight,Sender,Receiver,Description");
            }

            pw.println("");

            for (String item : items) {
                pw.print(item + " ,");
            }

            /*
            while(it.hasNext()) {
                System.out.println(it.next() + ", ");
            }
            for(String value: items) {
                pw.print(value  + " ,");
            }
            */

            pw.close();
            System.out.println("Data Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void createUI() {
        // instantiate frame and panel objects and initialize size and layout
        JFrame frame = new JFrame("Inventory");
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        panel.setLayout(new GridBagLayout());

        // create the form. It's verbose but it will do
        JLabel label = new JLabel("SFSU Inventory App");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);

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
                if(textField1.getText().equals("") || textField2.getText().equals("") || textField3.getText().equals("") || textField4.getText().equals("") || textField5.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Error: Incomplete.");
                } else {
                    // Define the ArrayList here so each entry is a fresh set of data
                    ArrayList<String> formData = new ArrayList<>();
                    JOptionPane.showMessageDialog(frame, "New Record Added.");

                    // check if checker contains the id
                    if(data.contains(textField1.getText())) {
                        System.out.println("Record already exists");
                        System.out.println("Try again");
                    } else {
                        data.add(textField1.getText());
                        formData.add(textField1.getText());
                        formData.add(textField2.getText());
                        formData.add(textField3.getText());
                        formData.add(textField4.getText());
                        formData.add(textField5.getText());
                    }

                    try {
                        insertRecord(formData);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    // clear the form only when a complete record is submitted.
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