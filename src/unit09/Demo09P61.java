package unit09;

/**
 * 现场编程
 * 
 * 使用WebView编写一个建议浏览器
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
    // HBox and a WebView in BorderPane
    
    // TextBox: setOnAction (EventHandler<ActionEvent> e)
    // new URL from TextBox's text
    // get a WebEngine from WebView and then load the url

    
    // new Scene; Stage: setScene, setTitle, show;

  }
  public static void main(String[] args) {    
    Application.launch(args);
  }

}
