package unit09.demo2;

import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeServer {

  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    final int port = 8100;
    ServerSocket ss = new ServerSocket(port);
    InetAddress saddr = ss.getInetAddress();
    System.out.println("Server started at "+saddr.toString());

    ExecutorService es = Executors.newCachedThreadPool();
    while (true) {
      Socket socket = ss.accept();
      es.execute(new ServeTime(socket));
    }
  }
}

class ServeTime implements Runnable {
  Socket socket;
  public ServeTime(Socket socket) {
    this.socket = socket;
  }
  public void run() {
    try {
      ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
      Date date = new Date();
      os.writeObject(date);
      os.flush();
      os.close();
      System.out.println(" Send date to client: " + date.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}