/**
 * @(#)HelloJFXApp.java 1.0.0 09/05/2018
 * @author cuiyidong
 * @version 1.0
 */
package unit04.jfxbasics;

/**
 * 首先引入Application、Scene、Button、Stage这几个包/类
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/** 
 * Application的派生类HelloJFXApp <br>
 * 界面元素在这里创建并显示 <p>
 * <p>
 * 我们将main()放到另外一个类中，而不是放到Application的派生类HelloJFXApp类中 <br>
 * 为了做到这一点，我们必须采用这样的方式： <br>
 * <li> 将两个类HelloJFXApp与HelloJFX分别放到各自的java源文件中，
 * <li> HelloJFXApp与HelloJFX的访问属性都是public，且他们在同一个包中
 * <li> main()中，不能直接调用 launch(args)函数，而应将 HelloJFXApp的类名作为launch的第一个参数
 * <br>
 * 如果仍然将两个类放在同一个文件中，就会出现“Exception in Application constructor”错误 <br>
 * 代码可以参见HelloJFXError.java
 */

public class HelloJFXApp extends Application {
  /**
   * start方法，覆写 Application类中的同名函数。此处最好在函数名前使用@Override注解
   * 在start()中，我们创建一个按钮(Button对象)，再创建一个场景(Scene对象)，然后将按钮加入到场景中，之后将场景放置到主舞台上
   * @param Stage primaryStage，是一个Stage对象。该对象由Application中调用start()的方法提供。我们目前无需关心该对象。
   * @return 无返回值
   */
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

  /*
  public static void main(String[] args) { 
    launch(args);
  }
  */
}

