package unit09.complete;

/**
 * 完成的实例
 * 
 * 这是服务器程序。
 * 
 * 客户端连接后，不断接收客户端发来的半径并返回面积；
 * 当客户端发来负数时退出
 */

import java.io.*;
import java.net.*;

public class Demo09P2S {

  public static void main(String[] args) {
    ServerSocket server = null;
    Socket socket = null;
    try { // 此处可以改为 try-with-resource 形式，避免使用finally语句关闭资源
      // 创建一个ServerSocket对象，指定监听端口，与客户端程序保持一致
      server = new ServerSocket(8000);
      System.out.println("Listening on port 8888");
      // 监听并等待接受连接：accept
      socket = server.accept();
      System.out.println("Client connected");

      // 创建 Data Input/Output 流
      var in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      // 从客户端接收圆的半径（通过DataInput流读取）
      double r;
      while ((r = in.readDouble()) > 0) {
        // 计算圆面积
        var area = r * r * Math.PI;
        // 把面积发回给客户端
        out.writeDouble(area);
        // 输出提示信息
        System.out.println("\tRadius is : " + r);
        System.out.println("\tArea   is : " + area);
      } // end while
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      try {
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        server.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("Server closed");
    }
  }
}
