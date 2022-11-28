package unit03;

public class TestCircleWithStaticVariableAndMethod {
  /** Main method */
  public static void main(String[] args) {
    // Create circle1
    CircleWithStaticVariableAndMethod circle1 = new CircleWithStaticVariableAndMethod();

    // Display circle1 BEFORE circle2 is created
    System.out.println("Before creating circle2");
    System.out.print("circle1 is : ");
    printCircle(circle1);

    // Create circle2
    CircleWithStaticVariableAndMethod circle2 = new CircleWithStaticVariableAndMethod(5);

    // Change the radius in circle1
    circle1.setRadius(9);

    // Display circle1 and circle2 AFTER circle2 was created
    System.out.println("\nAfter creating circle2 and modifying " + "circle1's radius to 9");
    System.out.print("circle1 is : ");
    printCircle(circle1);
    System.out.print("circle2 is : ");
    printCircle(circle2);
  }

  /** Print circle information */
  public static void printCircle(CircleWithStaticVariableAndMethod c) {
    System.out.println("radius (" + c.getRadius() + ") and number of Circle objects ("
        + c.getNumberOfObjects() + ")");
  }

}
