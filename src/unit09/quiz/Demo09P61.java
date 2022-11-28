package unit09.quiz;

/**
 * 完成的实例
 * 
 * 使用WebView编写一个建议浏览器
 * 
 * +--------------------------------------------+
 * | +------------------------------+ |
 * | Address | http://www.bupt.edu.cn | |
 * | +------------------------------+ |
 * | +---------------------------------------+ |
 * | | | |
 * | | WebView | |
 * | | | |
 * | +---------------------------------------+ |
 * +--------------------------------------------+
 */
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.*;
import javafx.stage.*;

public class Demo09P61 extends Application {

  @Override
  public void start(Stage primaryStage) {
    // a Label, a Textfield in a HBox
    // HBox and a WebView in BorderPane
    var lb = new javafx.scene.control.Label("Address");
    var tb = new TextField();
    var hbox = new HBox(10);
    var wv = new WebView();
    var pane = new BorderPane();
    hbox.getChildren().addAll(lb, tb);
    pane.setTop(hbox);
    pane.setCenter(wv);

    // TextBox: setOnAction (EventHandler<ActionEvent> e)
    tb.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {

        URL url = null;
        try {
          url = new URL(tb.getText());
        } catch (MalformedURLException e1) {
          System.err.println("Wrong url: " + tb.getText());
        }

        try {
          wv.getEngine().load(url.toURI().toString());
        } catch (URISyntaxException e1) {
          e1.printStackTrace();
        }

      }
    });

    // new Scene; Stage: setScene, setTitle, show;
    var scene = new Scene(pane, 800, 500);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Web browser");
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }

}
