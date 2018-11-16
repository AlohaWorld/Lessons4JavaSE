package unit04.swing;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/* 事件处理代码的写法步骤：
 * Step1：写一个Listener类（实现ActionListener接口）
 * Step2：在Listener中重写事件处理函数actionPerformed
 * Step3：写一个界面类
 * Step4：在界面类中创建Listener对象，并注册到界面类的事件处理列表中
 */
@SuppressWarnings("serial")
public class TestMultipleListener extends JFrame implements ActionListener { // Step 1 & Step 3
	private JButton jbtOk = new JButton("OK");
	private JButton jbtCancel = new JButton("Cancel");

	public TestMultipleListener() {
		setLayout(new FlowLayout());

		add(jbtOk);
		add(jbtCancel);

		// Register the frame as listeners
		jbtOk.addActionListener(this);        //Step 4
		jbtCancel.addActionListener(this);    //Step 4

		// Register a second listener for buttons
		SecondListener secondListener = new SecondListener(); //Step 4
		jbtOk.addActionListener(secondListener);              //Step 4 cont.
		jbtCancel.addActionListener(secondListener);          //Step 4 cont.
	}

	/** Main method */
	public static void main(String[] args) {
		TestMultipleListener frame = new TestMultipleListener();
		frame.setTitle("TestMultipleListener");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 80);
		frame.setVisible(true);
	}

	/** This method will be invoked when a button is clicked */
	public void actionPerformed(ActionEvent e) {  // Step 2
		System.out.print("First listener: ");

		if (e.getSource() == jbtOk) {
			System.out.println("The OK button is clicked");
		} else if (e.getSource() == jbtCancel) {
			System.out.println("The Cancel button is clicked");
		}
	}
}

/** The class for the second listener */
class SecondListener implements ActionListener { // Step 1
	/** Handle ActionEvent */
	public void actionPerformed(ActionEvent e) { // Step 2
		System.out.print("Second listener: ");

		// A button has an actionCommand property, which is same as the
		// text of the button by default.
		if (e.getActionCommand().equals("OK")) {
			System.out.println("The OK button is clicked");
		} else if (e.getActionCommand().equals("Cancel")) {
			System.out.println("The Cancel button is clicked");
		}
	}
}
