package unit04.edp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HandleEvent extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a pane and set its properties
    HBox pane = new HBox(50);
    pane.setAlignment(Pos.CENTER);
    Button btOK = new Button("OK");
    Button btCancel = new Button("Cancel");

    Button btExit = new Button("Exit");
    btExit.setOnAction((ActionEvent e) -> {
      System.out.println("I'm going to exit.");
      System.exit(0);
    });

    OKHandlerClass handler1 = new OKHandlerClass();
    btOK.setOnAction(handler1);

    // CancelHandlerClass handler2 = new CancelHandlerClass();
    // btCancel.setOnAction(handler2);
    btCancel.setOnAction((ActionEvent e) -> {
      System.out.println("Cancel pressed");
    });
    pane.getChildren().addAll(btOK, btCancel, btExit);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("HandleEvent"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.setWidth(300);
    primaryStage.setHeight(150);
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


class OKHandlerClass implements EventHandler<ActionEvent> {
  @Override
  public void handle(ActionEvent e) {
    System.out.println("OK button clicked");
  }
}


class CancelHandlerClass implements EventHandler<ActionEvent> {
  @Override
  public void handle(ActionEvent e) {
    System.out.println("Cancel button clicked");
  }
}
