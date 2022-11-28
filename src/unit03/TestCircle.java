package unit03;

// TestCircle.java: Demonstrate private modifier
public class TestCircle {
  /** Main method */
  public static void main(String[] args) {
    // Create a Circle with radius 5.0
    Circle myCircle = new Circle(5.0);
    System.out.println(
        "The area of the circle of radius " + myCircle.getRadius() + " is " + myCircle.findArea());

    // Increase myCircle's radius by 10%
    myCircle.setRadius(myCircle.getRadius() * 1.1);
    System.out.println(
        "The area of the circle of radius " + myCircle.getRadius() + " is " + myCircle.findArea());
  }
}
