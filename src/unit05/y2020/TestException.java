package unit05.y2020;

import java.util.Scanner;

public class TestException {

  public static void main(String[] args) throws Exception {
    // 在try{} 中抛出 MyExcept2类型的异常
    // 在catch()中捕获MyExcept和MyExcept2两种类型异常
    try (Scanner scanner = new Scanner(System.in);) {
      System.out.print("Please input 1,2,3 to throw exception");

      int x = scanner.nextInt();
      Exception ex = null;
      switch (x) {
        case 1:
          ex = new MyExcept("MyExcept");
          break;
        case 2:
          ex = new MyExcept2("MyExcept2");
          break;
        default:
          ex = new Exception("General Exception");
      }
      throw ex;
    } catch (MyExcept2 e) {
      System.out.println(e.what());
      System.out.println(e.getMessage());
      // scanner.close();
    } catch (MyExcept e) {
      System.out.println(e.what());
      System.out.println(e.getLocalizedMessage());
      // scanner.close();
    } finally {
      // scanner.close();
    }
  }

}


@SuppressWarnings("serial")
// 创建一个异常类 MyExcept
// 创建一个派生的异常类 MyExcept2
class MyExcept extends Exception {
  public MyExcept() {}

  public MyExcept(String message) {
    super(message);
  }

  public String what() {
    return "MyExcept";
  }
}


@SuppressWarnings("serial")
class MyExcept2 extends MyExcept {
  public MyExcept2() {}

  public MyExcept2(String message) {
    super(message);
  }

  @Override
  public String what() {
    return "MyExcept2";
  }
}
