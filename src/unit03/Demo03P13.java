package unit03;
// DynamicBinding demo
public class Demo03P13 {

  public static void main(String[] args) {
    //Task 1: Create 3 objects: Circle,Rect,Demo03P13 object and call toString()
    Circle    c1 = new Circle();
    Rect      r1 = new Rect();
    Demo03P13 d1 = new Demo03P13();
    
    System.out.println(c1.toString());
    System.out.println(r1.toString());
    System.out.println(d1.toString());
    System.out.println(new Object().toString());
    
    //Task 2: Create 3 Object reference variable, assign with the above objects
    Object o1 = c1;
    Object o2 = r1;
    Object o3 = d1;
    System.out.println(o1.toString());
    System.out.println(o2.toString());
    System.out.println(o3.toString());
    
    //Task 3: Create 2 Shape reference var, assign with the above Circle/Rect objects
    Shape s1 = c1;
    System.out.println(s1.toString());
    Shape s2 = r1;
    System.out.println(s2.toString());
    //Task 4: use instanceof to test if an reference is a Circle
    //        if true, explicitly cast and output its radius
    Rect r;
    Circle c;
    if(s2 instanceof Rect) {
      r = (Rect) s2;
      System.out.println(r.getW());
    }
    //Task 5: call print to show each object
    print(s1);
    print(r1);
    print(c1);
    print(new Object());
  }
  
  public static void print(Object o) {
    System.out.println(o.toString());
  }
  
  //Task 5: Write a function print(Object o) to output the info of o
}
