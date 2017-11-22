package unit07.imcoding;

import java.io.IOException;

public class NumThread1 {

  public static void main(String[] args) {
    NumThread t1 = new NumThread();
    t1.start();
  }

}

class NumThread extends Thread{
  @Override
  public void run() {
    int j = 0;
    for(int i = 0; i < 100; i++) {
      System.out.print(j++ +" ");

      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      
      if(j%10 == 0) {
        j = 0;
        System.out.print("\n");
      }
      
      try {
        if(System.in.available() > 0) {
          System.exit(0);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }
}