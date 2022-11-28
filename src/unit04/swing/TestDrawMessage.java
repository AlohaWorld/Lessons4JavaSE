package unit04.swing;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestDrawMessage {

  public static void main(String[] args) {
    JFrame frame = new JFrame("Test Draw Message");
    frame.getContentPane().add(new DrawMessage1());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }

}


@SuppressWarnings("serial")
class DrawMessage1 extends JPanel {
  // /** Main method */
  // public static void main(String[] args) {
  // JFrame frame = new JFrame("DrawMessage");
  // frame.getContentPane().add(new DrawMessage());
  // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  // frame.setSize(300, 200);
  // frame.setVisible(true);
  // }

  /** Paint the message */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.drawString("Welcome to Java!", 40, 40);
  }
}
