package unit09.complete;
//这是服务器程序
//这是编好的实例
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Demo09P1S {

  public static void main(String[] args) {

    // 创建一个 server socket，使用 try-with-resource
    try (ServerSocket serverSocket = new ServerSocket(8000)) {
      System.out.println("Server listening on 8000");
      
      // 监听并等待接受连接：使用ServerSocket对象的accept()
      Socket socket = serverSocket.accept();
      System.out.println("Client connected");
      
      // 创建 Data Input/Output 流
      DataInputStream inputFromClient = new DataInputStream(
        socket.getInputStream());
      DataOutputStream outputToClient = new DataOutputStream(
        socket.getOutputStream());

      // Task1：首先让服务器能够接受客户端发来的单个半径并返回面积
      // Task2：在Task1的基础上修改代码，加入while循环，使得服务器可以不断
      //        接收半径、计算面积并将面积发回给客户端
      double radius;
      while ( (radius = inputFromClient.readDouble()) > 0) {
        // 从客户端接收圆的半径（通过DataInput流读取）
         // 计算圆面积
        double area = radius * radius * Math.PI;
        // 把面积发回给客户端
        outputToClient.writeDouble(area);
        // 输出提示信息
        System.out.println("Radius received from client: " + radius);
        System.out.println("Area is: " + area); 
      }
    } catch(SocketException ex1) {
      System.out.println("Socket disconnected");
    } catch(IOException ex2) {
      ex2.printStackTrace();
    }
  } // end main
}
