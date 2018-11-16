package dt01;

public class Dt01t02 {
  private int max(int x, int y) {
    return x>y?x:y;
  }
  private double max(double x, double y) {
    return x>y?x:y;
  }
  private char max(char x, char y) {
    return x>y?x:y;
  }
  public static void test() {
    
  }
  public static void main(String[] args) {
    Dt01t02 d = new Dt01t02();
    System.out.println("max(1,2) is:" + d.max(1,2));
    System.out.println("max(1.1,2.2) is:" + d.max(1.1,2.2));
    System.out.println("max('a','A') is:" + d.max('a','A'));

  }
}

//
//Dt01t02.test();
