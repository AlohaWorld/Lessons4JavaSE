package unit07.demo;

import java.io.IOException;

// 创建一个线程类，从Thread类继承；
// 在线程类中打印0-9阿拉伯数字
// 让线程运行起来
public class TestPrintNumThread {

  public static void main(String[] args) throws InterruptedException {
    PrintNumThread pnt = new PrintNumThread();
    pnt.start();
    
    Thread mt = Thread.currentThread();
    Thread.sleep(2000);
    System.out.println("Main thread priority: " + mt.getPriority()
     + "\n Main thread ID: " + mt.getId() 
     + "\n Main thread string: " + mt.toString());
  }
}

class PrintNumThread extends Thread {
  @Override
  public void run() {
    for (int j = 0; j < 10; j++) {
      for (int i = 0; i < 10; i++) {
        System.out.print( i + " ");
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
          e.printStackTrace();
        }
      }
      System.out.print("\n");
    }
  }
}
