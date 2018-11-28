package unit09;

/**
 * 现场编程
 * 
 * 这是服务器程序，接收客户端发来的半径，返回圆面积，随后退出
 */

import java.io.*;
import java.net.*;

public class Demo09P1S {

  public static void main(String[] args) {
    try { // 此处可以改为 try-with-resource 形式，避免使用finally语句关闭资源
      // 创建一个ServerSocket对象，指定监听端口，与客户端程序保持一致
      var server = new ServerSocket(8000);
      System.out.println("Listening on port 8000");
      // 监听并等待接受连接：accept
      var socket = server.accept();
      System.out.println("Client connected");

      // 创建 Data Input/Output 流
      var in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      // 从客户端接收圆的半径（通过DataInput流读取）
      double r = in.readDouble();
      // 计算圆面积
      var area = r * r * Math.PI;
      // 把面积发回给客户端
      out.writeDouble(area);
      // 输出提示信息
      System.out.println("\tRadius is : " + r);
      System.out.println("\tArea   is : " + area);
      
      socket.close();
      System.out.println("Server closed");
    }
    catch(IOException ex) {
      ex.printStackTrace();
    }
  }
}
