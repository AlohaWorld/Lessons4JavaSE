package unit05;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Demo05P12 {
  public static void main(String[] args) {
    PrintWriter out = null;
    Scanner in = null;
    // JOptionPane panel = new JOptionPane();
    try {
      in = new Scanner(System.in);
      out = new PrintWriter("demo05p21.txt");
      System.out.print("Please input a line, not containing 0:");
      String s = JOptionPane.showInputDialog("Input a line");
      // String s = in.nextLine();
      assert !(s.contains("0")) : "用户输入中含有0";
      out.println(s);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      if (out != null)
        out.close();
      if (in != null)
        in.close();
      System.out.println("Program exited");
    }
  }
}
