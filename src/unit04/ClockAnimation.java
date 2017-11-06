package unit04;

import java.awt.event.*;
import javax.swing.*;
/* 事件处理代码的写法步骤：
 * Step1：写一个Listener类（实现ActionListener接口）
 * Step2：在Listener中重写事件处理函数actionPerformed
 * Step3：写一个界面类
 * Step4：在界面类中创建Listener对象，并注册到界面类的事件处理列表中
 */
public class ClockAnimation extends StillClock          //Step 3
                            implements ActionListener { //Step 1
	// Create a timer with delay 1000 ms
    /*
     * CAUTION! C++03 does NOT allow initializing member variables when they are declared.
     *          C++11 allows with some limitations
     */
	protected Timer timer = new Timer(1000, this); //Step 4 将创建好的listener对象加到界面类的事件处理列表中
	/*
	 * default:  [same package (other class & subclass: ok] [other package(incl. subclass): deny]
	 * protected:[same package (other class & subclass: ok] [other package(excl. subclass): deny]
	 *                                                      [other package but subclass: ok]
	 */

	public ClockAnimation() {
		timer.start();
	}

	/** Handle the action event */
	public void actionPerformed(ActionEvent e) { //Step 2
		// Set new time and repaint the clock to display current time
	    // setCurrentTime() is defined in StillClock.java
		setCurrentTime();
		
		// java.awt.Component.repaint()
		repaint();
	}

	/** Main method */
	public static void main(String[] args) {
		JFrame frame = new JFrame("ClockAnimation");
		ClockAnimation clock = new ClockAnimation();  //Step 4 创建listener对象
		frame.add(clock);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}
