package unit05;

import javax.swing.JOptionPane;

public class RuntimeErrorDemo {

  public static void main(String[] args) {
    try {
    String input = JOptionPane.showInputDialog(null, 
        "Please enter an integer");
    
    /*
     * The Integer class wraps a value of the primitive type int in an object. 
     * In addition, this class provides several methods for converting an int to a String and a 
     * String to an int, as well as other constants and methods useful when dealing with an int. 
     */
    int number = Integer.parseInt(input);

    
    // Display the result
    JOptionPane.showMessageDialog(null, "The number entered is " + number);;
    }
    catch (Exception ex) {
      System.out.println("Catched!");
    }
    System.exit(0);
  }
}
