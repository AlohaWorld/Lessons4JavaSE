package unit07.demo;

import java.io.IOException;

public class TestPrintCharRunnable {

  public static void main(String[] args) throws InterruptedException {

    PrintCharRunnable pcr = new PrintCharRunnable();
    Thread th = new Thread(pcr);
    th.start();

    Thread.sleep(1000);
    System.out.print("Hello, World!");

  }

}


class PrintCharRunnable implements Runnable {
  private Thread obj;

  public PrintCharRunnable() {
    obj = null;
  }

  public PrintCharRunnable(Thread obj) {
    this.obj = obj;
  }

  @Override
  public void run() {
    for (int j = 0; j < 10; j++) {
      for (int i = 0; i < 26; i++) {
        System.out.print((char) ('a' + i) + " ");
        /*
         * try { Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
         */
        try {
          if (System.in.available() > 0) {
            System.exit(0);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      } // end for (int i = 0;
      System.out.print("\n");
      // 先打印26个字母，等待数字打印完毕之后，再继续打印剩下的字符
      if (obj != null)
        try {
          obj.join(); // obj.join(500); //最多等500ms
        } catch (InterruptedException e) {
          e.printStackTrace();
        } // end try
    } // end for (int j = 0;
  } // end public void run()
}
