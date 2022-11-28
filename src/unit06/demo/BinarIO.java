package unit06.demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinarIO {

  public static void main(String[] args) {
    // 创建一个字节数组 b[]，将一个整数存入该数组
    // byte[] b = Integer.toString(180).getBytes();
    // byte[] b = java.nio.ByteBuffer.allocate(4).putInt(180);
    var f = new java.io.File("D:\\test.bin");
    try {
      // 创建一个 FileOutputStream，打开"test.bin"文件
      var fo = new FileOutputStream(f);
      var dos = new DataOutputStream(fo);
      dos.writeInt(180);
      // 将 b[] 中的内容写入test.bin文件
      // fo.write(b);
      // 关闭输出文件流
      fo.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    // 创建一个 FileInputStream，打开"test.bin"文件
    try (var fi = new FileInputStream(f); var dis = new DataInputStream(fi)) {
      // 创建字节数组 c[]，从test.bin把数据读入c[]
      // byte[] c = new byte[1024];
      // fi.read(c);
      int x = dis.readInt();
      // int x = java.nio.ByteBuffer.wrap(c).getInt();
      System.out.println(x);
    } catch (IOException e) {
    }
  }

}
