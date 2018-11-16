/**
 * 
 */
package unit02;
import java.util.Date;
import javax.swing.JFrame;

public class DemoP22 {
  

  /** Task 1
   * Demos about Date()
   *   1. import which package?
   *   2. create a Date object
   *   3. print a date
   */
  
  /** Task 2
   * Demos about JFrame
   *   1. import which package?
   *   2. create a JFrame object
   *   3. setTitle/setSize/setLocation/setVisible 
   */
  public static void main(String[] args) {
      Date dt = new Date();
      System.out.println(dt);
      JFrame frame = new JFrame();
      frame.setTitle("HELLO");
      frame.setSize(400, 100);
      frame.setLocation(1000, 100);
      frame.setVisible(true);

  }

}
