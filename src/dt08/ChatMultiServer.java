package dt08;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatMultiServer {
  private static int clientNum = 0;

  public static void main(String[] args) throws IOException, InterruptedException {
    final int port = 9001;
    ServerSocket ss = new ServerSocket(port);
    System.out.println("Server started @" + port);

    while (true) {
      Socket socket = ss.accept();
      clientNum++;
      System.out.println("Client " + clientNum + " connected");
      ChatThread ct = new ChatThread(socket, clientNum);
      ct.start();
    } // end while(
  }
}


class ChatThread extends Thread {
  private Socket socket;
  private int clientNum;

  public ChatThread(Socket socket, int clientNum) {
    this.socket = socket;
    this.clientNum = clientNum;
  }

  @Override
  public void run() {
    try {
      DataInputStream input = new DataInputStream(socket.getInputStream());
      String line;
      while (true) {
        if ((line = input.readUTF()) != null) {
          if (line.equals("exit")) {
            System.out.println("Client disconnected");
            break; // 退出循环
          } else { // 将信息打印到屏幕上
            System.out.print(clientNum + ": ");
            System.out.println(line);
          }
        } else { // 没有输入
          Thread.sleep(100);
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
