package unit07.imcoding;

import java.io.IOException;

// 这里要在屏幕上26个小写英文字符，每秒显示20个字符

public class PrintChar1 {

  public static void main(String[] args) throws InterruptedException, IOException {
    int j = 0;
    String s = new String();
    for (int i = 0; i < 100; i++) {
      s = "";
      s += (char) ('a' + j++) + " ";

      System.out.print(s);

      Thread.sleep(50);

      if (j == 26) {
        j = 0;
        System.out.print("\n");
      }

      if (System.in.available() > 0) {
        System.exit(0);
      }
    }
  }

}
