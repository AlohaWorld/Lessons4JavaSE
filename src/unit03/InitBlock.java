package unit03;

public class InitBlock extends B {
  static {
    System.out.println("InitBlock's static init block is invoked");
  }

  public static void main(String[] args) {
    B b1 = new B();
    B b2 = new B();
    InitBlock i1 = new InitBlock();
    InitBlock i2 = new InitBlock();
  }
}


class B {
  static {
    System.out.println("B's static init block is invoked");
  }
}
