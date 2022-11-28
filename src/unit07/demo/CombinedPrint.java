package unit07.demo;

public class CombinedPrint {

  public static void main(String[] args) throws InterruptedException {

    PrintNumThread pnt = new PrintNumThread();
    PrintCharRunnable pcr = new PrintCharRunnable(pnt);
    Thread th = new Thread(pcr);

    th.start(); // char

    pnt.start(); // num


  }

}
