package unit09;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Scanner;

public class Demo09P7C {
  public static void main(String[] args) throws Exception {
    // The byte array for sending and receiving datagram packets
    final int length = 1024;
    byte[] buf = new byte[length];

    // Server InetAddress
    InetAddress server = InetAddress.getByName("localhost");
    final int serverPort = 18000;

    // The packet sent to the server

    // The packet received from the server


    // get a DatagramSocket socket
    // try-with-resource;
    try (var socket = new DatagramSocket()) {
      // get the Server address with InetAddress.getByName

      // Create a send packet with DatagramPacket(buffer, length, InetAddress,
      // port)
      // Or create DatagramPacket with buffer and length, with server
      // address/port set later
      DatagramPacket sndPacket = new DatagramPacket(buf, length, server, serverPort);

      // Create a receive packet with DatagramPacket(buffer, length)
      DatagramPacket rcvPacket = new DatagramPacket(buf, length);
      // Initialize buffer for each iteration with Arrays.fill
      Arrays.fill(buf, (byte) 0);

      // 提示并从键盘读入一个浮点数作为圆的半径 with Scanner
      System.out.println("Please input radius : ");
      Scanner scanner = new Scanner(System.in);
      double r = scanner.nextDouble();

      // Transfer double number to byte[] with Double.valueOf() and
      // String.getBytes()
      byte[] sndBuf = Double.valueOf(r).toString().getBytes();
      // assign the byte[] buf to packet with DatagramPacket.setData
      sndPacket.setData(sndBuf);
      sndPacket.setLength(sndBuf.length);
      // send the packet with DatagramSocket.send(DatagramPacket)
      socket.send(sndPacket);

      // receive area from the server in a packet with
      // DatagramSocket.receive(DatagramPacket)
      byte[] rcvBuf = new byte[1024];
      Arrays.fill(buf, (byte) 0);
      // rcvPacket = new DatagramPacket(buf, buf.length);
      rcvPacket.setData(rcvBuf);
      socket.receive(rcvPacket);

      // Transfer byte[] to double with Double.parseDouble and String(byte[])
      double area = Double.parseDouble(new String(rcvBuf));
      // Display radius and area.
      System.out.println("Radius is " + r + "\n");
      System.out.println("Area received from the server is " + area + '\n');

      scanner.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
