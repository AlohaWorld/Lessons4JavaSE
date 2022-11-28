package unit03;

import java.util.Date;

public class Demo03P11 {

  public static void main(String[] args) {
    Shape s = new Shape();
    s.setColor("Red");
    s.setFilled(true);
    System.out.println(s.toString());
    System.out.println(s.getNumberOfObjects());
    System.out.println(Shape.getNumberOfObjects());
  }
}


/** Create a Shape class with a static member
 *  Members:
 *      String color
 *      boolean filled
 *      Date createDate
 *      static int numberOfObjects
 *      2 constructors
 *      getter/setter
 *      toString
 */
class Shape {
  private String color;
  private boolean filled;
  private Date createDate;
  private static int numberOfObjects;

  public Shape() {
    color = "Black";
    filled = false;
    createDate = new Date();
    numberOfObjects++;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color_) {
    color = color_;
  }

  public boolean getFilled() {
    return filled;
  }

  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public static int getNumberOfObjects() {
    return numberOfObjects;
  }

  public String toString() {
    return "Color=" + color + " Filled=" + filled + " Date=" + createDate;
  }
}


interface ShapeIF {
  public double getArea();
}
