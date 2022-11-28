package unit06.demo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Java101 {

  public static void main(String[] args) {
    java.io.File f = new File("D:\\java101.txt");
    try (var fw = new FileWriter(f); var fr = new FileReader(f)) {
      // fw = new java.io.FileWriter("D:\\java101.txt");
      // fr = new java.io.FileReader("D:\\java101.txt");

      fw.write("Java 101");
      // fw.close();
      char[] buf = new char[1024];
      fr.read(buf);
      String s = new String(buf);
      System.out.println(s);
      // fr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    /* finally {
    try {
    fw.close();
    fr.close();
    } catch (IOException e) {
    e.printStackTrace();
    }
    */
  }
}
