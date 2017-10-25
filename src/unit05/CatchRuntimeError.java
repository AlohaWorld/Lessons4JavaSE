package unit05;

import javax.swing.JOptionPane;

public class CatchRuntimeError 
{
  public static void main(String[] args) 
  {
    try 
    {
      String input = JOptionPane.showInputDialog(null,
        "Please enter an integer");
      int number = Integer.parseInt(input);

      // Display the result
      JOptionPane.showMessageDialog(null,
        "The number entered is " + number);
    } 
    catch (Exception ex) 
    {
      JOptionPane.showMessageDialog(null,
        "Incorrect input: an integer is required");
    }

    System.out.println("Execution continues ...");
    System.exit(0);
  }
}

