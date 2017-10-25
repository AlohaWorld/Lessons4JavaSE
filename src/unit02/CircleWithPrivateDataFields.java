package unit02;

public class CircleWithPrivateDataFields {
  /** The radius of the circle */
  private double radius = 1;

  /** Construct a circle with radius 1 */
  public CircleWithPrivateDataFields() {
  }

  /** Construct a circle with a specified radius */
  public CircleWithPrivateDataFields(double radius) {
    this.radius = radius;
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double newRadius) {
    radius = (newRadius >= 0) ? newRadius : 0;
  }

  /** Return the area of this circle */
  public double getArea() {
    return radius * radius * Math.PI;
  }
}
