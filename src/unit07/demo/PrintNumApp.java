package unit07.demo;

import java.io.IOException;

// 打印0-9阿拉伯数字
public class PrintNumApp {
  public static void main(String[] args) {
    PrintNum pn = new PrintNum();
  }
}


class PrintNum {
  public PrintNum() {
    for (int j = 0; j < 100; j++) {
      for (int i = 0; i < 10; i++) {
        System.out.print(i + " ");
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        try {
          if (System.in.available() > 0) {
            System.exit(0);
          }
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      System.out.print("\n");
    }
  }
}
