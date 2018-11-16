/**
 * @(#)HelloJFX.java    1.0.0 09/05/2018
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
 * Application的派生类MyJFXApp <br>
 * 该类为default访问权限(非public) <br>
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
public class HelloJFX {
   public static void main(String[] args) { 
    Application.launch(HelloJFXApp.class, args);
  }
}