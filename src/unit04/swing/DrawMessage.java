package unit04.swing;

import java.awt.Graphics;

import javax.swing.*;

@SuppressWarnings("serial")
public class DrawMessage extends JPanel {
  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new JFrame("DrawMessage");
    frame.getContentPane().add(new DrawMessage());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }

  /** Paint the message */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.drawString("Welcome to Java!", 40, 40);
  }
}
