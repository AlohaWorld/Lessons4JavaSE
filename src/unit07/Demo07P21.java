package unit07;

/**
 * @desc 基于Demo07P11的存取款例子，修改代码，使得线程之间同步从而避免账户余额出错
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo07P21 {
  public static void main(String[] args) {
    // 创建账户对象

    // Here we use thread pool to manage threads
    ExecutorService executor = Executors.newCachedThreadPool();

    // 创建100个线程用于存钱
    for (int i = 0; i < 100; i++) {
      // executor.execute(new 存钱线程);
    }

    executor.shutdown();

    // Wait until all tasks are finished
    while (!executor.isTerminated()) {
    }
    // 输出银行账户余额
  }
}
/**
 * @task 创建一个线程类，用于给账户存款
 *
 */

/**
 * 借用Demo07P11的账户类或者另外创建一个账户类c
 */

