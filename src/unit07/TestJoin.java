package unit07;

public class TestJoin {
  // Create threads
  Thread printA = new Thread(new PrintChar('a', 100));
  Thread printB = new Thread(new PrintChar('b', 100));
  Thread print100 = new Thread(new PrintNum(100));

  public static void main(String[] args) {
    new TestRunnable();
  }

  public TestJoin() {
    // Start threads
    print100.start();
    printA.start();
    printB.start();
  }

  // The thread class for printing a specified character
  // in specified times
  class PrintChar implements Runnable {
    private char charToPrint; // The character to print
    private int times; // The times to repeat

    /**
     * Construct a thread with specified character and number of times to print the character
     */
    public PrintChar(char c, int t) {
      charToPrint = c;
      times = t;
    }

    /**
     * Override the run() method to tell the system what the thread will do
     */
    public void run() {
      for (int i = 0; i < times; i++)
        System.out.print(charToPrint);
    }


  }

  // The thread class for printing number from 1 to n for a given n
  class PrintNum implements Runnable {
    private int lastNum;

    /** Construct a thread for print 1, 2, ... i */
    public PrintNum(int n) {
      lastNum = n;
    }

    /** Tell the thread how to run */
    public void run() {
      for (int i = 1; i <= lastNum; i++) {
        System.out.print(" " + i);
        try {
          if (i == 50)
                printA.join();  // wait for printA to finish
        } catch (InterruptedException ex) {
          System.out.println(ex.getMessage());
        }
      }
    }

  }
}