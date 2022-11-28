package unit06.demo;

public class TestFile {

  public static void main(String[] args) {
    // 创建一个File对象，指定一个硬盘上的文件
    var f = new java.io.File("D:\test.txt");
    // 用File对象显式文件是否存在
    if (f.exists()) {
      // 如果存在，显式文件大小
      System.out.println("File size : " + f.length());
    } else {
      // 提示文件不存在
      System.out.println("File does not exist.");
    }
  }
}
