package unit09.complete;

/**
 * 完成的实例
 * 
 * 这是客户端程序，执行时连接到服务器程序，发送圆的半径，
 * 然后接收服务器返回的面积，随后结束
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Demo09P1C {

  public static void main(String[] args) {
    // 创建一个连接服务器的socket。
    // Task1：使用try-catch-finally
    // Task2：基于Task1，改为try-with-resource
    try (Socket socket = new Socket("localhost", 8000)) {
      System.out.println("Connected to server port 8000");
      // Socket socket = new Socket("", 8000);
      // Socket socket = new Socket("www.bupt.edu.cn", 80);
      // Socket socket = new Socket("10.3.9.161", 80);
      // Socket socket = new Socket("2001:da8:215:4038::161", 80);

      // 创建一个输入流（input stream），从服务器接收数据
      var fromServer = new DataInputStream(socket.getInputStream());

      // 创建一个输出流（output stream），将数据发给服务器
      var toServer = new DataOutputStream(socket.getOutputStream());

      // Task1：首先让服务器能够接受客户端发来的单个半径并返回面积
      // Task2：在Task1的基础上修改代码，加入while循环，使得客户端可以不断给
      // 服务器发送半径并从服务器获取面积
      var keyin = new Scanner(System.in);
      double r = 0.00;
      do {
        // 从键盘读入一个浮点数
        System.out.println("Input the radius:");
        r = keyin.nextDouble();

        // 将半径发送给服务器，并将信息写入到控制台
        toServer.writeDouble(r);
        System.out.println("Wrote " + r + " to server");

        // 读取服务器返回的面积，输出到控制台
        var area = fromServer.readDouble();
        System.out.println("Area of circle (r=" + r + ") is: " + area);
      } while (r > 0.0);

      keyin.close();
    } catch (SocketException ex1) {
      System.out.println("Disconnected");
    } catch (IOException ex2) {
      System.out.println(ex2.toString());
    }
  }
}
