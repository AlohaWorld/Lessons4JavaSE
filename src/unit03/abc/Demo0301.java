package unit03.abc;

public class Demo0301 {

  public static void main(String[] args) {
    // Shape shape = new Shape();
    // System.out.println(shape.toString());
    Shape c1 = new Circle();
    System.out.println("Number of Shape: " + Shape.getNumberOfObjects());
    System.out.println("c1 sides length: " + c1.getSidesLength()); // 输出边长
    Shape c2 = new Circle(10);
    Shape r1 = new Rect(1, 10);
    System.out.println("Rect r1 Sides length: " + r1.getSidesLength());
    Shape x = c1;
    if (x instanceof Rect) {
      Rect rx = (Rect) r1;
      System.out.println(rx.toString() + " w:" + rx.getW() + " h:" + rx.getH());
    } else {
      System.out.println(x.toString());
    }

    // gc & runFinalization 都是系统调用，做垃圾回收
    c1 = null;
    c2 = null;
    System.gc();
    System.runFinalization();
    System.out.println("Number of Shape: " + Shape.getNumberOfObjects());
  }

}


// Create Shape class
abstract class Shape implements ShapeIf {
  private static int numberOfObjects = 0;
  { // 初始化块
    numberOfObjects++;
  }

  Shape() {}

  @Override
  public String toString() {
    return "Shape";
  }

  public static int getNumberOfObjects() {
    return numberOfObjects;
  }

  @Override
  protected void finalize() {
    numberOfObjects--;
  }
}


// 编写interface ShapeIf，其中包含一个getSidesLength() 接口
interface ShapeIf {
  public double getSidesLength(); // 返回图形的边长
}


class Circle extends Shape { // Circle继承Shape，并且实现ShapeIf接口
  // Circle类的成员
  private double r;

  Circle() { // 先调用基类构造函数
    // super();
    // this.r = 1.0;
    this(1.0);
  }

  Circle(double r) {
    super();
    this.r = r;
  }

  @Override
  public String toString() {
    return "Circle";
  }

  @Override
  public double getSidesLength() {
    return 2 * 3.14 * r;
  }
}


class Rect extends Shape {
  private double w, h;

  /**
   * @return the w
   */
  public double getW() {
    return w;
  }

  /**
   * @param w the w to set
   */
  public void setW(double w) {
    this.w = w;
  }

  /**
   * @return the h
   */
  public double getH() {
    return h;
  }

  /**
   * @param h the h to set
   */
  public void setH(double h) {
    this.h = h;
  }

  public Rect() {
    this(1, 1);
  }

  Rect(double w, double h) {
    super();
    this.w = w;
    this.h = h;
  }

  @Override
  public String toString() {
    return "Rect(" + w + ", " + h + ")";
  }

  @Override
  public double getSidesLength() {
    return 2 * w + 2 * h;
  }
}
