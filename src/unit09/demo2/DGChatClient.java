package unit09.demo2;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;

import javax.swing.*;

public class DGChatClient {

  public static void main(String[] args) {
    try(DatagramSocket socket = new DatagramSocket()) {
      /* The try-with-resources statement is a try statement that declares one or more resources. 
       * A resource is an object that must be closed after the program is finished with it. 
       * The try-with-resources statement ensures that each resource is closed at the end of 
       * the statement. 
       * Any object that implements the new java.lang.AutoCloseable interface or 
       * the java.io.Closeable interface can be used as a resource. 
       * The classes java.io.InputStream, OutputStream, Reader, Writer,
       *  java.sql.Connection, Statement, and ResultSet have been retrofitted to implement 
       *  the AutoCloseable interface and can all be used as resources in 
       *  a try-with-resources statement. 
       */
      byte[] buf = new byte[1024];
      Arrays.fill(buf, (byte) 0);

      DatagramPacket receivePkt = new DatagramPacket(buf, buf.length);
      
      ChatWindow chatWindow = new ChatWindow(socket);
      chatWindow.setSize(600,400);
      chatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      chatWindow.setLocationRelativeTo(null);
      chatWindow.setVisible(true);
      while(true) {
        socket.receive(receivePkt);
        String message = new String(buf);
        chatWindow.displayMessage(message);        
      }      
    } catch (SocketException se) {
      se.printStackTrace();
    } catch (IOException ie) {
      ie.printStackTrace();
    }

  }

}

class ChatWindow extends JFrame implements ActionListener{
  private static final long serialVersionUID = -5965242579953647258L;
  private DatagramSocket socket;
  private JTextArea jtaMsgArea = new JTextArea();
  private JTextField jtfMessage = new JTextField(24);
  private JButton jbSend = new JButton("Send");
  private JPanel jpMessage = new JPanel();
  
  private InetAddress address;
  private final int port = 8000;
  
  public ChatWindow (DatagramSocket socket) {
    this.socket = socket;
    try {
      address  = InetAddress.getByName("localhost");
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    
    jpMessage.setLayout(new BorderLayout());
    jpMessage.add(jtfMessage, BorderLayout.CENTER);
    jpMessage.add(jbSend, BorderLayout.EAST);
    this.setLayout(new BorderLayout());
    this.add(jtaMsgArea, BorderLayout.CENTER);    
    this.add(jpMessage, BorderLayout.SOUTH);
    jbSend.addActionListener(this);
  }
  @Override
  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand() != "Send") {
      return;
    }
    if(jtfMessage.getText().length() == 0) {
      JOptionPane.showMessageDialog(this, "We cannot send empty message!", 
          "Empty Message", JOptionPane.ERROR_MESSAGE);
      return;
    }
    byte[] buf;
    buf = jtfMessage.getText().getBytes();
    DatagramPacket sendPkt = new DatagramPacket(buf,buf.length, address, port);
    try {
      socket.send(sendPkt);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void displayMessage(String message) {
    jtaMsgArea.append(message);
  }
  
}