package unit04;

import java.awt.*;
import javax.swing.*;

public class DisplayClock extends JFrame {
  public DisplayClock() {
    // Create an analog clock for the current time
    StillClock clock = new StillClock();

    // Display hour, minute, and seconds in the message panel
    MessagePanel messagePanel = new MessagePanel(clock.getHour() +
      ":" + clock.getMinute() + ":" + clock.getSecond());
    messagePanel.setCentered(true);
    messagePanel.setForeground(Color.blue);
    messagePanel.setFont(new Font("Courie", Font.BOLD, 16));

    // Add the clock and message panel to the frame
    // The default content pane will have a BorderLayout manager set on it. 
    // https://docs.oracle.com/javase/1.5.0/docs/api/javax/swing/JFrame.html
    add(clock);
    add(messagePanel, BorderLayout.SOUTH);
  }

  public static void main(String[] args) {
    DisplayClock frame = new DisplayClock();
    frame.setTitle("DisplayClock");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 350);
    frame.setVisible(true);
  }
}
