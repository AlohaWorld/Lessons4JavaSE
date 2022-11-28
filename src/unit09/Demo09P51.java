package unit09;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Demo09P51 {
  public static void main(String[] args) {
    // 创建一个Scanner对象从键盘输入信息
    var scanner = new Scanner(System.in);
    String answer, s;
    try {
      // 开启循环，询问用户是否要继续输入，如果否则退出
      while (true) {
        System.out.println("是否输入域名或者地址 (y/n)");
        s = scanner.next();
        if (s.equalsIgnoreCase("n")) {
          break;
        }

        // 提示输入ip或名字
        System.out.println("Please input ip/name: ");
        // 获取从键盘输入的信息
        answer = scanner.next();

        // 创建 InetAddress对象，使用getByName()

        // 用InetAddress对象转换IP/域名getCanonicalHostName(), getHostAddress
        System.out.println("Host: " + );
        System.out.println("IP:   " + );
        // 用InetAddress对象判断目的地址是否可达 isReachable()
        System.out.println("Reachable? " + );

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    scanner.close();
  }
}
