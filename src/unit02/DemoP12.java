package unit02;

public class DemoP12 {
  // 定义一个ragged array，4行
  static int[][] ra = {{1, 12, 13, 14, 15}, {2, 21, 22}, {3, 31}, {4}};

  public static void main(String[] args) {
    // 输出数组长度
    System.out.println(ra.length);
    // 输出数组内容。思路：使用二重循环，外侧循环控制行号，内侧输出每一行
    // 参差数组的每一行长度都可能不同，该怎么办？
    for (int i = 0; i < ra.length; i++) {
      for (int j = 0; j < ra[i].length; j++) {
        System.out.print(" " + ra[i][j]);
      }
      System.out.print("\n");
    }

    // 尝试为某个不存在的元素赋值
    ra[3][2] = 5;
  }
}
