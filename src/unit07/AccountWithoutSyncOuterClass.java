package unit07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSyncOuterClass {
  public static void main(String[] args) {
    Account account = new Account();
    // Here we use thread pool to manage threads
    ExecutorService executor = Executors.newCachedThreadPool();

    // Create and launch 100 threads
    for (int i = 0; i < 100; i++) {
      executor.execute(new AddAPennyThread(account));
    }

    executor.shutdown();

    // Wait until all tasks are finished
    while (!executor.isTerminated()) {
    }

    System.out.println("What is balance ? " + account.getBalance());
  }
}

// A thread for adding a penny to the account
class AddAPennyThread implements Runnable {
  private Account account;
  AddAPennyThread(Account account) {
    this.account = account;
  }
  public void run() {
    account.deposit(1);
  }
}


class Account {
  private int balance = 0;

  public int getBalance() {
    return balance;
  }

  public void deposit(int amount) {
    int newBalance = balance + amount;

    // This delay is deliberately added to magnify the
    // data-corruption problem and make it easy to see.
    try {
      Thread.sleep(1);
    } catch (InterruptedException ex) {
    }

    balance = newBalance;
  }
}

