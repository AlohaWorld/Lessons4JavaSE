package dt04;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 创建一个窗口，在窗口中显示“Hello, World!”
/* Method 3, Steps:
 * 1. Create a class MyFrame
 * 2. Create a JLabel in MyFrame
 * 3. Set the text of JLabel object to "Hello, World!"
 * 4. In main() create an instance of MyFrame */
/* Method 4, Steps:
 * 1. Create a frame
 * 2. Add a JPanel
 * 3. Override paintComponent(Graphics g)
 * 4. Call drawString() */
public class SimpleFrame2 {
  public static void main(String[] args) {
    MyFrame myFrame = new MyFrame("Simple Frame 2");
    myFrame.setSize(400, 300);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setLocationRelativeTo(null);
    myFrame.setVisible(true);
  }
}


@SuppressWarnings("serial")
class MyFrame extends JFrame {
  public MyFrame(String title) {
    super(title);
    JPanel thePane = (JPanel) this.getContentPane();
    thePane.add(new JLabel("Hello,World!"));
  }
}
