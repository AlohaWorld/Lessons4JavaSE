package unit09.quiz;

/**
 * 完成的实例
 * 
 * 将服务器程序搞糟为多线程程序；
 * 每一个客户端连接，都有一个独立线程服务；
 * 每个客户端都可以在一个连接中多次发送半径请求
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo09P4S {

  public static void main(String[] args) {
    // Create thread pool with ExecutorService and Executors

    // Create a server socket, using try-with-resource
    try (ServerSocket serverSocket = new ServerSocket(8000)) {
      System.out.println("Server started at port 8000");

      while (true) {
        // Listen for a connection request
        Socket socket = serverSocket.accept();

        // Create a thread with executor

      }
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      System.out.println("Server socket closed");
    }

    // shutdown executor

    System.out.println("Server terminated");
  } // end main

  // Create a ServerThread (of Runnable)
  static class ServerThread implements Runnable {

    // 保留socket存根，便于在run函数中使用

    // 构造函数


    @Override
    public void run() {
      try {
        // Create data input and output streams
        
        double radius;
        // Receive radius from the client
        // while
          // Compute area
          
          // Send area back to the client
                    
          System.out.println("Thread " + this.hashCode() + "\tRadius from client: " + radius);
          System.out.println("Thread " + this.hashCode() + "\tArea is: " + area);
        } // end while
      }catch(

    IOException e)
    {
      e.printStackTrace();
    }finally
    {
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
