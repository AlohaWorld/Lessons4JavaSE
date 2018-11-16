package dt08;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// 1. 从键盘上输入信息
// 2. 将信息以文本形式存入文件
// 3. 直到用户输入 exit
public class Chat2File {

  public static void main(String[] args) throws IOException {
    // 创建一个Scanner对象
    Scanner sc = new Scanner(System.in);
    
    // 创建一个文本文件流对象
    FileWriter out = new FileWriter("chat.txt");
    
    String line;
    // 开始循环
    while((line = sc.nextLine()) != null) {
      //读入一行文本
      //判断文本内容是否是 exit
      if (line.compareTo("exit") != 0) { //不是
          //将文本写入到文件中
        out.write(line+"\n");
      } else { //否则
          //跳出循环
        break;
      }
    }   // end while(
    // 关闭文件流
    out.close();
    sc.close();
  }

}
