package unit09;
/** 
 * 现场编程 
 * 
 * 这是客户端程序，执行时连接到服务器程序，发送圆的半径，
 * 然后接收服务器返回的面积，随后结束
 */

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Demo09P1C {

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
      
      // 提示并从键盘读入一个浮点数作为圆的半径
      System.out.println("Please input radius : ");
      scanner = new Scanner(System.in);
      var r = scanner.nextDouble();

      // 将半径发送给服务器，并且提示
      out.writeDouble(r);
      System.out.println("Sent r : " + r);

      // 从服务器读取圆面积，并且显示
      var area = in.readDouble();
      System.out.println("Area is : " + area);
    } 
    catch (IOException ex) {
      System.out.println(ex.toString());
    } 
    finally {
      // close socket connection
      try {
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      scanner.close();
    }
  }
} // end main
