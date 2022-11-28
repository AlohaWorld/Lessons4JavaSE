package unit09.complete;

import java.io.*;
import java.net.*;
import java.util.*;

public class Demo09P7C {
  public static void main(String[] args) {
    // Datagram socket
    DatagramSocket socket;

    // The byte array for sending and receiving datagram packets
    byte[] buf = new byte[256];

    // Server InetAddress
    InetAddress address;

    // The packet sent to the server
    DatagramPacket sendPacket;

    // The packet received from the server
    DatagramPacket receivePacket;
    try {
      // get a datagram socket
      socket = new DatagramSocket();

      // get the address with InetAddress.getByName
      address = InetAddress.getByName("localhost");

      // Create a send packet with DatagramPacket(buffer, length, InetAddress,
      // port)
      sendPacket = new DatagramPacket(buf, buf.length, address, 8000);

      // Create a receive packet with DatagramPacket(buffer, length)
      receivePacket = new DatagramPacket(buf, buf.length);

      // Initialize buffer for each iteration with Arrays.fill
      Arrays.fill(buf, (byte) 0);

      // 提示并从键盘读入一个浮点数作为圆的半径 with Scanner
      System.out.println("Please input radius : ");
      Scanner scanner = new Scanner(System.in);
      double r = scanner.nextDouble();

      // send radius to the server in a packet with DatagramPacket.setData
      sendPacket.setData(Double.valueOf(r).toString().getBytes());

      // send the packet with DatagramSocket.send(DatagramPacket)
      socket.send(sendPacket);

      // receive area from the server in a packet with
      // DatagramSocket.receive(DatagramPacket)
      socket.receive(receivePacket);

      // Display the information. The information is stored in the bytes buffer
      // array
      System.out.println("Radius is " + r + "\n");
      System.out.println(
          "Area received from the server is " + Double.parseDouble(new String(buf).trim()) + '\n');

      scanner.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
