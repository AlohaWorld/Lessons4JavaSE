package unit09;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Date;

public class Demo09P7S {
  public static void main(String[] args) throws IOException {
    // The byte array for sending and receiving datagram packets
    final int length = 1024;
    byte[] buf = new byte[length];
    final int port = 18000;
    // Create a server socket with DatagramSocket(port)
    DatagramSocket socket = new DatagramSocket(port);
    // Create a packet for receiving data with DatagramPacket(buffer, length)
    DatagramPacket rcvPacket = new DatagramPacket(buf, length);
    // Create a packet for sending data with DatagramPacket
    DatagramPacket sndPacket = new DatagramPacket(buf, length);

    // Print information about server started
    System.out.println("Server started on port " + port + ", " + new Date());
    while (true) { // 不断接收客户端发来的数据，计算面积并发回
      // Initialize buffer for each iteration with Arrays.fill()
      Arrays.fill(buf, (byte) 0);
      // Assign data to the received packet
      rcvPacket.setData(buf);
      // Receive radius from the client socket in a packet, call receive()
      socket.receive(rcvPacket);

      InetAddress clientAddress = rcvPacket.getAddress();
      int clientPort = rcvPacket.getPort();

      // Print the client hostname and port number with
      // DatagramPacket.getAddress/getPort
      System.out.println("Received packet from " + clientAddress + ":" + clientPort);

      // use Double.parseDouble to transfer byte[] to double
      Double radius = Double.parseDouble(new String(buf));

      System.out.println("Radius: " + radius);

      // Compute area
      double area = radius * radius * Math.PI;
      System.out.println("Area is " + area + '\n');

      // Send area to the client in a packet, with
      // DatagramPacket.setAddress/setPort/setData/send
      String strAreaString = Double.valueOf(area).toString();
      System.out.println("Area (from double) is: " + strAreaString);
      byte[] sndBuf = strAreaString.getBytes();

      // TODO 发送的数组可能超过一个Double大小，检查收端是否正确接收

      // Assign data to the packet sending to client with setData
      sndPacket.setAddress(clientAddress);
      sndPacket.setPort(clientPort);
      sndPacket.setData(sndBuf);
      // send the packet
      socket.send(sndPacket);
      System.out.println("Area sent.");
    } // end while
  } // end main
} // end class Demo09P7S
