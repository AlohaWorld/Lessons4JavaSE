/**
 * This file shows a reasonable class structure.
 * We seperate 
 */
package unit04.separate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author cyd
 *
 */
public class TestMultipleListenerSeparate {
    /** Main method */
    public static void main(String[] args) {
        TestMultipleListener frame = new TestMultipleListener();
        frame.setTitle("TestMultipleListener");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 80);
        frame.setVisible(true);
    }

}

// class TestMultipleListener extends JFrame implements ActionListener {
@SuppressWarnings("serial")
class TestMultipleListener extends JFrame {
    private JButton jbtOk = new JButton("OK");
    private JButton jbtCancel = new JButton("Cancel");

    public TestMultipleListener() {
        setLayout(new FlowLayout());

        add(jbtOk);
        add(jbtCancel);

        // Register the frame as listeners
        /*
        jbtOk.addActionListener(this);
        jbtCancel.addActionListener(this);
        */
        FirstListener firstListener = new FirstListener();
        jbtOk.addActionListener(firstListener);
        jbtCancel.addActionListener(firstListener);
        
        
        // Register a second listener for buttons
        SecondListener secondListener = new SecondListener();
        jbtOk.addActionListener(secondListener);
        jbtCancel.addActionListener(secondListener);
    }

    // The main() method is moved to class TestMultipleListenerSeparate
    /** Main method */
    /*
    public static void main(String[] args) {
        TestMultipleListener frame = new TestMultipleListener();
        frame.setTitle("TestMultipleListener");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 80);
        frame.setVisible(true);
    }
    */

    //  The following method has been moveded to class FirstListener
    /** This method will be invoked when a button is clicked */
    /*
    public void actionPerformed(ActionEvent e) {
        System.out.print("First listener: ");

        if (e.getSource() == jbtOk) {
            System.out.println("The OK button is clicked");
        } else if (e.getSource() == jbtCancel) {
            System.out.println("The Cancel button is clicked");
        }
    }
    */
}

/** The class for the first listener */
class FirstListener implements ActionListener {

    /** This method will be invoked when a button is clicked */
    // The following method is moved from class TestMultipleListener
    public void actionPerformed(ActionEvent e) {
        System.out.print("Separate First listener: ");

//          if (e.getSource() == jbtOk) {
            if (e.getActionCommand().equals("OK")) {
//              System.out.println("The OK button is clicked");                
                System.out.println("The OK button is clicked");                
//          } else if (e.getSource() == jbtCancel) {
            } else if (e.getActionCommand().equals("Cancel")) {
//              System.out.println("The Cancel button is clicked");
                System.out.println("The Cancel button is clicked");
        }
    }
}

/** The class for the second listener */
class SecondListener implements ActionListener {
    /** Handle ActionEvent */
    public void actionPerformed(ActionEvent e) {
        System.out.print("Second listener: ");

        // A button has an actionCommand property, which is same as the
        // text of the button by default.
        if (e.getActionCommand().equals("OK")) {
            System.out.println("The OK button is clicked");
        } else if (e.getActionCommand().equals("Cancel")) {
            System.out.println("The Cancel button is clicked");
        }
    }
}
