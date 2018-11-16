/**
 * @(#)HelloJFX.java    1.0.0 09/05/2018
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
 * Application的派生类HelloJFXApp1 <br>
 * 该类为default访问权限(非public) <br>
 * 将main()从本类中移出，需要特殊处理 <br>
 * 本例演示不正确的写法。
 */
class HelloJFXApp1 extends Application {
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
 *  @see Hello.JFX.java 
 
  public static void main(String[] args) { 
    launch(args);
  }
 */
}


public class HelloJFXError {
   public static void main(String[] args) { 
    Application.launch(HelloJFXApp1.class, args);
  }
}

/* 运行时的错误信息如下
Exception in Application constructor
Exception in thread "main" java.lang.RuntimeException: Unable to construct Application instance: class unit04.HelloJFXApp1
    at javafx.graphics/com.sun.javafx.application.LauncherImpl.launchApplication1(Unknown Source)
    at javafx.graphics/com.sun.javafx.application.LauncherImpl.lambda$launchApplication$2(Unknown Source)
    at java.base/java.lang.Thread.run(Unknown Source)
Caused by: java.lang.NoSuchMethodException: unit04.HelloJFXApp1.<init>()
    at java.base/java.lang.Class.getConstructor0(Unknown Source)
    at java.base/java.lang.Class.getConstructor(Unknown Source)
    at javafx.graphics/com.sun.javafx.application.LauncherImpl.lambda$launchApplication1$8(Unknown Source)
    at javafx.graphics/com.sun.javafx.application.PlatformImpl.lambda$runAndWait$11(Unknown Source)
    at javafx.graphics/com.sun.javafx.application.PlatformImpl.lambda$runLater$9(Unknown Source)
    at java.base/java.security.AccessController.doPrivileged(Native Method)
    at javafx.graphics/com.sun.javafx.application.PlatformImpl.lambda$runLater$10(Unknown Source)
    at javafx.graphics/com.sun.glass.ui.InvokeLaterDispatcher$Future.run(Unknown Source)
    at javafx.graphics/com.sun.glass.ui.win.WinApplication._runLoop(Native Method)
    at javafx.graphics/com.sun.glass.ui.win.WinApplication.lambda$runLoop$3(Unknown Source)
    ... 1 more

 */
