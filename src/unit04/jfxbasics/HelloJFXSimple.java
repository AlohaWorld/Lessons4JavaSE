/**
 * @(#)HelloJFXSimple.java    1.0.0 09/06/2018
 * @author cuiyidong
 * @version 1.0
 * 本例子演示错误放置main()的情形。本例子无法编译通过
 */
package unit04.jfxbasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/** 
 * Application的派生类HelloJFXSimple <br>
 * 需覆写start函数，并且将main函数放到本类中
 */
public class HelloJFXSimple extends Application {
  @Override
  public void start(Stage primaryStage) {
    // 创建一个按钮（使用 Button类）
    Button btHello = new Button("Hello!");
    // 创建一个场景，同时将上面的按钮加到该场景中
    Scene scene = new Scene(btHello, 200, 250);
    // 设置舞台的标题(setTitle)
    primaryStage.setTitle("Hello, JavaFX!");
    // 将场景放到舞台上(setScene)
    primaryStage.setScene(scene); 
    // 显示舞台(show)
    primaryStage.show();
  }
  
/**
 *  launch是静态函数。如果要将main()移出Application派生类，那么要做特殊处理，
 *  @see HelloJFX.java 
 *  
 * The main method is only needed for the IDE with limited
 * JavaFX support. Not needed for running from the command line.
 */ 
  public static void main(String[] args) {
    // 请查资料或看源代码，说明launch所做的事情
    launch(args);
  }
}