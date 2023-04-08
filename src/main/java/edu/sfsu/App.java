package edu.sfsu;

import javax.swing.*;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Running..." );
        // The network object will be created on the Event Dispatching Thread.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Network network = new Network();
                network.launch();
            }
        });
    }
}