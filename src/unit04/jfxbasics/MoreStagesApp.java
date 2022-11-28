/**
 * @(#)MoreStagesApp.java 1.0.0 09/06/2018
 * @author cyd
 * @date 2018年9月6日 上午10:27:25
 *       本代码在D.L. 的 MultipleStageDemo.java基础上稍作修改
 */
package unit04.jfxbasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MoreStagesApp extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a scene and place a button in the scene
    Scene scene = new Scene(new Button("Hello!"), 300, 200);
    primaryStage.setTitle("你好, JavaFX!"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    Stage stage = new Stage(); // Create a new stage
    stage.setTitle("Another Stage"); // Set the stage title
    // Set a scene with a button in the stage
    stage.setScene(new Scene(new Button("Another Stage"), 200, 100));
    stage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
