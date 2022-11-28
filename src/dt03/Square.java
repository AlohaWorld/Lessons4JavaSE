package dt03;

public class Square extends Rect {

  public Square() {
    super();
  }

  public Square(double x, double y, double side) {
    super(x, y, side, side);
  }

  public double getX() {
    return super.getX();

  }

  public double getY() {
    return super.getY();
  }

  public double getSide() {
    return getWidth();
  }

  public String toString() {
    return "Square";
  }

}
