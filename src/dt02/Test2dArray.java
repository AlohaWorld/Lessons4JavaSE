package dt02;
/* 例1
 * 创建一个类成员二维数组 B，B为3行5列
 * 将数组初始化为 1..15
 * 输出数组内容（按3行5列格式）
 */
/* 例2
 * 主函数中定义二维数组 C，C为 3行5列
 * 将二维数组初始化为 1..15
 * 创建函数 print2dArray(...)，输出数组中的元素（按3行5列格式）
 */
/* 例3
 * 类中定义二维数组 D，D为 3行5列
 * 在类的构造函数中将二维数组初始化为 15个字符串aaa, bbb,...,ooo
 * 创建函数 printArray(String [] s)，输出数组s中的元素
 * 主函数中多次调用printArray(...)输出数组D中的元素（按3行5列格式）
 */

public class Test2dArray {
  private String[][] D = new String[3][5];
  byte[] temp = new byte[3];

  public Test2dArray() {
    for (int i = 0; i < D.length; i++) {
      for (int j = 0; j < D[i].length; j++) {
        for (int k = 0; k < temp.length; k++) { // 创建aaa, bbb等字符串
          temp[k] = (byte) ('a' + i * D[i].length + j);
        }
        D[i][j] = new String(temp);
        System.out.print(D[i][j] + " ");
      }
      System.out.println("");
    }
  }

  public static void main(String[] args) {
    Test2dArray t = new Test2dArray();
  }

}
