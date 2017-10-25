package unit09;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ViewRemoteFile extends JApplet implements ActionListener {
	// Button to view the file
	private JButton jbtView = new JButton("View");

	// Text field to receive file name
	private JTextField jtfURL = new JTextField(12);

	// Text area to store file
	private JTextArea jtaFile = new JTextArea();

	// Label to display status
	private JLabel jlblStatus = new JLabel();

	/** Initialize the applet */
	public void init() {
		// Create a panel to hold a label, a text field, and a button
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(new JLabel("Filename"), BorderLayout.WEST);
		p1.add(jtfURL, BorderLayout.CENTER);
		p1.add(jbtView, BorderLayout.EAST);

		// Place text area and panel p to the applet
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new JScrollPane(jtaFile), BorderLayout.CENTER);
		getContentPane().add(p1, BorderLayout.NORTH);
		getContentPane().add(jlblStatus, BorderLayout.SOUTH);

		// Register listener
		jbtView.addActionListener(this);
	}

	/** Handle the "View" button */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtView)
			showFile();
	}

	private void showFile() {
		// Declare buffered stream for reading text for the URL
		BufferedReader infile = null;
		URL url = null;

		try {
			// Obtain URL from the text field
			url = new URL(jtfURL.getText().trim());

			// Create a buffered stream
			InputStream is = url.openStream();
			infile = new BufferedReader(new InputStreamReader(is));

			// Get file name from the text field
			String inLine;

			// Read a line and append the line to the text area
			while ((inLine = infile.readLine()) != null) {
				jtaFile.append(inLine + '\n');
			}

			jlblStatus.setText("File loaded successfully");
		} catch (FileNotFoundException e) {
			jlblStatus.setText("URL " + url + " not found.");
		} catch (IOException e) {
			jlblStatus.setText(e.getMessage());
		} finally {
			try {
				if (infile != null)
					infile.close();
			} catch (IOException ex) {
			}
		}
	}

	/** Main method */
	public static void main(String[] args) {
		// Create a frame
		JFrame frame = new JFrame("View File From a Web Server");

		// Create an instance of ViewRemoteFile
		ViewRemoteFile applet = new ViewRemoteFile();

		// Add the applet instance to the frame
		frame.getContentPane().add(applet, BorderLayout.CENTER);

		// Invoke init() and start()
		applet.init();
		applet.start();

		// Display the frame
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
