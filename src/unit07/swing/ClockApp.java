package unit07.swing;

import javax.swing.JFrame;

public class ClockApp extends JFrame {
	public ClockApp() {
		getContentPane().add(new ClockControl());
	}

  public static void main(String[] args) {
		javax.swing.JFrame frame = new ClockApp();
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Clock");
		frame.setSize(400, 320);
		frame.setVisible(true);
	}
}
