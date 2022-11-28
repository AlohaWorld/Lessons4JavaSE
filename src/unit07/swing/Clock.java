package unit07.swing;

public class Clock extends StillClock implements Runnable {
  private boolean suspended;

  public Clock() {
    new Thread(this).start();
  }

  public void run() {
    while (true) {
      setCurrentTime();
      repaint();

      try {
        Thread.sleep(1000);
        waitIfSuspended();
      } catch (InterruptedException ex) {
      }
    }
  }

  public synchronized void suspend() {
    suspended = true;
  }

  public synchronized void resume() {
    if (suspended) {
      suspended = false;
      notifyAll();
    }
  }

  private synchronized void waitIfSuspended() throws InterruptedException {
    while (suspended)
      wait();
  }
}
