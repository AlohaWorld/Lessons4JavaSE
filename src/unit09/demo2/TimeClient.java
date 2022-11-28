package unit09.demo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.Timer;

import unit04.StillClock;

public class TimeClient extends JFrame {

  public static void main(String[] args) {
    TimeClient client = new TimeClient();
    StillClock clock = new StillClock();
    client.add(clock);
    client.setSize(800, 600);
    client.setVisible(true);
    client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Timer timer = new Timer(1000, new OnTimer(clock));
    timer.start();

  }

}


class OnTimer implements ActionListener {
  private final int port = 8100;
  private StillClock clock;

  public OnTimer(StillClock clock) {
    this.clock = clock;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      Socket socket = new Socket("localhost", port);
      Thread thread = new GetTime(socket, clock);
      thread.start();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}


class GetTime extends Thread {
  private Socket socket;
  StillClock clock;

  public GetTime(Socket socket, StillClock clock) {
    this.socket = socket;
    this.clock = clock;
  }

  @SuppressWarnings("deprecation")
  public void run() {
    Date date;
    int hour, min, sec;
    try {
      ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
      date = (Date) is.readObject();
      hour = date.getHours();
      min = date.getMinutes();
      sec = date.getSeconds();

      synchronized (clock) {
        clock.setHour(hour);
        clock.setMinute(min);
        clock.setSecond(sec);
        clock.repaint();
      }
      is.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
