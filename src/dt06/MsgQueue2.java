package dt06;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.time.Instant;
import java.util.LinkedList;

public class MsgQueue2 {

  public static void main(String[] args) {
    // 创建一个MQ对象 mq
    MQ mq = new MQ();
    // 创建一个Producer线程，一个Consumer线程，并且启动两个线程
    //    创建一个 ExecutorService 对象引用变量，该对象使用 Executors 类中的函数创建
    ExecutorService executor = Executors.newCachedThreadPool();
    executor.execute(new Producer(mq));
    executor.execute(new Consumer(mq));
    executor.execute(new Consumer(mq));
  }
}
/*
Producer: -> |Queue--------| -> Consumer
 */
// Queue Class
class MQ {
  private Queue<String> queue = new LinkedList<String>();
  synchronized public void push(String s) throws IllegalStateException {
    // 将参数放入queue中： queue.offer("a");
    // if (!queue.offer(s)) // 如果 offer 执行失败（有限容量的队列是有可能失败的）
    //  throw new Exception("Cannot push " + s + " into MessageQueue");
    queue.add(s);
    notifyAll();
  }
  
  public String pop() {
    // 从队列中取出一个消息： queue.poll());
    String s = null;
    synchronized (this) {
      try {
        while(queue.size() == 0) {
          System.out.println("MessageQueue empty, waiting ...");
          wait();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      s = queue.poll();
    } // end synchronized
    return s;
  }
  
  synchronized public int length() {     // 求队列的长度
    notifyAll();
    return queue.size();
  }
}

// Thread Producer Class： extends Thread 
class Producer extends Thread {
  // 私有成员，存储消息队列对象的引用，以待run()函数中使用
  private MQ mq = null;
  
  /**
   * Constructor
   * @param mq 一个消息队列对象引用
   */
  public Producer(MQ mq) {
    this.mq  = mq;
  }
  
  // 不断地生成消息（字符串）
  private String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private Random rand = new java.util.Random(Instant.now().getEpochSecond());
  private String randString() {
    var sb = new StringBuilder();
    int length;
    while ((length = rand.nextInt(20)) < 3);
    for(int i = 0; i < length; i++) {
      sb.append(s.charAt(rand.nextInt(s.length())));
    }
    return sb.toString();
  }
  
  // 随机延迟一段时间，将消息放到 MQ 的对象中
  @Override
  public void run() {
    // 循环生成随机字符串，然后 push 到消息队列中
    while(true) { 
      String s = randString();
      int sleepTime = rand.nextInt(1000);
      try {
        mq.push(s);   // 将消息放入MQ中
        System.out.println("Producer Message (will sleep " + sleepTime +") : " + s);
      } catch (Exception e) {
        System.out.println("无法向消息队列中添加消息，错误原因：" + e.getLocalizedMessage());
      }

      try {
        sleep(sleepTime);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } // end while
  } // end run()
} // end class Producer

// Thread Consumer Class : implements Runnable
class Consumer implements Runnable {
  private int id;
  private Random rand = new java.util.Random(Instant.now().getEpochSecond());
  private MQ mq = null;
  public Consumer(MQ mq) {
    this.mq = mq;
  }
  // 不停地从 MQ 对象中提取消息
  //    如果队列非空，则将消息取出
  //    如果队列空，则等待
  @Override
  public void run() {
    
    int length = 0; // 避免反复调用 mq.length()函数
    while (true) {
      length = mq.length();
      int sleepTime = rand.nextInt(1000);
      try { // mq.pop() 可能失败抛异常
        System.out.println("Consumer Message (will sleep " + sleepTime +"): " + mq.pop());
      } catch (Exception e) {
        System.out.println("消息队列长度为:" + length + ", 但是消费时出错。\n" + "错误信息是： " + e.getLocalizedMessage());
      }
      try {
        Thread.sleep(sleepTime);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}