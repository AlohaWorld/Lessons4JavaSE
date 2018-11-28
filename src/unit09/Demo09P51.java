package unit09;

/**
 * 现场编程
 * 
 * 使用InetAddress进行地址/名字转换，以及判断目的地址是否可达
 */
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Demo09P51 {
  public static void main(String[] args) {
    // 创建一个Scanner对象从键盘输入信息
    var scanner = new Scanner(System.in);
    String answer, s;
    
    // 开启循环，询问用户是否要继续输入，如果否则退出
    
    
      // 提示输入ip或名字
    
      // 获取从键盘输入的信息
    
      // 创建 InetAddress对象
    
      // 用InetAddress对象转换IP/域名
    
      // 用InetAddress对象判断目的地址是否可达
    do {
      System.out.println("Please input an IP or name: ");
      s  = scanner.next();
      
      try {
        InetAddress address = InetAddress.getByName(s);
        System.out.println("Host name: " + address.getHostName());
        System.out.println("IP address: " + address.getHostAddress());
        System.out.println("Reachable: " + address.isReachable(2000));
      } catch(UnknownHostException e) {
        System.err.println("Unknown host or IP address " + s);
      } catch(IOException e2) {
        System.err.println("Can't reach " + s);
      }
      
      System.out.println("Would you like to input another IP or name? (y or n) ");
      answer = scanner.next();
    } while (answer.equalsIgnoreCase("y")); 

  }
}