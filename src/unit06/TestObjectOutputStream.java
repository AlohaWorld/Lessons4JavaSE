package unit06;

import java.io.*;

public class TestObjectOutputStream {
  public static void main(String[] args) throws IOException {
    // Create an output stream for file object.dat
    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat"));

    // Write a string, double value, and object to the file
    output.writeUTF("John");
    output.writeDouble(85.5);
    output.writeObject(new java.util.Date());
    output.writeObject(new javax.swing.JButton("OK"));

    // Close output stream
    output.close();
  }
}
