package unit09.coding;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeServer {

  public static void main(String[] args) throws IOException {
    final int port = 8200;
    ServerSocket ss = new ServerSocket(port);
    System.out.println("Listen on " + port );
    ExecutorService es = Executors.newCachedThreadPool();

    while (true) {
      Socket socket = ss.accept();
      es.execute(new TimeThread(socket));
    }
  }

}
class TimeThread implements Runnable {
  private Socket socket;
  public TimeThread(Socket socket) {
    this.socket = socket;
  }
  
  @Override
  public void run() {
    try {
      ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

      Date date = new Date();
      os.writeObject(date);
      System.out.println("Send to client: " + date.toString());
      os.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}


