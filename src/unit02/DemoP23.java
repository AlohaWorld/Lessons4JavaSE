package unit02;

// 有类、主函数：20分

public class DemoP23 {
  public static void main(String[] args) {
    SimpleCircle s1 = new SimpleCircle();
    SimpleCircle s2 = new SimpleCircle(2.0);
    System.out.println("Now there are " + SimpleCircle.getNumberOfObjects() + " Circles.");

    /* Task 2
     * In main()
     * 1. Create an array of Object (SimpleCircle) 10分
     * 2. Print each circle's area by calling SimpleCircle's member "getArea()" 10分
     * 3. Print the number of the instances of SimpleCircle 10分
     */
    SimpleCircle[] s3 = new SimpleCircle[3];
    s3[0] = new SimpleCircle(10.0);
    s3[1] = s1;
    s3[2] = s2;
    for (SimpleCircle i : s3) {
      System.out.println("Circle Area : " + i.getArea());
    }
    System.out.println("Now there are " + SimpleCircle.getNumberOfObjects() + " Circles.");
    /* Task 3
     * 2. Modify the codes in main() to set all object reference to null and call gc() 10分
     */
    for (int i = 0; i < s3.length; i++) {
      s3[i] = null;
      System.gc();
      System.runFinalization();
    }
    System.out.println("Now there are " + s3[0].getNumberOfObjects() + " Circles.");
  }
}


/* Task 1
 * 1. Create a SimpleCircle class
 * 2. Use a static member to count the instances
 * 3. In main(), create some instances, output the number of the instances
 */
class SimpleCircle {
  // 数据成员10分；
  // 构造函数：10分
  // getNumberOfObjects() 函数 10分
  private double radius = 1.0;
  private static int numberOfObjects;

  public SimpleCircle(double radius) { // 有参构造函数
    this.radius = radius;
    numberOfObjects++;
  }

  public SimpleCircle() { // 无参构造函数
    this(1.0); // 委托构造
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public double getArea() {
    return 3.14 * radius * radius;
  }

  public static int getNumberOfObjects() {
    return numberOfObjects;
  }

  /* Task 3
   * 1. 覆写 finalize。10分
   */
  @Override
  protected void finalize() {
    numberOfObjects--;
  }
}
