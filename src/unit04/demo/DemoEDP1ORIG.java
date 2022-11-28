/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. */
package unit04.demo;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author cyd
 */
public class DemoEDP1ORIG extends Application {
  // Add a Label
  private Label lbHello = new Label("Hello");

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Add two HBox

    // Add a Border Panel

    // Put two HBoxs' into the Border Panel
    BorderPane pane = new BorderPane();
    HBox pane1 = new HBox(10);
    HBox pane2 = new HBox(10);
    pane.setTop(pane1);
    pane.setCenter(pane2);

    // Add 4 buttons: OK/Cancel/Yes/No
    Button btnOK = new Button("Okay");
    Button btnCancel = new Button("Cancel");
    Button btnYes = new Button("Yes");
    Button btnNo = new Button("No");

    // Add 4 Buttons into 1st HBox and set Alignment to CENTER (Pos.CENTER)
    pane1.getChildren().addAll(btnOK, btnCancel, btnYes, btnNo);
    pane1.setAlignment(Pos.CENTER);

    // Put the label to another HBox
    pane2.getChildren().add(lbHello);

    // Use setOnAction to assign EventHandler to 4 buttons
    // Ok: new OkHandler class
    btnOK.setOnAction(new OkayListener1());

    // Cancel: new CancelListener class with label as ctor argument
    btnCancel.setOnAction(new CancelListener1(lbHello));

    // Yes: new Inner YesListener class
    btnYes.setOnAction(new YesListener1());

    // No: Use lambda function as the EventHandler
    btnNo.setOnAction(e -> {
      System.out.println("No button pressed");
      lbHello.setText("No button pressed");
      System.out.println(e.getSource().toString());
    });


    // Create a scene and place it in the stage
    Scene scene = new Scene(pane);
    // Set the stage title
    primaryStage.setTitle("HandleEvent");
    // Place the scene in the stage
    primaryStage.setScene(scene);
    // Set stage witdh/height
    primaryStage.setWidth(500);
    primaryStage.setHeight(200);
    // Display the stage
    primaryStage.show();
  }

  // Inner Yes button EventHandler
  class YesListener1 implements EventHandler<ActionEvent> {
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
    launch(DemoEDP1ORIG.class);
  }
}


// Okay button EventHandler class
class OkayListener1 implements EventHandler<ActionEvent> {
  @Override
  public void handle(ActionEvent event) {
    System.out.println("Okay Pressed");
  }
}


// Cancel button EventHandler class. the ctor has a Label argument
// We show message in labels in DemoEDP1 class
class CancelListener1 implements EventHandler<ActionEvent> {
  private Label lbHello;

  public CancelListener1(Label lbHello) {
    super();
    this.lbHello = lbHello;
  }

  @Override
  public void handle(ActionEvent event) {
    System.out.println("Cancel Pressed");
    lbHello.setText("Cancel Pressed");
  }
}
