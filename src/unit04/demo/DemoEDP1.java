/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. */
package unit04.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DemoEDP1 extends Application {
  // Add a Label as class member
  private Label lHello = new Label("Hello");

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Add two HBox
    HBox box1 = new HBox(10);
    HBox box2 = new HBox(10);
    // Add a Border Panel
    BorderPane pane = new BorderPane();
    // Put two HBoxs' into the Border Panel
    pane.setTop(box1);
    pane.setCenter(box2);

    // Add 4 buttons: OK/Cancel/Yes/No
    Button bOkay = new Button("Okay");
    Button bCancel = new Button("Cancel");
    Button bYes = new Button("Yes");
    Button bNo = new Button("No");
    Button bClose = new Button("Close");

    // Add 4 Buttons into 1st HBox and set Alignment to CENTER (Pos.CENTER)
    box1.getChildren().addAll(bOkay, bCancel, bYes, bNo);
    box1.getChildren().add(bClose);
    box1.setAlignment(Pos.CENTER);

    // Put the label to another HBox

    box2.getChildren().add(lHello);

    // Use setOnAction to assign EventHandler to 4 buttons
    // Ok: new OkHandler class
    bOkay.setOnAction(new OkHandler(lHello));

    // Cancel: new CancelListener class with label as ctor argument

    // Yes: new Inner YesListener class
    bYes.setOnAction(new YesHandler());
    // No: Use Anonymous Inner Class as the EventHandler
    bNo.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        System.out.println("No pressed!");
        lHello.setText("No pressed!");
      }
    });
    // Close: Use lambda function as the EventHandler
    bClose.setOnAction((ActionEvent e) -> {
      if (e.getSource() instanceof Button) {
        Button btn = (Button) e.getSource();
        System.out.println(btn.getText() + " pressed!");
        lHello.setText(btn.getText() + " pressed");
      } else {
        System.out.println(e.getSource().toString() + " was triggered");
      }
    });

    // Create a scene and place it in the stage, meanwhile assign the panel as
    // its root
    Scene scene = new Scene(pane);
    // Set the stage title
    primaryStage.setTitle("Button Test");
    // Place the scene in the stage
    primaryStage.setScene(scene);
    // Set stage witdh/height
    primaryStage.setWidth(400);
    primaryStage.setHeight(250);
    // Display the stage
    primaryStage.show();
  }

  // Inner Yes button EventHandler
  class YesHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
      System.out.println("Yes pressed!");
      lHello.setText("Yes pressed!");
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(DemoEDP1.class);
  }
}


// Okay button EventHandler class
class OkHandler implements EventHandler<ActionEvent> {
  Label lb;

  OkHandler(Label lb) {
    super();
    this.lb = lb;
  }

  @Override
  public void handle(ActionEvent e) {
    System.out.println("Ok pressed!");
    lb.setText("Ok pressed!");
  }
}

// Cancel button EventHandler class. the ctor has a Label argument
// We show message in labels in DemoEDP1 class

