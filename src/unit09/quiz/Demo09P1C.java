package unit09.quiz;

public class Demo09P1C {

  public static void main(String[] args) {
    // 创建一个连接服务器的socket。
    // Task1：使用try-catch-finally
    // Task2：基于Task1，改为try-with-resource

    // Socket socket = new Socket("", 8000);
    // Socket socket = new Socket("www.bupt.edu.cn", 80);
    // Socket socket = new Socket("10.3.9.161", 80);
    // Socket socket = new Socket("2001:da8:215:4038::161", 80);

    // 创建一个输入流（Data input stream），从服务器接收数据


    // 创建一个输出流（Data output stream），将数据发给服务器


    // Task1：首先让服务器能够接受客户端发来的单个半径并返回面积
    // Task2：在Task1的基础上修改代码，加入while循环，使得客户端可以不断给
    // 服务器发送半径并从服务器获取面积
    // 先创建一个键盘输入流scanner

    do { // 反复读
      // 提示输入半径
      // 从键盘读入一个浮点数

      // 将半径发送给服务器，并将信息写入到控制台


      // 读取服务器返回的面积，输出到控制台

    } while (r > 0.0); // 半径大于0时继续，否则退出
  }
}
