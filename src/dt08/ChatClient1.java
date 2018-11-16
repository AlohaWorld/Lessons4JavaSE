package dt08;

import java.io.*;
import java.util.*;
import java.net.*;

public class ChatClient1 {

  public static void main(String[] args) throws IOException {
    final int port = 9001;
    Scanner sc = new Scanner(System.in);
    Socket socket = new Socket("localhost", port);
    DataOutputStream out = new DataOutputStream(
        socket.getOutputStream());
    String line;
    // 开始循环
    while((line = sc.nextLine()) != null) {
      //读入一行文本
      //判断文本内容是否是 exit
      if (line.compareTo("exit") != 0) { //不是
          //将文本写入到文件中
        out.writeUTF(line);
      } else { //否则
          //跳出循环
        break;
      }
    }   // end while(
    // 关闭流
    out.close();
    socket.close();
    sc.close();
  } // end main
}
