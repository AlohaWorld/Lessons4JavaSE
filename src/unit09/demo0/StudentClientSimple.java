package unit09.demo0;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class StudentClientSimple extends JApplet implements ActionListener {
  // Button for sending a student to the server
  private JButton jbtRegister = new JButton("Register to the Server");

  // Indicate if it runs as application
  boolean isStandAlone = false;

  // Host name or ip
  String host = "localhost";

  public void init() {
    // Add the button to the applet
    getContentPane().add(jbtRegister, BorderLayout.SOUTH);

    // Register listener
    jbtRegister.addActionListener(this);

    // Find the IP address of the Web server
    if (!isStandAlone)
      host = getCodeBase().getHost();
  }

  /** Handle button action */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtRegister) {
      try {
        // Establish connection with the server
        Socket socket = new Socket(host, 8000);

        // Create an output stream to the server
        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());

        // Create a Student object and send to the server
        Student s = new Student("Adam", "Noyes Street", "Evanston", "IL", "60201");
        toServer.writeObject(s);
      } catch (IOException ex) {
        System.err.println(ex);
      }
    }
  }

  /** Run the applet as an application */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Register Student Client");

    // Create an instance of the applet
    StudentClientSimple applet = new StudentClientSimple();
    applet.isStandAlone = true;

    // Get host
    if (args.length == 1)
      applet.host = args[0];

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}