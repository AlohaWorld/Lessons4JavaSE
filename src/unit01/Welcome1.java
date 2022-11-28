/**
 * This file contains Welcome1 class, to demonstrate how to use java comments
 */
package unit01;

/**
 * @author cyd
 * @version 1.0
 * @date ${date} ${time}
 */
public class Welcome1 {

  /**
   * @param args
   * 
   *        print a welcome message
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("Hello Yidong!");
    // System.out.println((new Test9(12)).show());

    Welcome1 w = new Welcome1();

    System.out.println(w.max(12, 23));
  }

  public int max(int x, int y) {
    return x > y ? x : y;
  }

}

/*
class Test9 {
  private int x = 10;

  public Test9(int x) {

    this.x = x;

  }

  public int show() {
    return x;
  }
}
*/
