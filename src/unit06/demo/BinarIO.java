package unit06.demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class BinarIO {

  public static void main(String[] args) {
    // 创建一个字节数组 b[]，将一个整数存入该数组
    byte[] b = Integer.toString(180).getBytes();

    FileOutputStream fo;
    try {
      // 创建一个 FileOutputStream，打开"test.bin"文件 
      fo = new FileOutputStream("test.bin");
      DataOutputStream dos = new DataOutputStream(fo);
      // 将 b[] 中的内容写入test.bin文件
      //fo.write(b);
      dos.writeInt(8);
      // 关闭输出文件流
      fo.close();
    } catch (Exception e) {
      // TODO 自动生成的 catch 块
      e.printStackTrace();
    }

    // 创建一个 FileInputStream，打开"test.bin"文件
    FileInputStream fi =null; 
    // 创建字节数组 c[]，从test.bin把数据读入c[]
    byte [] c = new byte[4];
    int x = 0;
    try {
      fi = new FileInputStream("test.bin");
      DataInputStream dis = new DataInputStream(fi);
      x = dis.readInt();
    } catch (IOException e) {
      // TODO 自动生成的 catch 块
      e.printStackTrace();
    } finally {
      try {
        fi.close();
      } catch (IOException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
      }
    }
    System.out.println(x);
  }

}
