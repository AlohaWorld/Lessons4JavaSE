package unit02;

public class DemoP22 {


  /* Task 1 Demos about Date() 
   * 1. import which package? 
   * 2. create a Date object 
   * 3. print a date
   */
  java.util.Date d = new java.util.Date();


  /* Task 2 Demos about JFrame 
   * 1. import which package? 
   * 2. create a JFrame object 
   * 3. setTitle/setSize/setLocation/setVisible
   */
  javax.swing.JFrame j = new javax.swing.JFrame();

  public static void main(String[] args) {
    DemoP22 demo = new DemoP22();
    System.out.println(demo.d);

    demo.j.setTitle("Hello");
    demo.j.setSize(200, 150);
    demo.j.setVisible(true);
  }
}

