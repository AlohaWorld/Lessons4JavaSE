package unit07;

public class Demo07P01 {
  int[] x = {30,40,20,10};
  public static void main(String[] args) throws InterruptedException {
    Thread2 t2 = new Thread2();
    Thread1 t1 = new Thread1(t2);

    t1.start();
    t2.start();

    Thread.sleep(10);
    System.out.println("-----------------");
  }
}
class Thread1 extends Thread{
  Thread2 t2 = null;
  public Thread1(Thread2 t2) {
    this.t2 = t2;
  }
  @Override
  public void run() {
    for(int i = 0 ; i<10; i++) {
      System.out.println("11111111111111");
      if(i == 4)
        try {
          t2.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      try {
        sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
class Thread2 extends Thread {

  @Override
  public void run() {
    for(int i = 0 ; i < 10; i++) {
      System.out.println("22222222222222222");
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
