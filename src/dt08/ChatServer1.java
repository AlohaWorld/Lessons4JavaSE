package dt08;

import java.net.*;
import java.io.*;

// 建立SocketServer，监听 9001端口
// 客户端连接到SocketServer后，Server显示客户端发送过来的字符串
// 客户端发来 exit 字串，则断开连接
public class ChatServer1 {
  public static void main(String[] args) throws IOException, InterruptedException {
    final int port = 9001;
    ServerSocket ss = new ServerSocket(port);
    System.out.println("Server started @" + port);

    Socket socket = ss.accept();
    System.out.println("Client connected");
    DataInputStream input = new DataInputStream(socket.getInputStream());
    String line;
    while (true) {
      if ((line = input.readUTF()) != null) {
        if (line.equals("exit")) {
          System.out.println("Client disconnected");
          break; // 退出循环
        } else { // 将信息打印到屏幕上
          System.out.println(line);
        }
      } else { // 没有输入
        Thread.sleep(100);
      }
    }
    input.close();
    socket.close();
    ss.close();
  }
}
