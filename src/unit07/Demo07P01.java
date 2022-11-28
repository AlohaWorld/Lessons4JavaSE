package unit07;

/**
 * @task 1. 创建两个线程，一个继承Thread，打印数字；一个实现Runnable，打印字母；运行之
 * @task 2. 演示使用join() 使得打印数字的线程在打印字母完成后再继续输出；
 */
public class Demo07P01 {
  public static void main(String[] args) {
    // 创建2个线程
    // MyPrintChar p2 = new MyPrintChar();
    Thread p2 = new Thread(new MyPrintChar());
    MyPrintNum p1 = new MyPrintNum(p2);

    // 启动2个线程
    p1.start();
    p2.start();
    // 显示主线程结束信息
    System.out.println("Main thread terminated.");
  }
}


/**
 * @desc 打印数字线程类
 * @task 1. 第一步仅打印数字，每输出一个数字则sleep一段时间
 * @task 2. 打印一部分数字后，使用join()等待字母打印完成再继续
 */
class MyPrintNum extends Thread { // 从Thread类派生
  Thread p2 = null;

  public MyPrintNum(Thread p) {
    this.p2 = p;
  }

  @Override
  public void run() {
    // for 循环，打印数字，每输出一个数字就sleep一下
    for (int i = 0; i < 10; i++) {
      System.out.print(i + " ");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // 打印6之后，等待字母打印完成
      if (i == 2) {
        try {
          p2.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }
  }
}


/**
 * @desc 打印字母线程类
 * @task 每输出一个字母则sleep一段时间
 */
class MyPrintChar implements Runnable {
  @Override
  public void run() {
    int i = 0;
    while (i + 'a' <= 'z') {
      System.out.print((char) ('a' + i));
      System.out.print(" ");
      i++;
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}


