package unit05.demo;

public class TestException {
  public static void main(String[] args) {
    try {
      try {
      foo();
      } catch (Exception e) {
        System.out.println("Exception handled");
      }
      bar();
    } catch (MyException e) {
      System.out.println(e.toString());
    }  finally {
      System.out.println("I'm finally!");
    }
  }
  static int foo() throws Exception {
    throw new Exception();
  }
  static int bar() throws MyException {
    throw new MyException("Hello Exception!");
  }
}
class MyException extends Exception {
  String info = "MyException";
  public MyException (String info) {
    this.info = info;
  }
  public String toString() {
    return info;
  }
}
