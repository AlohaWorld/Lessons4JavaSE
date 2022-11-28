package unit09.complete;
/**
 * 完成的实例
 * 
 * 这是客户端程序。
 * 
 * 连接到服务器之后，不断从键盘获取半径并发送给服务器，从服务器获取圆面积并显示
 * 输入负数时退出
 */

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Demo09P2C {

  public static void main(String[] args) {
    Socket socket = null;
    Scanner scanner = null;
    try {
      // 创建一个Socket对象，连接到服务器（IP地址，端口号）
      socket = new Socket("localhost", 8000);
      // 创建一个Data Stream输入流对象，从服务器读取数据
      var in = new DataInputStream(socket.getInputStream());
      // 创建一个Data Stream输出流对象，向服务器发送数据
      var out = new DataOutputStream(socket.getOutputStream());

      double r = 1;

      // 加入while循环，使得客户端可以不断给服务器发送半径并从服务器获取面积
      while (r > 0) {
        // 提示并从键盘读入一个浮点数作为圆的半径
        System.out.println("Please input radius : ");
        scanner = new Scanner(System.in);
        r = scanner.nextDouble();

        // 将半径发送给服务器，并且提示
        out.writeDouble(r);
        System.out.println("Sent r : " + r);

        // 从服务器读取圆面积，并且显示
        var area = in.readDouble();
        System.out.println("Area is : " + area);
      }
    } catch (IOException ex) {
      System.out.println(ex.toString());
    } finally {
      scanner.close();
      // close socket connection
      try {
        socket.close();
      } catch (IOException e) {
      } finally {
        System.out.println("Client disconnected");
      }
    }
  }
}
