package dt05;

import java.io.File;

/* Ex.1
 * 1. 创建一个File对象，打开硬盘上的文件Example.txt
 * 2. 判断Example.txt是否存在，输出存在与否的信息 */
public class TestTextStream1 {

  public static void main(String[] args) {
    File f = new File("Example.txt");
    boolean exists = f.exists();
    System.out.println(exists);
  }

}
