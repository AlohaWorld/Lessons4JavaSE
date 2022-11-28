package unit09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo09P1S {
  final static int port = 10080;

  public static void main(String[] args) {

    // 创建一个 server socket，使用 try-with-resource
    // 在控制台上提示服务器启动并监听的端口号
    Socket socket = null;
    try (ServerSocket serverSocket = new ServerSocket(port);) {
      System.out.println("Server listening on port " + port);
      int i = 0;
      while (i++ < 100) {
        // 监听并等待接受连接：使用ServerSocket对象的accept()
        socket = serverSocket.accept();

        // 在控制台输出客户端连接信息
        InetAddress address = socket.getInetAddress();
        if (address.getHostAddress().contains("10")) {
          continue;
        }
        System.out.println("Connected from " + address.getHostAddress());

        // 在下面创建一个线程，让线程来干活 worker
        new Worker(socket).start();
      } // end while
      serverSocket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  } // end main
}


// 创建一个线程类，用来计算圆面积
class Worker extends Thread {
  Socket socket = null;

  public Worker(Socket s) {
    this.socket = s;
  }

  @Override
  public void run() {
    try {
      // 创建 Data Input/Output 流
      DataInputStream dis = new DataInputStream(socket.getInputStream());
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

      // Task1：首先让服务器能够接受客户端发来的单个半径并返回面积
      // Task2：在Task1的基础上修改代码，加入while循环，使得服务器可以不断
      // 接收半径、计算面积并将面积发回给客户端
      double radius;
      // 从客户端接收圆的半径（通过DataInput流读取）
      radius = dis.readDouble();
      // 计算圆面积
      double area = 3.1415 * radius * radius;
      // 把面积发回给客户端
      dos.writeDouble(area);
      // 输出提示信息
      System.out.println("The area of circle with radius " + radius + " is: " + area);
    } catch (Exception e) {
      e.printStackTrace();
    }
  } // end run();
}


