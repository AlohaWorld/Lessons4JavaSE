package unit04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* 事件处理代码的写法步骤：
 * Step 1. 写一个Listener类
 * Step 2. 在Listener类中重写一个事件处理函数
 * Step 3. 写一个界面类
 * Step 4. 创建一个listener对象，并将它加到界面类的事件处理列表中
 */

class ButtonListener implements ActionListener { // Step 1
    /** This method will be invoked when a button is clicked */
    public void actionPerformed(ActionEvent e) { // Step 2
        System.out.println("The " + e.getActionCommand() + " button is "
                + "clicked at\n  " + new java.util.Date(e.getWhen()));
    }
}

public class TestActionEvent extends JFrame {   //Step 3
	private JButton jbtOK = new JButton("OK");
	private JButton jbtCancel = new JButton("Cancel");

	public TestActionEvent() {
		setLayout(new FlowLayout());

		add(jbtOK);
		add(jbtCancel);

		ButtonListener btListener = new ButtonListener(); //Step 4

		jbtOK.addActionListener(btListener);              //Step 4 cont.
		jbtCancel.addActionListener(btListener);          //Step 4 cont.
	}

	/** Main method */
	public static void main(String[] args) {
		TestActionEvent frame = new TestActionEvent();
		frame.setTitle("TestActionEvent");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 80);
		frame.setVisible(true);
	}
}