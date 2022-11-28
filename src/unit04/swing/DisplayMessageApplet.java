package unit04.swing;

import javax.swing.*;

public class DisplayMessageApplet extends JApplet {
  /** Initialize the applet */
  public void init() {
    // Get parameter values from the HTML file
    String message = getParameter("MESSAGE");
    int x = Integer.parseInt(getParameter("X"));
    int y = Integer.parseInt(getParameter("Y"));

    // Create a message panel
    MessagePanel messagePanel = new MessagePanel(message);
    messagePanel.setXCoordinate(x);
    messagePanel.setYCoordinate(y);

    // Add the message panel to the applet
    add(messagePanel);
  }
}
