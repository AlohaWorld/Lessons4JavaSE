package unittest;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Hello1 extends Application {
  String s1 = "Hello";
  ArrayList<Double> s2;
  public static void main (String[] args) {
    byte [] c = new byte[10];
    System.out.println(c.length);
    int [] x = {1, (int) 3.1, 5, 7};
    System.out.println(x.length);
    print(x);
    
    var a = new A();
    final int z =0;
    
    String s = "Hello";
    s == "World";
    s.compareTo("Hello");
    s.equals("Hello");
    
    
    new Thread (new Hello()).start();
    new Thread (new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello");
      }
    }).start();
    
    new Thread (() -> {
      System.out.println("Hello");
    }).start();
    
  }
  class Thread1 extends Thread {
    @Override
    public void run() {
      System.out.println("Hello");
    }
  }
   class Hello implements Runnable {
    @Override
    public void run() {
      for(int i = 0 ; i< 10; i++) {
        System.out.println("Hello World");
      }
    }
  }
  
  final private  int print(int [] x) {
    for(int y : x) {
      System.out.println(y);
    }
    return 0;
  }

}


abstract class  A {
  public int i;
  protected int j;
  private int k;
  abstract public int f();
  public void g() {};
  
};

class Demo {
  public void f() throws Exception {
    throw (new Exception("This is a test"));
  }
  
  public void g() {
    //try-with-resource
    try (FileInputStream fis = new FileInputStream("C:/test.txt")) {
      System.out.println(fis.read());
      
      DataInputStream dis = new DataInputStream();
      var ois = new ObjectInputStream(fis);
      
      SeverSocket ss = new ServerSocket(8000);
      Socket socket = ss.accept();
      var in = socket.getInputStream();
      var ois2 = new ObjectInputStream(in);
      

    } catch (Exception e) {
      e.printStackTrace();
    } finally {

    }
  }
}

