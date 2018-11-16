package unit04.edp;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ObservablePropertyDemo {
  public static void main(String[] args) {
    //DoubleProperty is an abstract class
    // balance is an Observable object, which has addListener()
    DoubleProperty balance = new SimpleDoubleProperty();
    /*
    balance.addListener(new InvalidationListener() {
      public void invalidated(Observable ov) {
        System.out.println("The new value is " + 
          balance.doubleValue());
      }
    });
    */
    balance.addListener(ov -> {
      System.out.println("The new value is " + 
          balance.doubleValue());
    });
   // balance.addListener(new MyListener());
    balance.set(4.5);
  }
  
  /** Inner Class
   *  We create a class which implements InvalidationListener
   */
  public static class MyListener implements InvalidationListener {
    public void invalidated(Observable ov) {
      if(ov instanceof SimpleDoubleProperty) {
        SimpleDoubleProperty sdp = (SimpleDoubleProperty) ov;
        System.out.println("The changed double value is: " + sdp.get());
      }
      else {
        System.out.println("Nothing to show");
      }
    }
  }
}
