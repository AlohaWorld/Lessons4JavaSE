package unit04.swing;

import java.awt.FlowLayout;

import javax.swing.*;

public class MyFrameWithComponents {
  public static void main(String[] args) {
    JFrame frame = new JFrame("MyFrameWithComponents");

    // We set a layout for the frame
    frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

    // Add a button into the frame
    JButton jbtOK = new JButton("OK");
    frame.add(jbtOK);

    frame.add(new JButton("Close")); // equivalent to
                                     // frame.getContentPane().add()

    // equivalent to frame.getContentPane().add()
    frame.getContentPane().add(new JButton("Cancel"));

    frame.setSize(400, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // New since JDK 1.4, put the window to
                                       // the center of the screen
  }
}
