package unit09.complete;

import java.io.*;
import java.net.*;
import java.util.*;

public class Demo09P7S {
  public static void main(String[] args) {
    // The byte array for sending and receiving datagram packets
    byte[] buf = new byte[256];
    // Create a server socket with DatagramSocket(port)
    try(DatagramSocket socket = new DatagramSocket(8000)) {

      System.out.println("Server started at " + new Date() + '\n');

      // Create a packet for receiving data with DatagramPacket(buffer, length)
      DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);

      // Create a packet for sending data with DatagramPacket
      DatagramPacket sendPacket = new DatagramPacket(buf, buf.length);

      while (true) {
        // Initialize buffer for each iteration with Arrays.fill()
        Arrays.fill(buf, (byte) 0);

        // Receive radius from the client socket in a packet
        socket.receive(receivePacket);
        System.out.println("The client host name is " + receivePacket.getAddress().getHostName()
            + " and port number is " + receivePacket.getPort() + '\n');
        System.out.println("Radius received from client is " + new String(buf).trim() + '\n');

        // Compute area
        double radius = Double.parseDouble(new String(buf).trim());
        double area = radius * radius * Math.PI;
        System.out.println("Area is " + area + '\n');

        // Send area to the client in a packet, with DatagramPacket.setAddress/setPort/setData/send
        sendPacket.setAddress(receivePacket.getAddress());
        sendPacket.setPort(receivePacket.getPort());
        sendPacket.setData(Double.valueOf(area).toString().getBytes());
        socket.send(sendPacket);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}
