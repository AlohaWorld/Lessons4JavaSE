
package dt04;
// 在屏幕上画一个矩形，让它从左移动到右边

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/* 竞速小车:
 * 1. 创建一个新类frame
 * 2. 创建一个新类Lane，Lane从JPanel继承，我们将在Lane中绘制小车
 * 3. 在frame对象中添加几个Lane对象
 * 4. 重写Lane中的paintComponent()函数，绘制小车
 * 5. 创建一个计时器，定时触发一个事件
 * 6. 在事件响应函数中，要求Lane的对象重绘repaint() */

/* 事件处理代码的写法步骤：
 * Step1：写一个Listener类（实现ActionListener接口）
 * Step2：在Listener中重写事件处理函数actionPerformed
 * Step3：写一个界面类
 * Step4：在界面类中创建Listener对象，并注册到界面类的事件处理列表中 */
public class SimpleFrame3 {
  public static void main(String[] args) {
    MyFrame1 myFrame = new MyFrame1("Simple Frame 3");
    myFrame.setSize(400, 300);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setLocationRelativeTo(null);
    myFrame.setVisible(true);
  }
}


@SuppressWarnings("serial")
// 1. 创建一个新类frame
class MyFrame1 extends JFrame {
  Lane[] lane = new Lane[4];

  public MyFrame1(String title) {
    // 3. 在frame对象中添加几个Lane对象
  }
}


class TimerListener implements ActionListener { // Step1
                                                // 写一个Listener类（实现ActionListener接口）
  public void actionPerformed(ActionEvent e) { // Step2
                                               // 在Listener中重写事件处理函数actionPerformed
    /* 在本函数中，希望能够让界面对象重新绘制图形
     * 但是只有界面类中才有 repaint() 函数用于通知JVM调用界面类的paintComponent()函数执行重绘操作
     * 怎么修改本类才能使得本函数中能够调用界面类的repaint()？
     */
    p1.repaint();
    p2.repaint();
  }
}


// 2. 创建一个新类Lane，Lane从JPanel继承，我们将在Lane中绘制小车
class Lane extends JPanel/*补全代码*/ { // Step3 创建一个界面类
  private int offset = 0; // 重绘矩形时，距离初始位置的偏移量
  protected Timer timer;

  public Lane() {
    // 补全代码 // Step4 创建一个事件监听器
    // 补全代码 // 创建一个timer，然后执行事件编程的第四步：Step 4 将创建好的事件监听器注册到界面类的事件处理列表中
    timer.start(); // 启动计时器
  }

  // 在Panel中绘制小车，小车位置要能不断发生变化
  @Override
  protected void paintComponent(Graphics g) { // 重写JPanel中的paintComponent()函数
    super.paintComponent(g);
    // 补全代码，绘制小车，使得小车位置与offset有关
    // 补全代码，使得offset发生变化
  }
}
