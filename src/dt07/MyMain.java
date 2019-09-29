package dt07;

import java.util.Random;

public class MyMain {

  public static void main(String[] args) {
    // 创建 Judge 线程 j: 能看到 class Judge
    // class Judge: 外部类，内部类

  }


}

class Judge implements Runnable {
  // c1和c2线程对应Client类；
  // c1和c2线程由j线程创建，所以创建代码要放到Judge类中
  //     Judge类必须能访问Client类
  Client c1 = new Client();
  Client c2 = new Client();
  MyChar myChar = new MyChar();
  @Override
  public void run() {
    Thread t1 = new Thread(c1);
    Thread t2 = new Thread(c2);
    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      // TODO 自动生成的 catch 块
      e.printStackTrace();
    }
    System.out.print(c1.getC());

    
  }

  class Client implements Runnable{
    private char c;
    public char getC() {
      return c;
    }
    public void run() {
      Random random = new Random();
      int offset  = random.nextInt(25);
      c = (char) ('a' + offset);
      
    }
  }
}
// class Client implements Runnable {}


class MyChar {
  private char x, y;
  public MyChar() {
    
  }
  public int randomSleep() {
    
  }
  public char generateChar() {
    x = 'z';
    return x;
  }
  public char getX() {
    return x;
  }
}