package dt05;

/* Ex3
 * 1. 创建一个DataOutputStream类型的文件输出流，
 * 对应文件为Example.dat
 * 2. 将名字的拼音与年龄输出到文件中 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class TestBinStream2 {
  public static void main(String[] args) {
    File f = new File("Example.dat");
    boolean exists = f.exists();
    System.out.println(exists ? "文件已存在" : "文件不存在");
    // 创建一个FileOutputStream的对象
    try {
      FileOutputStream output = new FileOutputStream(f);
      exists = f.exists();
      System.out.println(exists ? "文件已存在" : "文件不存在");

      // 将名字和年龄写入到文件中
      String s = "崔毅东 ";
      byte[] b = s.getBytes();
      System.out.println("byte[]长度：" + b.length);
      output.write(b);
      output.write((byte) 41);

      output.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
