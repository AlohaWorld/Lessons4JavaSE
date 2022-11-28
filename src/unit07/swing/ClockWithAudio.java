package unit07.swing;

import java.io.*;
import java.net.*;
import javafx.scene.media.AudioClip;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ClockWithAudio extends JFrame implements ActionListener {
  protected AudioClip[] hourAudio = new AudioClip[12];
  protected AudioClip[] minuteAudio = new AudioClip[60];

  // Create audio clips for pronouncing am and pm
  protected File directory = new File("audio");
  protected String path;

  protected AudioClip amAudio;
  protected AudioClip pmAudio;

  // Create a clock
  private StillClock clock = new StillClock();

  // Create a timer
  private Timer timer = new Timer(1000, this);

  // Create a label to display time
  private JLabel jlblDigitTime = new JLabel("", JLabel.CENTER);

  /** Called by constructor, Initialize the audio system */
  private void initAudio() {
    try {
      path = directory.toURI().toURL().toString();
      System.out.println(path);

      amAudio = new AudioClip(path + "am.wav");
      pmAudio = new AudioClip(path + "pm.wav");
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    // Create audio clips for pronouncing hours
    for (int i = 0; i < 12; i++)
      hourAudio[i] = new AudioClip(path + "hour" + i + ".wav");

    // Create audio clips for pronouncing minutes
    for (int i = 0; i < 60; i++)
      minuteAudio[i] = new AudioClip(path + "minute" + i + ".wav");
  }

  public void actionPerformed(ActionEvent e) {
    clock.setCurrentTime();
    clock.repaint();
    jlblDigitTime.setText(clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond());
    if (clock.getSecond() == 0)
      announceTime(clock.getHour(), clock.getMinute());
  }

  /** Announce the current time at every minute */
  public void announceTime(int hour, int minute) {
    // Announce hour
    hourAudio[hour % 12].play();

    // Time delay to allow hourAudio play to finish
    try {
      Thread.sleep(1500);
    } catch (InterruptedException ex) {
    }

    // Announce minute
    minuteAudio[minute].play();

    // Time delay to allow minuteAudio play to finish
    try {
      Thread.sleep(1500);
    } catch (InterruptedException ex) {
    }

    // Announce am or pm
    if (hour < 12)
      amAudio.play();
    else
      pmAudio.play();
  }

  public ClockWithAudio() throws MalformedURLException {
    // Add clock and time label to the content pane
    add(clock, BorderLayout.CENTER);
    add(jlblDigitTime, BorderLayout.SOUTH);

    // Load audio clips
    initAudio();

    // Start the timer
    timer.start();
  }

  public static void main(String[] args) {
    try {
      ClockWithAudio clockWithAudio = new ClockWithAudio();
      clockWithAudio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      clockWithAudio.setTitle("ClockWithAudio");
      clockWithAudio.setSize(400, 360);
      clockWithAudio.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
