package unit09;

/**
 * 完成的实例
 * 
 * 将服务器程序改写为多线程程序；
 * 每一个客户端连接，都有一个独立线程服务；
 * 每个客户端都可以在一个连接中多次发送半径请求
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo09P4S2 {

  public static void main(String[] args) {
    // Create thread pool with ExecutorService and Executors
    ExecutorService executor = Executors.newCachedThreadPool();
    // Create a server socket, using try-with-resource
    try (ServerSocket serverSocket = new ServerSocket(8000)) {
      System.out.println("Server started at port 8000");

      while (true) {
        // Listen for a connection request
        Socket socket = serverSocket.accept();

        // Create a thread with executor
        executor.execute(new Demo09P4S2.ServerThread(socket));
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      System.out.println("Server socket closed");
    }

    executor.shutdown();
    System.out.println("Server terminated");
  } // end main

  // Create a ServerThread (of Runnable)
  static class ServerThread implements Runnable {

    // 保留socket存根，便于在run函数中使用
    private Socket socket = null;

    // 构造函数
    public ServerThread(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try {
        // Create data input and output streams
        var in = new DataInputStream(socket.getInputStream());
        var out = new ObjectOutputStream(socket.getOutputStream());

        double radius;
        // Receive radius from the client
        while ((radius = in.readDouble()) > 0) {
          // Construct a circle object
          var c = new Circle(radius, "Blue");

          // Send the Circle object to the client
          out.writeObject(c);

          System.out.println("Thread " + this.hashCode() + "\tRadius from client: " + radius);
          System.out.println("Thread " + this.hashCode() + "\tCircle is: \n" + c.toString());
        } // end while
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          System.out.println("Thread " + this.hashCode() + " finished");
        }
      }
    } // end run()
  } // end ServerThread
}


/**
 * 自定义一个圆类，重载toString函数
 * @author cyd
 *
 */
class Circle implements Serializable {
  static final long serialVersionUID = 1234554321L;
  private double radius;
  private String color;

  public Circle(double r, String c) {
    radius = r;
    color = c;
  }

  @Override
  public String toString() {
    return ("Circle " + this.hashCode() + "\n\tRadius : " + radius + "\n\tArea   : "
        + radius * radius * Math.PI + "\n\tColor  : " + color);
  }
}
