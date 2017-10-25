package unit04;

//WelcomeApplet.java: Applet for displaying a message
import javax.swing.*;

public class WelcomeApplet extends JApplet {
	/** Construct the applet */
	public WelcomeApplet() {
		add(new JLabel("Welcome to Java", JLabel.CENTER));
	}
}
