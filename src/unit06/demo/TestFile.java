package unit06.demo;

import java.io.File;

public class TestFile {

  public static void main(String[] args) {
    // 创建一个File对象，指定一个硬盘上的文件
    File file = new File("test.txt");
    // 用File对象显式文件是否存在
    if(file.exists()) {
      //如果存在，显式文件大小
      System.out.println("test.txt size is " + file.length());
    }
    else 
      System.out.println("test.txt does not exists!");


  }

}
