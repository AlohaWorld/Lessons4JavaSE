package dt03;

public class Rect extends Shape {
  private double x, y;
  private double w, h;

  public Rect() {
    x = y = 0;
    w = h =1;
  }
  
  public Rect(double x, double y, double w, double h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;        
  }
  
  public double getX() {
    return x;
  }
  public double getY() {
    return y;
  }
  public double getWidth() {
    return w;
  }
  public double getHeight() {
    return h;
  }
  public String toString() {
    return "Rect";
  }

}
