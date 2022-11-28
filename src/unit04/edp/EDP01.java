package unit04.edp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EDP01 extends Application {
  private Label lbHello = new Label("Hellooooo");

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    BorderPane pane = new BorderPane();
    HBox pane1 = new HBox(10);
    HBox pane2 = new HBox(10);
    pane.setTop(pane1);
    pane.setCenter(pane2);

    Button btnOK = new Button("Okay");
    Button btnCancel = new Button("Cancel");
    Button btnYes = new Button("Yes");
    Button btnNo = new Button("No");
    pane1.getChildren().addAll(btnOK, btnCancel, btnYes, btnNo);
    pane1.setAlignment(Pos.CENTER);

    pane2.getChildren().add(lbHello);

    btnOK.setOnAction(new OkayListener());
    btnCancel.setOnAction(new CancelListener(lbHello));
    btnYes.setOnAction(new YesListener());
    btnNo.setOnAction(e -> {
      System.out.println("No button pressed");
      lbHello.setText("No button pressed");
      System.out.println(e.getSource().toString());
    });
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("HandleEvent"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.setWidth(500);
    primaryStage.setHeight(200);
    primaryStage.show(); // Display the stage
  }

  class YesListener implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
      System.out.println("Yes button pressed");
      lbHello.setText("Yes button pressed");
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(EDP01.class);
  }
}


class OkayListener implements EventHandler<ActionEvent> {
  @Override
  public void handle(ActionEvent event) {
    System.out.println("Okay Pressed");
  }
}


class CancelListener implements EventHandler<ActionEvent> {
  private Label lbHello;

  public CancelListener(Label lbHello) {
    super();
    this.lbHello = lbHello;
  }

  @Override
  public void handle(ActionEvent event) {
    System.out.println("Cancel Pressed");
    lbHello.setText("Cancel Pressed");
  }
}
