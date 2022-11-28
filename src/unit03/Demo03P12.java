package unit03;

public class Demo03P12 {

  public static void main(String[] args) {
    // Task 1: Show radius/area of two Circle objects with 2 ctors
    Circle c1 = new Circle();
    // System.out.println(c1.getNumberOfObjects());
    Circle c2 = new Circle(10.0);
    // System.out.println(Shape.getNumberOfObjects());
    System.out.println(c1.toString());
    System.out.println(c2.toString());
    // Task 2: Show 2 rect objects
    Rect r1 = new Rect();
    Rect r2 = new Rect(3.0, 1.5);
    r1.setColor("Blue");
    r2.setFilled(true);
    System.out.println(r1.toString());
    System.out.println(r2.toString());
    // Task 3: Modify ctor of Circle to show the contruction chain
  }
}


/** Task 1 
 * Create a Circle class which inherit from Shape
 *  Members:
 *    radius
 *    getArea
 *    toString
 *    2 Constructors, which call its parent class's ctor
 */
class Circle extends Shape implements ShapeIF {
  private double radius;
  { // initialization block
    super.setColor("Yellow");
  }

  Circle() {
    super();
    radius = 1.0;
    super.setColor("Blue");
  }

  Circle(double radius) {
    // this();
    this.radius = radius;
    // super.setColor("Yellow");
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public String toString() {
    return "Circle: Radius=" + radius + " Area=" + getArea() + "\n" + super.toString();
  }
  /*
  @Override
  public static int getNumberOfObjects() {
    return super.getNumberOfObjects();
  }
  */
}


/** Task 2
 *  Modify Shape and add getArea;
 */

/** Task 3
 *  Create a Rect class, inheriting from Shape
 *  Members:
 *    width, height
 *    getArea
 *    toString
 *    2 ctors
 */
class Rect extends Shape implements ShapeIF {
  private double w;
  private double h;

  public Rect() {
    super();
    w = h = 1.0;
  }

  public Rect(double width, double height) {
    w = width;
    h = height;
  }

  public double getW() {
    return w;
  }

  public void setW(double width) {
    w = width;
  }

  public double getH() {
    return h;
  }

  public void setH(double height) {
    h = height;
  }

  @Override
  public double getArea() {
    return w * h;
  }

  @Override
  public String toString() {
    return "Rect: width=" + w + ", height=" + h + " Area=" + getArea() + "\n" + super.toString();
  }
}

/** Task 4
 *  try override getNumberOfObjects
 */

/** Task 5
 *  Add an initialization block to Circle & Rect
 *  Add a static initialization block to Shape
 */
