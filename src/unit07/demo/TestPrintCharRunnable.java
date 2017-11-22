package unit07.demo;

import java.io.IOException;

public class TestPrintCharRunnable {

  public static void main(String[] args) throws InterruptedException {
    
    PrintCharRunnable pcr = new PrintCharRunnable();
    Thread th = new Thread( pcr );
    th.start();  
    
    Thread.sleep(1000);
    System.out.print("Hello, World!");

  }

}

class PrintCharRunnable implements Runnable {
  private Thread obj;
  public PrintCharRunnable(Thread obj) {
    this.obj = obj;
  }
  @Override
  public void run() {
    for (int j = 0; j < 10; j++) {
      for (int i = 0; i < 26; i++) {
        System.out.print((char) ('a' + i) + " ");
        /*
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        */
        try {
          if(System.in.available()>0) {
            System.exit(0);
          }
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      System.out.print("\n");
      try {
        obj.wait();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
