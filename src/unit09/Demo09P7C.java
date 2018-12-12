package unit09;

import java.io.*;
import java.net.*;
import java.util.*;

public class Demo09P7C {
  public static void main(String[] args) {
    // The byte array for sending and receiving datagram packets
    byte[] buf = new byte[1024];

    // Server InetAddress
    InetAddress server;

    // The packet sent to the server
    DatagramPacket sndPkt;

    // The packet received from the server
    DatagramPacket rcvPkt;

    // get a datagram socket
    try (DatagramSocket socket = new DatagramSocket()){
      // get the address with InetAddress.getByName
      server  = InetAddress.getByName("localhost");
      
      // Create a send packet with DatagramPacket(buffer, length, InetAddress, port)
      sndPkt = new DatagramPacket(buf, buf.length);
      sndPkt.setAddress(server);
      sndPkt.setPort(8000);
      
      // Create a receive packet with DatagramPacket(buffer, length)
   
      // Initialize buffer for each iteration with Arrays.fill


      // 提示并从键盘读入一个浮点数作为圆的半径 with Scanner
      System.out.println("Please input radius : ");
      Scanner scanner = new Scanner(System.in);
      double r = scanner.nextDouble();
      
      // send radius to the server in a packet with DatagramPacket.setData
      buf = Double.valueOf(r).toString().getBytes();
      sndPkt.setData(buf);
      // send the packet with DatagramSocket.send(DatagramPacket)
      socket.send(sndPkt);

      // receive area from the server in a packet with DatagramSocket.receive(DatagramPacket)      
      buf = new byte[1024];
      Arrays.fill(buf, (byte) 0);
      rcvPkt = new DatagramPacket(buf, buf.length);
      socket.receive(rcvPkt);
      
      double area = Double.parseDouble(new String(buf).trim());
      // Display the information. The information is stored in the bytes buffer array
      System.out.println("Radius is " + r + "\n");
      System.out.println("Area received from the server is " + area
          + '\n');
      
      scanner.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    } 
  }
}
