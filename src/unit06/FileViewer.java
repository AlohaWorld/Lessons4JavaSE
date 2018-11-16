package unit06;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/* 事件处理代码的写法步骤：
 * Step 1. 写一个Listener类
 * Step 2. 在Listener类中重写一个事件处理函数
 * Step 3. 写一个界面类
 * Step 4. 创建一个listener对象，并将它加到界面类的事件处理列表中
 */

public class FileViewer extends JFrame implements ActionListener {
	/**
   * 
   */
  private static final long serialVersionUID = -601212416945891844L;

  // Button to view a file
	private JButton jbtView = new JButton("View");

	// Text field to the receive file name
	private JTextField jtfFilename = new JTextField(12);

	// Text area to display the file
	private JTextArea jtaFile = new JTextArea();

	public FileViewer() {
		// Panel p to hold a label, a text field, and a button
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		p.add(new Label("Filename"), BorderLayout.WEST);
		p.add(jtfFilename, BorderLayout.CENTER);
		p.add(jbtView, BorderLayout.EAST);

		// Add jtaFile to a scroll pane
		JScrollPane jsp = new JScrollPane(jtaFile);

		// Add jsp and p to the frame
		getContentPane().add(jsp, BorderLayout.CENTER);
		getContentPane().add(p, BorderLayout.SOUTH);

		// Register listener
		jbtView.addActionListener(this);
	}

	/** Handle the View button */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtView)
			showFile();
	}

	/** Display the file in the text area */
	private void showFile() {
		// Use a BufferedReader to read text from the file
		BufferedReader input = null;

		// Get file name from the text field
		String filename = jtfFilename.getText().trim();

		String inLine;

		try {
			// Create a Buffered File Reader
			input = new BufferedReader(new FileReader(filename));

			// Read a line and append the line to the text area
			while ((inLine = input.readLine()) != null) {
				jtaFile.append(inLine + '\n');
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File not found: " + filename);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (input != null)
					input.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		FileViewer frame = new FileViewer();
		frame.setTitle("FileViewer");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
