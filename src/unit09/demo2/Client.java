package unit09.demo2;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* Questions:
 * Which line registers an event listener?
 * Which line handles the event?
 * Which line connects to server?
 * Which line send information to server?
 * Which line get information from server? */
public class Client extends JFrame implements ActionListener {
  // Text field jtf for receiving radius

  // Text area jta to display contents

  // Data IO streams to/from Server

  public static void main(String[] args) {
    new Client();
  }

  // ctor
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

    // register action listener for jtf

    setTitle("Client");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true); // It is necessary to show the frame here!

    try {
      // new a socket to connect to the server localhost:8000

      // Create an data input stream to receive data from the server

      // Create an data output stream to send data to the server

    } catch (IOException ex) {
      jta.append(ex.toString() + '\n');
    }
  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() instanceof JTextField) {
      try {
        // Get the radius from the text field
        double radius = Double.parseDouble(jtf.getText().trim());

        // write radius to the server stream

        // flush stream

        // read area from the server stream

        // Display to the text area
        jta.append("Radius is " + radius + "\n");
        jta.append("Area received from the server is " + area + '\n');
      } catch (IOException ex) {
        System.err.println(ex);
      }
    }
  }
}
