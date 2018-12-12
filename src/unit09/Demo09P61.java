package unit09;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * 现场编程
 * 
 * 使用WebView编写一个简易浏览器
 * 
  +--------------------------------------------+
  |          +------------------------------+  |
  |  Address | http://www.bupt.edu.cn       |  |
  |          +------------------------------+  |
  | +---------------------------------------+  |
  | |                                       |  |
  | |            WebView                    |  |
  | |                                       |  |
  | +---------------------------------------+  |
  +--------------------------------------------+
 */

public class Demo09P61 extends Application {

  @Override
  public void start(Stage primaryStage) {
    // a Label, a Textfield in a HBox
    Label address = new Label("Address");
    var tf = new TextField();
    // HBox and a WebView in BorderPane
    var hb = new HBox(10);
    hb.getChildren().addAll(address, tf);
    var wv = new WebView();
    
    BorderPane bp = new BorderPane();
    bp.setTop(hb);
    bp.setBottom(wv);
    
    // TextBox: setOnAction (EventHandler<ActionEvent> e)
    // new URL from TextBox's text
    // get a WebEngine from WebView and then load the url
    tf.setOnAction(e -> {
      URL url = null;
      try {
        url = new URL(tf.getText());
        var s = url.toURI().toString();
        if(!s.startsWith("http://")) {
          wv.getEngine().loadContent("Error URL");
        }
        wv.getEngine().load(s);
      } catch (MalformedURLException | URISyntaxException e1) {
        e1.printStackTrace();
      }
    });
    
    // new Scene; Stage: setScene, setTitle, show;
    var scene = new Scene(bp, 800, 500);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Web Browser");
    primaryStage.show();

  }
  public static void main(String[] args) {    
    Application.launch(args);
  }

}
