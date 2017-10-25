package unit09;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Questions: 
 * Which line registers an event listener? 
 * Which line handles the event? 
 * Which line connects to server? 
 * Which line send information to server? 
 * Which line get information from server?
 */
public class Client extends JFrame implements ActionListener {
  // Text field for receiving radius
  private JTextField jtf = new JTextField();

  // Text area to display contents
  private JTextArea jta = new JTextArea();

  // IO streams
  private DataOutputStream outputToServer;
  private DataInputStream inputFromServer;

  public static void main(String[] args) {
    new Client();
  }

  public Client() {
    // Panel p to hold the label and text field
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(new JLabel("Enter radius"), BorderLayout.WEST);
    p.add(jtf, BorderLayout.CENTER);
    jtf.setHorizontalAlignment(JTextField.RIGHT);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p, BorderLayout.NORTH);
    getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

    jtf.addActionListener(this); // Register listener

    setTitle("Client");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true); // It is necessary to show the frame here!

    try {
      // Create a socket to connect to the server
      Socket socket = new Socket("localhost", 8000);
      // Socket socket = new Socket("130.254.204.36", 8000);
      // Socket socket = new Socket("drake.Armstrong.edu", 8000);

      // Create an input stream to receive data from the server
      inputFromServer = new DataInputStream(socket.getInputStream());

      // Create an output stream to send data to the server
      outputToServer = new DataOutputStream(socket.getOutputStream());
    } catch (IOException ex) {
      jta.append(ex.toString() + '\n');
    }
  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() instanceof JTextField) {
      try {
        // Get the radius from the text field
        double radius = Double.parseDouble(jtf.getText().trim());

        // Send the radius to the server
        outputToServer.writeDouble(radius);
        outputToServer.flush();

        // Get area from the server
        double area = inputFromServer.readDouble();

        // Display to the text area
        jta.append("Radius is " + radius + "\n");
        jta.append("Area received from the server is " + area + '\n');
      } catch (IOException ex) {
        System.err.println(ex);
      }
    }
  }
}
