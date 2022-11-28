package unit09.quiz;

/**
 * 完成的实例
 * 
 * 使用InetAddress进行地址/名字转换，以及判断目的地址是否可达
 */
import java.io.IOException;
import java.net.UnknownHostException;

public class Demo09P51 {
  public static void main(String[] args) {
    // 创建一个Scanner对象从键盘输入信息
    String answer, s;

    // 开启循环，询问用户是否要继续输入，如果否则退出
    do {
      // 提示输入ip或名字

      // 获取从键盘输入的信息

      try {
        // 创建 InetAddress对象

        // 用InetAddress对象转换IP/域名

        // 用InetAddress对象判断目的地址是否可达

      } catch (UnknownHostException e) {
        System.err.println("Unknown host or IP address " + s);
      } catch (IOException e2) {
        System.err.println("Can't reach " + s);
      }

      System.out.println("Would you like to input another IP or name? (y or n) ");
      answer = scanner.next();
    } while (answer.equalsIgnoreCase("y"));

  }
}
