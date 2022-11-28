package unit09.demo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.Timer;
import unit04.StillClock;

@SuppressWarnings("serial")
public class TimeClient extends JFrame {

  public static void main(String[] args) {
    TimeClient client = new TimeClient();
    StillClock clock = new StillClock();
    client.add(clock);
    client.setSize(400, 400);
    client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    client.setVisible(true);

    Timer tm = new Timer(1000, new OnTimer(clock));
    tm.start();
  }
}


@SuppressWarnings("deprecation")
class OnTimer implements ActionListener {
  private StillClock clock;

  public OnTimer(StillClock clock) {
    this.clock = clock;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ObjectInputStream os;
    try {
      // get time from server
      Socket socket = new Socket("localhost", 8200);
      os = new ObjectInputStream(socket.getInputStream());
      Date date = (Date) os.readObject();
      clock.setHour(date.getHours());
      clock.setMinute(date.getMinutes());
      clock.setSecond(date.getSeconds());
      clock.repaint();
      os.close();
      socket.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
