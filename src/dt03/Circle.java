package dt03;

public class Circle extends Shape {
  private double radius;

  public Circle() {
    this.radius = 1.0;
  }
  
  public Circle(double newRadius) {
    this.radius = newRadius;
  }
  
  public String toString() {
    return "Circle";
  }

}
