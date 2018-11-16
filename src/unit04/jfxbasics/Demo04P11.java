package unit04.jfxbasics;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;


public class Demo04P11 extends Application{
  @Override
  public void  start(Stage pStage) {
    StackPane root = new StackPane();
    Button btnOk = new Button("Hello");
    root.getChildren().add(btnOk);
    Scene scene = new Scene(root, 500, 200);
    Circle circle = new Circle(50.0);
    root.getChildren().add(circle);
    
   // Binding properties
   // circle.setCenterX(100);
   circle.centerXProperty().bind(root.widthProperty().divide(3));
   // circle.setCenterY(100);
   circle.centerYProperty().bind(root.heightProperty().divide(3));
   circle.radiusProperty().bind(root.heightProperty().divide(3));


    pStage.setScene(scene);
    pStage.setTitle("Hello world");
    pStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
