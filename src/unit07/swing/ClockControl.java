package unit07.swing;

import javax.swing.*;

import java.awt.event.*;
import java.awt.BorderLayout;


public class ClockControl extends JPanel implements ActionListener {
	private Clock clock = new Clock();
	private JButton jbtSuspend = new JButton("Suspend");
	private JButton jbtResume = new JButton("Resume");

	public ClockControl() {
		// Group buttons in a panel
		JPanel panel = new JPanel();
		panel.add(jbtSuspend);
		panel.add(jbtResume);

		// Add clock and buttons to the panel
		setLayout(new BorderLayout());
		add(clock, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		// Register listeners
		jbtSuspend.addActionListener(this);
		jbtResume.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtSuspend)
			clock.suspend();
		else if (e.getSource() == jbtResume)
			clock.resume();
	}
}
