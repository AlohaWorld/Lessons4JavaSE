package unit04.section08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import unit04.MessagePanel;

public class RadioButtonDemo extends CheckBoxDemo {
  // Declare radio buttons
  private JRadioButton jrbRed, jrbGreen, jrbBlue;

  public static void main(String[] args) {
    RadioButtonDemo frame = new RadioButtonDemo();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("RadioButtonDemo");
    frame.setSize(500, 200);
    frame.setVisible(true);
  }

  public RadioButtonDemo() {    // ctor
    // Create a new panel to hold check boxes
    JPanel jpRadioButtons = new JPanel();
    jpRadioButtons.setLayout(new GridLayout(3, 1)); // 3 rows, 1 col
    
    // Add 3 Radio Buttons
    jpRadioButtons.add(jrbRed = new JRadioButton("Red"));
    jpRadioButtons.add(jrbGreen = new JRadioButton("Green"));
    jpRadioButtons.add(jrbBlue = new JRadioButton("Blue"));
    
    // Add Panel "jpRadioButtons" to the Frame; Put it left
    add(jpRadioButtons, BorderLayout.WEST);

    // Create a radio button group to group three buttons
    ButtonGroup group = new ButtonGroup();
    group.add(jrbRed);
    group.add(jrbGreen);
    group.add(jrbBlue);

    // Set keyboard mnemonics
    jrbRed.setMnemonic('E');
    jrbGreen.setMnemonic('G');
    jrbBlue.setMnemonic('U');

    // Respond to User actions
    // Register listeners for check boxes
    jrbRed.addActionListener(
            new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        messagePanel.setForeground(Color.red);
                    }
                }
            );  // END addActionListener
    jrbGreen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        messagePanel.setForeground(Color.green);
      }
    });
    jrbBlue.addActionListener(
            // Here we don't use 
            new blueActionListener(messagePanel)
//            new ActionListener() {
//      public void actionPerformed(ActionEvent e) {
//        messagePanel.setForeground(Color.blue);
//      }
//    }
            );

    // Set initial message color to blue
    jrbBlue.setSelected(true);
    messagePanel.setForeground(Color.blue);
  }
}
/* 
 * This block is to demonstrate non-inline object creation
 */
class blueActionListener implements ActionListener {
    private MessagePanel messagePanel_;
    public void actionPerformed(ActionEvent e) {
        messagePanel_.setForeground(Color.blue);
    }
    public blueActionListener(MessagePanel messagePanel) {  // ctor
        messagePanel_ = messagePanel;
    }
}
/*
 */