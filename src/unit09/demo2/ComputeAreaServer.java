package unit09.demo2;

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ComputeAreaServer extends JFrame {
  // define Text area jta for displaying contents
  JTextArea jta = new JTextArea();

  public static void main(String[] args) {
    new ComputeAreaServer();
  }

  public ComputeAreaServer() {
    // Place text area on the frame
    // 1. setLayout
    getContentPane().setLayout(new BorderLayout());

    // 2. add jta to the view
    getContentPane().add(jta, BorderLayout.NORTH);

    // 3. put scrollpane into frame with specific layout
    // title/size/default close operation/visibility
    setTitle("Server");
    setSize(800, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

    try {
      // Create a server socket
      ServerSocket serverSocket = new ServerSocket(8000);

      // display server start message in jta
      jta.append("Server Stated on " + new Date() + "\n");

      // get socket from server socket, Listen for a connection request
      Socket socket = serverSocket.accept();

      // Create data input and output streams
      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      // use a loop to read radius and write area
      while (true) {
        // 1. Receive radius from the client
        double r = in.readDouble();
        // 2. Compute area
        double area = Math.PI * r * r;
        // 3. Send area back to the client
        out.writeDouble(area);

        // 4. display message about radius and area in jta
        jta.append("radius is " + r + "\n");
        jta.append("area is " + area + "\n");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } // end try/cactch
  } // end ctor
} // end class
