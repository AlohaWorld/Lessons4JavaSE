package unit09.quiz;

/**
 * 编好的实例
 * 
 * 将服务器改造为能够接受客户端多次连接；
 * 每次连接只提供一次面积计算服务
 * 
 * 观察：一次连接发送多个半径的客户端（Demo09P2C）会如何导致程序停止
 */
import java.io.IOException;
import java.net.ServerSocket;

public class Demo09P3S {

  public static void main(String[] args) {
    // Task1. 完成 try-catch-finally 模式
    // Task2. 将try改造为 try-with-resource
    // Task3. 将服务器改造为支持客户端多次连接
    // Create a server socket
    try (ServerSocket serverSocket = new ServerSocket(8000)) {

      // 多次循环
      // Listen for a connection request，创建一个socket


      // Create data input and output streams


      // Receive radius from the client
      double radius = inputFromClient.readDouble();

      // Compute area
      double area = radius * radius * Math.PI;

      // Send area back to the client

      System.out.println("Radius received from client: " + radius);
      System.out.println("Area is: " + area);

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
