package unit06;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Demo06P01 {

  public static void main(String[] args){
    // Create a File object, check its methods
    // Scanner: read data from a text file
    // PrintWriter: write data to a text file
    // try-with-resource clause
    // java.net.URL: ctor(), openStream()
    /** InputStream
     *    FileInputStream
     *    ObjectInputStream
     *    FilterInputStream
     *      DataInputStream
     *      BUfferedInputStream
     *  OutputStream
     *    FileOutputStream
     *    ObjectOutputStream
     *    FilterOutputStream
     *      DataOutputStream
     *      BufferedOutputStream
     *  Case Study: Copy file
     *  Case Study: serializing arrays
     *  
     *  RandomAccessFile: read(), write(), seek()
     */
    File f = new File("Demo06.txt");
    
    try (
        FileInputStream in = new FileInputStream(f);
        FileOutputStream out = new FileOutputStream("Demo06.log");
        RandomAccessFile ras = new RandomAccessFile("Demo06p01.txt", "rw");

        ){
      ras.seek(3);
      System.out.println(ras.read());

    } catch (IOException e) {
      // TODO 自动生成的 catch 块
      e.printStackTrace();
    }
  }

}

/*
System.out.println(f.getAbsolutePath());
System.out.println(f.length());
System.out.println("Free:" + f.getFreeSpace() + "\tTotal:" + f.getTotalSpace());
Scanner input = new Scanner(f);
System.out.println(input.nextDouble());
System.out.println(input.nextDouble());
System.out.println(input.nextLine());
input.close();
*/