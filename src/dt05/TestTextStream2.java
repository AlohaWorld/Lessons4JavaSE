package dt05;
/* Ex2
 * 1. 创建一个文本文件输出流
 * 2. 将名字的拼音与年龄输出到文件中
 * 3. 将名字和年龄【分别】读出来，显示到屏幕上
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestTextStream2 {

  public static void main(String[] args) {
    File f = new File("Example.txt");
    boolean exists = f.exists();
    // 创建一个FileWriter的对象
    try {
      FileWriter output = new FileWriter("Example.txt");
      //将名字和年龄写入到文件中
      output.write("CuiYidong "+41);
      output.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
