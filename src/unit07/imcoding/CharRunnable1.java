package unit07.imcoding;

import java.io.IOException;

public class CharRunnable1 {
  public static void main(String[] args) {
    Thread t2 = new Thread(new CharRunnable());
    t2.start();
  }

}

class CharRunnable implements Runnable{
  @Override
  public void run() {
    int j = 0;
    for(int i=0; i<100; i++) {
      
      System.out.print((char)('a'+j++) + " ");
      
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      
      if(j==26) {
        j=0;
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
