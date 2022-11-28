package unit07;

/**
 * @task 观察无同步情况下，存取款两个线程导致的账户余额混乱
 */
public class Demo07P11 {
  public static void main(String[] args) {
    MyAccount account = new MyAccount();
    // 创建存款和取款线程并运行
    // 观察账户余额
    Thread t1 = new Deposit(account);
    Thread t2 = new Thread(new Withdraw(account));
    System.out.println("存入\t取出\t余额");
    System.out.println("\t\t" + account.getBalance());
    // 启动线程
    t1.start();
    t2.start();
  }

}


/**
 * @desc 创建一个账户类
 * @desc 有一个账户成员；
 * @desc 有一个存款函数deposit()，一个取款函数withdraw()
 */
class MyAccount {
  int balance = 0;

  public int getBalance() {
    return balance;
  }

  public void setBalance(int b) {
    balance = b;
  }

  public int deposit(int money) {
    // 为了展示存取款线程导致的余额混乱，我们故意将存取款过程分为2步
    int newBalance = this.getBalance() + money;
    this.setBalance(newBalance);
    // 输出语句也要放到当前函数中，主要是考虑使用synchronized之后的效果
    System.out.println(money + "\t\t" + this.getBalance());
    return this.getBalance(); // 返回余额。该返回值可以不使用
  }

  public int withdraw(int money) {
    // 为了展示存取款线程导致的余额混乱，我们故意将存取款过程分为2步
    int newBalance = this.getBalance() - money;
    this.setBalance(newBalance);
    // 输出语句也要放到当前函数中，主要是考虑使用synchronized之后的效果
    System.out.println("\t" + money + "\t" + this.getBalance());
    return this.getBalance(); // 返回余额。该返回值可以不使用
  }
}


/**
 * @desc 创建一个存款线程类，继承Thread
 * @task 调用账户的存款函数，不断存款，并且输出账户余额
 */
class Deposit extends Thread {
  MyAccount account;

  public Deposit(MyAccount account) {
    this.account = account;
  }

  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {
      int money = (int) (Math.random() * 10);
      account.deposit(money);
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}


/**
 * @desc 创建一个取款线程类，实现Runnable接口
 * @task 调用账户的取款函数，不断取款，并且输出账户余额
 */
class Withdraw implements Runnable {
  MyAccount account;

  public Withdraw(MyAccount account) {
    this.account = account;
  }

  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {
      int money = (int) (Math.random() * 10);
      account.withdraw(money);
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
