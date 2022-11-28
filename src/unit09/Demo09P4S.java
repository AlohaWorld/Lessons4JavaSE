package unit09;

/**
 * 现场编程
 * 
 * 将服务器程序改为多线程程序； 每一个客户端连接，都有一个独立线程服务； 每个客户端都可以在一个连接中多次发送半径请求
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo09P4S {

  public static void main(String[] args) {
    try {
      // Create thread pool with ExecutorService and Executors
      ExecutorService executor = Executors.newCachedThreadPool();
      // Create a server socket
      ServerSocket ss = new ServerSocket(8000);
      System.out.println("Server started");
      while (true) {
        // Listen for a connection request
        Socket socket = ss.accept();
        System.out.println(
            "Thread for " + socket.getInetAddress().getHostName() + " port " + socket.getPort());
        // Create a thread with executor.execute
        executor.execute(new ServerThread(socket));
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  } // end main

  // Create a ServerThread (of Runnable)
  static class ServerThread implements Runnable {
    // socket 成员
    Socket socket = null;

    // ctor，初始化socket
    ServerThread(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try {
        // 不断从客户端接收半径并返回，直到客户端发来负值
        while (true) {
          // Create data input and output streams
          var in = new DataInputStream(socket.getInputStream());
          var out = new DataOutputStream(socket.getOutputStream());

          // Receive radius from the client
          double r = in.readDouble();
          if (r < 0.0) {
            System.out.println("Read a negtive radius: " + r);
            System.out.println("Quit thread");
            break;
          }

          // Compute area
          double area = r * r * Math.PI;

          // Send area back to the client
          out.writeDouble(area);

          // Print information about circle
          System.out.println(this.hashCode() + ": Radius is: " + r);
          System.out.println(this.hashCode() + ": Area is: " + area);
        }

        socket.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    } // end run()
  } // end ServerThread
}
