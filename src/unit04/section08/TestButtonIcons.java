package unit04.section08;

import java.awt.event.KeyEvent;

import javax.swing.*;

public class TestButtonIcons extends JFrame  {
  public static void main(String[] args) {
    // Create a frame and set its properties
    JFrame frame = new TestButtonIcons();
    frame.setTitle("ButtonIcons");
    frame.setSize(200, 100);
//    frame.setSize(400, 200);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public TestButtonIcons() {
    ImageIcon usIcon = new ImageIcon("image/us.gif");
    ImageIcon caIcon = new ImageIcon("image/ca.gif");
    ImageIcon ukIcon = new ImageIcon("image/uk.gif");
    
//    ImageIcon usIcon = new ImageIcon("image/us.gif");
//    ImageIcon caIcon = new ImageIcon("image/ca.gif");
//    ImageIcon ukIcon = new ImageIcon("image/uk.gif");


    JButton jbt = new JButton("Click it", usIcon);

    // Show Mnemonic
    jbt.setMnemonic(KeyEvent.VK_C);   // jbt.setMnemonic("C");
    // jbt.setDisplayedMnemonicIndex(3);
    
    jbt.setPressedIcon(caIcon);
    jbt.setRolloverIcon(ukIcon);

    add(jbt);
  }
}
