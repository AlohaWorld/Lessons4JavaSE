package unit07;

public class Demo07P02 {
  private static int balance = 0;
  synchronized private static void save(int money) {
    for(int i = 0 ; i< money; i++) {
      balance = balance + 1;
      System.out.println("Save: "+balance);
    }
  }
  synchronized private static void get(int money) {
    for(int i = 0; i < money; i++) {
      balance = balance - 1;
      System.out.println("Get: "+balance);
    }
  }
  class T1 extends Thread{
    @Override
    public void run() {
      Demo07P02 d1 = new Demo07P02();
      //存款过程
      d1.save(100);
    }
  }
  class T2 implements Runnable{
    @Override
    public void run() {
      Demo07P02 d1 = new Demo07P02();
      //取款过程
      d1.get(50);
    }
  }
  public static void main(String[] args) {
    Demo07P02 d2 = new Demo07P02();
    T1 t1 = d2.new T1();
    T2 t2 = d2.new T2();
    t1.start();
    new Thread(t2).start();

  }
}
