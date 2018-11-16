package dt04;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * JavaFX程序：
 * 1. 类从Application派生
 * 2. Override start方法:绘图。。。
 * 3. 有时需要main():要在IDE运行JavaFX程序时才需要它
 */
public class MyClock extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    Clock clock = new Clock(9, 10, 30, true);
    clock.Paint();
    Scene scene = new Scene(clock, 480, 320);
    scene.setFill(Color.YELLOW);
    primaryStage.setTitle("My Clock");
    primaryStage.setScene(scene);
    primaryStage.centerOnScreen();
    primaryStage.show();
    
    /**
     * 创建一个TimeLine,指定绘制每一帧的函数为 Clock.Paint()
     */
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}

class Clock extends StackPane {
  // 私有成员，表示时分秒
  private int hour, minute, second;
  // 私有成员，表示12小时制或者是24小时制
  private boolean is12;
  // 私有成员，界面元素
  private Label lbTime = new Label(""+hour+":"+minute+":"+second);
  private javafx.scene.text.Font  font   = Font.font("Arial Black", 54.0);

  
  public int getHour() {
    return hour;
  }
  public void setHour(int hour) {
    this.hour = hour;
  }
  public int getMinute() {
    return minute;
  }
  public void setMinute(int minute) {
    this.minute = minute;
  }
  public int getSecond() {
    return second;
  }
  public void setSecond(int second) {
    this.second = second;
  }
  public boolean isIs12() {
    return is12;
  }
  public void setIs12(boolean is12) {
    this.is12 = is12;
  }
  
  // 构造函数？？？
  /**
   * @param hour
   * @param minute
   * @param second
   * @param is12
   */
  public Clock(int hour, int minute, int second, boolean is12) {
    super();
    this.hour = hour;
    this.minute = minute;
    this.second = second;
    this.is12 = is12;
    
    // 将显示时间的Label放到Clock这个StackPane中
    this.getChildren().add(lbTime);
    this.setAlignment(Pos.CENTER);
  }

  public void Paint() {
    //指定字体
    lbTime.setFont(font);
    
    //获取当前时间
    Calendar cal = new GregorianCalendar();
    setHour(cal.get(cal.HOUR));
    setMinute(cal.get(cal.MINUTE));
    setSecond(cal.get(cal.SECOND));
    
    //需要保证时分秒都是2位数字显示
    
    //将时间组装为需要的样式
    lbTime.setText(""+hour+":"+minute+":"+second);
  }
  // 公有方法：在Pane上面用文字显示时分秒
}