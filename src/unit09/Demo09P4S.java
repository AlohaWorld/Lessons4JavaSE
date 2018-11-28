package unit09;

/**
 * 现场编程
 * 
 * 将服务器程序搞糟为多线程程序；
 * 每一个客户端连接，都有一个独立线程服务；
 * 每个客户端都可以在一个连接中多次发送半径请求
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

      // Create a server socket


      while(true) {
        // Listen for a connection request
        
        // Create a thread with executor

      }
    }
    catch(IOException ex) {
      ex.printStackTrace();
    }
  } // end main
  
  // Create a ServerThread (of Runnable)
  static class ServerThread implements Runnable {
    // socket 成员

    // ctor

    @Override
    public void run() {
      //不断从客户端接收半径并返回，直到客户端发来负值
        // Create data input and output streams


        // Receive radius from the client


        // Compute area
 

        // Send area back to the client

        // Print information about circle

    } // end run()
  } // end ServerThread
}
