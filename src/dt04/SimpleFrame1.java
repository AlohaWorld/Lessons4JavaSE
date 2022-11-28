package dt04;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// 创建一个窗口，在窗口中显示“Hello, World!”
/* Method 1, Steps:
 * 1. Create a frame
 * 2. Call showMessageDialog() */
/* Method 2, Steps:
 * 1. Create a frame
 * 2. Create a JLabel in the frame
 * 3. Set the text of JLabel object to "Hello, World!" */

public class SimpleFrame1 {
  public static void main(String[] args) {
    /* Method 1
    JOptionPane.showMessageDialog( null, 
        "Hello, World!",
        "Simple Frame Example 1",    
        JOptionPane.INFORMATION_MESSAGE );
    
    */
    // Method 2
    JFrame frame = new JFrame("Simeple Frame Example 1");
    frame.getContentPane().add(new JLabel("Hello, World!"));

    frame.setSize(400, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);

  }

}
