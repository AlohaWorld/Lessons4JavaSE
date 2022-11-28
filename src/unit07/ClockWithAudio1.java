package unit07;

import java.io.File;
import java.net.MalformedURLException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ClockWithAudio1 extends Application {
  // 先查看硬盘上的音频文件及目录
  // Create audio clips for hour and minute
  private AudioClip[] hourAudio = new AudioClip[12];
  private AudioClip[] minAudio = new AudioClip[60];

  // Create audio clips for pronouncing am and pm
  private AudioClip amAudio;
  private AudioClip pmAudio;

  // Setup the "audio" directory, which use File class
  // Then build the path
  File directory = new File("audio");
  String path;


  /** Called by start(), Initialize the audio system */
  private void initAudio() {
    // Build the path to audio files, then print it
    try {
      path = directory.toURI().toURL().toString();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    System.out.println(path);

    // Setup AudioClip for am/pm
    amAudio = new AudioClip(path + "am.wav");
    pmAudio = new AudioClip(path + "pm.wav");


    // Create audio clips for pronouncing hours
    for (int i = 0; i < hourAudio.length; i++) {
      hourAudio[i] = new AudioClip(path + "hour" + i + ".wav");
    }

    // Create audio clips for pronouncing minutes
    for (int i = 0; i < minAudio.length; i++) {
      minAudio[i] = new AudioClip(path + "minute" + i + ".wav");
    }
  }

  /**
   * Tell the time with given hour and minute
   * @throws InterruptedException 
   */
  private void announceTime(int hour, int minute) {
    // Announce hour, 12-hour format
    hourAudio[hour].play();
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Announce minute
    minAudio[minute].play();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Announce am/pm according to the hour
    if (hour >= 12)
      pmAudio.play();
    else
      amAudio.play();

  }

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create two buttons to start/stop the clock
    Button btnPause = new Button("Pause");
    Button btnContinue = new Button("Continue");

    // Create a hbox to hold the buttons with center alignment
    HBox lpane = new HBox(20);
    lpane.getChildren().addAll(btnPause, btnContinue);
    lpane.setAlignment(Pos.CENTER);

    // Create a clock
    ClockPane clock = new ClockPane();

    // Create a panel to hold the clock pane and control buttons
    BorderPane pane = new BorderPane();
    pane.setCenter(clock);
    pane.setBottom(lpane);

    initAudio();

    // Create a handler for animation
    EventHandler<ActionEvent> eventHandler = e -> {
      clock.setCurrentTime(); // Set a new clock time

      // 每分钟/20秒钟播报一次时间
      if (clock.getSecond() % 20 == 0) {
        new AudioThread(clock.getHour(), clock.getMinute()).start();
      }

    };

    // Create an animation for a running clock
    Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation


    // Set Action Handler for Buttons
    btnPause.setOnAction(e -> {
      animation.pause();
    });
    btnContinue.setOnAction(e -> {
      animation.play();
    });

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 300, 400);
    primaryStage.setTitle("ClockAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /** A new Thread class to announce time
   * 
   */
  class AudioThread extends Thread {
    private int hour, minute;

    public AudioThread(int hour, int minute) {
      this.hour = hour;
      this.minute = minute;
    }

    @Override
    public void run() {
      announceTime(hour, minute);
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
