package unit06;
// Declaring exception in the method
import java.io.*;

public class EssentialExceptions {

  public static void main(String[] args) 
      throws IOException  {
     //{  // There are checked exceptions in File I/O classes
    
    FileWriter output = new FileWriter("temp.txt");
    //output.write("Java 101");
    output.write("今天天气真好，花儿都开了");
    output.close();

    FileReader input = new FileReader("temp.txt");
    int code = input.read();
    System.out.println((char)code + " " + code);
    //System.out.println((byte)code + " " + code);

    input.close();
  }
}
