package unit07;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class ClockWithAudio1 extends Application {
  // 先查看硬盘上的音频文件及目录
  // Create audio clips for hour and minute

  
  // Create audio clips for pronouncing am and pm

  
  // Setup the "audio" directory, which use File class
  // Then build the path

  
  /** Called by start(), Initialize the audio system */
  private void initAudio() {
  
    //Build the path to audio files, then print it

      
    // Setup AudioClip for am/pm


    // Create audio clips for pronouncing hours


    // Create audio clips for pronouncing minutes

  }
  
  /**
   * Tell the time with given hour and minute
   */
  private void announceTime(int hour, int minute) {
    //Announce hour, 12-hour format

    

    //Announce minute

    
    //Announce am/pm according to the hour
    
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

    };
    
    // Create an animation for a running clock
    Timeline animation = new Timeline(
      new KeyFrame(Duration.millis(1000), eventHandler));
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

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
