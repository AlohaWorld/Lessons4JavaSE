package unit06.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextIO {
  public static void main(String[] args) {
    // new File object to represent "text.txt"
    File file = new File("Text.txt");

    // new FileReader object to open "text.txt"
    FileReader fr = null;
    FileWriter fw = null;
    try {
      fr = new FileReader(file);
      fw = new FileWriter(file);
      
      // 将字符串"Hello World!"写入到file
      String s1 = "Hello World!\n Welcom to Java";
      fw.write(s1.toCharArray());
      fw.close();
      // 从file中将内容读出来
      char[] s = new char[(int) file.length()];
      fr.read(s);
      // 显式文件内容
      System.out.println(s);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch(IOException e) {
      System.out.println("IO exception");
    }finally {
      try {
        fw.close();
        fr.close();
      } catch (IOException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
      }

    }




  }

}
