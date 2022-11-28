package unit04.edp;

import javafx.beans.property.*;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class MyDigitalClock {

  public static void main(String[] args) {
    // TODO 自动生成的方法存根
  }
}


class Dash {
  private Color strokeColor = Color.BLACK;
  private Color fillColor = Color.BLACK;
  private DoubleProperty thick = 5.0;
  private Point2D start = new Point2D(0, 0);
  private Point2D end = new Point2D(0, 0);

  public Dash(Point2D start, Point2D end) {
    this.start = start;
    this.end = end;
  }

  public Dash(double startX, double startY, double endX, double endY) {
    start = new Point2D(startX, startY);
    end = new Point2D(startX, startY);
  }

  public Color getStrokeColor() {
    return strokeColor;
  }

  public void setStrokeColor(Color strokeColor) {
    this.strokeColor = strokeColor;
  }

  public Color getFillColor() {
    return fillColor;
  }

  public void setFillColor(Color fillColor) {
    this.fillColor = fillColor;
  }

  public DoubleProperty getThick() {
    return thick;
  }

  public void setThick(DoubleProperty thick) {
    this.thick = thick;
  }

  public Point2D getStart() {
    return start;
  }

  public void setStart(Point2D start) {
    this.start = start;
  }

  public Point2D getEnd() {
    return end;
  }

  public void setEnd(Point2D end) {
    this.end = end;
  }

}
