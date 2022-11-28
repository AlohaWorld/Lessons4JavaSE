package unit09.quiz;

import java.io.IOException;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.Date;

public class Demo09P7S {
  public static void main(String[] args) {
    // The byte array for sending and receiving datagram packets
    byte[] buf = new byte[256];
    // Create a server socket with DatagramSocket(port)
    try (DatagramSocket socket = new DatagramSocket(8000)) {

      System.out.println("Server started at " + new Date() + '\n');

      // Create a packet for receiving data with DatagramPacket(buffer, length)

      // Create a packet for sending data with DatagramPacket

      while (true) {
        // Initialize buffer for each iteration with Arrays.fill()
        Arrays.fill(buf, (byte) 0);

        // Receive radius from the client socket in a packet

        System.out.println("The client host name is " + receivePacket.getAddress().getHostName()
            + " and port number is " + receivePacket.getPort() + '\n');
        System.out.println("Radius received from client is " + new String(buf).trim() + '\n');

        // Compute area
        double radius = Double.parseDouble(new String(buf).trim());
        double area = radius * radius * Math.PI;
        System.out.println("Area is " + area + '\n');

        // Send area to the client in a packet, with
        // DatagramPacket.setAddress/setPort/setData/send


        sendPacket.setData(Double.valueOf(area).toString().getBytes());

      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}
