package unit07.imcoding;

import java.io.IOException;

// 在屏幕上不断显示计数，每秒显示10个数，每10个数换一次行

public class PrintNum1 {

  public static void main(String[] args) throws InterruptedException, IOException {
    int j = 0;
    String s = new String();

    for(int i=0; i<100; i++) {

      s = (j++ + " ");
      System.out.print(s);

      Thread.yield();
      
      Thread.sleep(50);
      
      if(j%10 == 0) {
        j = 0;
        System.out.print("\n");
      }
      
      if(System.in.available() > 0) {
        System.exit(0);
      }
    }
  }
}