package unit07;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class ClockWithControls1 extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create two buttons to start/stop the clock
    Button btnPause = new Button("Pause");
    Button btnContinue = new Button("Continue");

    // Create a hbox to hold the buttons with center alignment
    HBox lpane = new HBox(30);
    lpane.getChildren().addAll(btnPause, btnContinue);
    lpane.setAlignment(Pos.CENTER);

    // Create a clock
    ClockPane clock = new ClockPane();

    // Create a panel to hold the clock pane and control buttons
    BorderPane pane = new BorderPane();
    pane.setCenter(clock);
    pane.setBottom(lpane);

    // Create a handler for animation
    EventHandler<ActionEvent> eventHandler = e -> {
      clock.setCurrentTime(); // Set a new clock time
    };

    // Create an animation for a running clock
    Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation


    // Set Action Handler for Buttons
    btnPause.setOnAction(e -> {
      animation.stop();
    });
    btnContinue.setOnAction(e -> {
      animation.play();
    });

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 250);
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
