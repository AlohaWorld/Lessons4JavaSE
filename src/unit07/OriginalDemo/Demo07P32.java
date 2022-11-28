package unit07.OriginalDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc 本例子展示如何使用Lock这个类进行线程间同步
 */
public class Demo07P32 {
  private static Account account = new Account();

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.execute(new DepositTask());
    executor.execute(new WithdrawTask());
    executor.shutdown();

    System.out.println("Deopist Task\t\tWithdraw Task\t\tBalance");
  }

  // A task for adding an amount to the account
  public static class DepositTask implements Runnable {
    @Override
    public void run() {
      while (true) {
        account.deposit((int) (Math.random() * 10) + 1);
        try { // Purposely delay it to let the withdraw method proceed
          Thread.sleep(1000);
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }
    }
  }

  // A task for subtracting an amount from the account
  public static class WithdrawTask implements Runnable {
    @Override
    public void run() {
      while (true) {
        account.withdraw((int) (Math.random() * 10) + 1);
        try { // Purposely delay it to let the withdraw method proceed
          Thread.sleep(1000);
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }
    }
  }

  // An inner class for account
  public static class Account {
    private int balance = 0;

    // get a static Lock object. Attention: not using new
    Lock lock = new ReentrantLock();

    // Create a Condition object with lock.newXXX
    Condition cond = lock.newCondition();

    public int getBalance() {
      return balance;
    }


    public /*synchronized*/ void deposit(int amount) {
      // Acquire a lock: using lock object
      lock.lock();
      this.balance += amount;
      System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
      // notifyAll();

      // Signal thread waiting on conditions: conditionObj.signalXXX
      cond.signalAll();

      // unlock
      lock.unlock();
    }

    public void withdraw(int amount) {
      // Acquire a lock
      lock.lock();
      try {
        while (balance < amount)
          // wait();
          // Wait on condition: conditionObj.await
          cond.await();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }

      balance -= amount;
      System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());

      // release lock
      lock.unlock();
    }
  }
}
