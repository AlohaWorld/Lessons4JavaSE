package unittest;

import java.awt.*;
import javax.swing.*;
import java.math.*;

public class Plot {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    Function panel = new Function();
    frame.add(panel);
    frame.setLocationRelativeTo(null);
    frame.setSize(800, 800);
    frame.setVisible(true);
  }
}

@SuppressWarnings("serial")
class Function extends JPanel {
  final int NPOINTS = 200;
  double x[] = new double[NPOINTS];
  double y[] = new double[NPOINTS];
  final int oX = 40;
  final int oY = 400;
  final double ZOOM = 50.0;

  public Function() {
    for(int i = 0 ; i < NPOINTS; i++) {
      x[i] = i*Math.PI/180;
      y[i] = -2 * x[i] * Math.sin( x[i] * x[i]);
    }
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    //Draw the axis
    g.setColor(Color.blue);
    g.drawLine((int)oX, (int)oY, (int)(oX+300), (int)oY); //x axis
    g.drawLine((int)oX, (int)(oY-400), (int)oX, (int)(oY+200)); //y axis

    //Transform the coordination
    int x1[] = new int[NPOINTS];
    int y1[] = new int[NPOINTS];
    
    for(int i=0; i<NPOINTS; i++) {
      x1[i] = (int)(x[i]*ZOOM)+ oX;
      y1[i] = (int)(y[i]*ZOOM) + oY;
    }

    // Draw the curve
    g.setColor(Color.black);
    g.drawPolyline(x1, y1, NPOINTS);
  }
}