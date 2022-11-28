package unit06.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIO {

  public static void main(String[] args) throws Exception {
    // 创建一个类C，包含字符串成员和整数成员
    // 创建类C的对象c1，然后把c1存到文件中
    C c1 = new C();
    // 使用 ObjectOutputStream/ObjectInputStream
    var f = new File("D:\\test.bin");
    FileOutputStream fos = new FileOutputStream(f);
    var oos = new ObjectOutputStream(fos);
    oos.writeObject(c1);
    oos.close();
    fos.close();

    // 使用 RandomAccessFile 打开 test.bin 文件
    // 检查该文件内容中是否有“Adam”字符串
    // 如果有该字符串，则输出字符串的位置


    var fis = new FileInputStream(f);
    var ois = new ObjectInputStream(fis);
    C c2 = (C) ois.readObject();
    System.out.println(c2.toString());
    ois.close();
    fis.close();
  }
}


class C implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name = "Adam";
  private int age = 10;

  @Override
  public String toString() {
    return name + "-" + age; // Adam-10
  }
}
