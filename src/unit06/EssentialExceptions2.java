package unit06;

// Using try-catch block
import java.io.*;

public class EssentialExceptions2 {

  public static void main(String[] args) {
    try {
      FileWriter output = new FileWriter("temp.txt");
      output.write("Java 101");
      output.close();

      FileReader input = new FileReader("temp.txt");
      int code = input.read();
      System.out.println((char) code);
      input.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}
