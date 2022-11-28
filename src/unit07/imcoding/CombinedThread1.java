package unit07.imcoding;

public class CombinedThread1 {
  public static void main(String[] args) {
    NumThread t1 = new NumThread(); // Print Num
    Thread t2 = new Thread(new CharRunnable()); // Print Char

    Thread mt = Thread.currentThread();
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("Thread Name:" + mt.getName() + "\nThread ID: " + mt.getId()
        + "\nThread Priority:" + mt.getPriority() + "\nThreadtoString:" + mt.toString());

    t1.start();
    t2.start();


  }
}
