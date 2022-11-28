package unit09.quiz;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Scanner;

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

      // get the address with InetAddress.getByName

      // Create a send packet with DatagramPacket(buffer, length, InetAddress,
      // port)

      // Create a receive packet with DatagramPacket(buffer, length)

      // Initialize buffer for each iteration with Arrays.fill
      Arrays.fill(buf, (byte) 0);

      // 提示并从键盘读入一个浮点数作为圆的半径 with Scanner
      System.out.println("Please input radius : ");
      Scanner scanner = new Scanner(System.in);
      double r = scanner.nextDouble();

      // send radius to the server in a packet with DatagramPacket.setData

      // send the packet with DatagramSocket.send(DatagramPacket)

      // receive area from the server in a packet with
      // DatagramSocket.receive(DatagramPacket)

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
