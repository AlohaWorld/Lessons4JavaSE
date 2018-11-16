package dt05;

import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOTest {

  public static void main(String[] args) throws Exception {
    // 用Scanner从键盘读入信息
    Scanner input = new Scanner(System.in);
    PrintWriter output = new PrintWriter("out.txt");
    FileOutputStream outputStream = new FileOutputStream("out.bin");
    // 创建一个带缓冲的文件输出流，取代原来的文件输出流
    //BufferedOutputStream outputStream= new BufferedOutputStream(
    //    new FileOutputStream("out.bin"));
    String temp;
    while(input.hasNext()) {
      temp = input.next();
      temp = input.
      if (temp.equals(new String("exit")))
        break;
      // 将信息显示到屏幕上
      System.out.print(temp);
      // 同时将信息写入到out.txt文件中（PrintWriter）
      output.print(temp);
      
      // 将信息以二进制形式写入到 out.bin 文件中
      outputStream.write(temp.getBytes());
    }

    // 关闭out.txt文件（或者使用try-with语句）
    output.close();
    input.close();
    //outputStream.close();
  }
}
