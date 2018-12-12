package unit09;

import java.io.*;
import java.net.*;
import java.util.*;

public class Demo09P7S {
  public static void main(String[] args) {
    // The byte array for sending and receiving datagram packets
    byte[] buf = new byte[1024];

      // Create a packet for receiving data with DatagramPacket(buffer, length)
    DatagramPacket rcvPkt = new DatagramPacket(buf, buf.length);

      // Create a packet for sending data with DatagramPacket
    DatagramPacket sndPkt = new DatagramPacket(buf, buf.length);
    
    // Create a server socket with DatagramSocket(port)
    try (DatagramSocket socket = new DatagramSocket(8000)) {
      // Print information about server started
      System.out.println("Server started on port 8000, " + new Date());
      while (true) {
        // Initialize buffer for each iteration with Arrays.fill()
        Arrays.fill(buf, (byte) 0);
        rcvPkt.setData(buf);
        // Receive radius from the client socket in a packet
        socket.receive(rcvPkt);
        
        // Print the client hostname and port number with DatagramPacket.getAddress/getPort
        System.out.println("Received packet from " 
            + rcvPkt.getAddress().getHostAddress()
            + ":" + rcvPkt.getPort());
        // 123.2.1.4:8000
        // Print the received radius
        var radius = Double.parseDouble(new String(buf).trim());
        System.out.println("Radius: " + radius);

        // Compute area
        double area = radius * radius * Math.PI;
        System.out.println("Area is " + area + '\n');

        // Send area to the client in a packet, with DatagramPacket.setAddress/setPort/setData/send
        sndPkt.setAddress(rcvPkt.getAddress());
        sndPkt.setPort(rcvPkt.getPort());
        buf = Double.valueOf(area).toString().getBytes();
        // TODO 发送的数组可能超过一个Double大小，检查收端是否正确接收
        sndPkt.setData(buf, 0, buf.length); 
        
        socket.send(sndPkt);

        System.out.println("Area sent.");
      } // end while
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  } // end main
} // end class Demo09P7S
