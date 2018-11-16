package unit04.swing;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class DrawRectangles extends JFrame {
	public DrawRectangles() {
		setTitle("DrawRectangles");
		this.setLayout(new BorderLayout());
		
		getContentPane().add(new RectPanel());
		this.add(new RectPanel());
	}

	/** Main method */
	public static void main(String[] args) {
		DrawRectangles frame = new DrawRectangles();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 250);
		frame.setVisible(true);
	}
}

class RectPanel extends JPanel {
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Set new color
		g.setColor(Color.red);

		// Draw a rectangle
		g.drawRect(5, 5, getWidth() / 2 - 10, getHeight() / 2 - 10);

		// Draw a rounded rectangle
		g.drawRoundRect(getWidth() / 2 + 5, 5, getWidth() / 2 - 10,
				getHeight() / 2 - 10, 60, 30);

		// Change the color to cyan
		g.setColor(Color.cyan);

		// Draw a 3D rectangle
		g.fill3DRect(5, getHeight() / 2 + 5, getWidth() / 2 - 10,
				getHeight() / 2 - 10, true);

		// Draw a raised 3D rectangle
		g.fill3DRect(getWidth() / 2 + 5, getHeight() / 2 + 5,
				getWidth() / 2 - 10, getHeight() / 2 - 10, false);
	}
}
