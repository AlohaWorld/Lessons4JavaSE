package dt03;


import java.util.Scanner;

public class TestShape {

  public static void main(String[] args) {
    Square square = new Square();
    System.out.println(square.toString() +" x=" +square.getX() +
        " y=" + square.getY() + 
        " side=" +square.getSide());
    
    // 接收用户输入
    // 判断用户输入内容，根据内容创建对象
    //  c: 创建 Circle对象
    //  r: 创建Rect对象
    //  s: 创建Square对象
    TestShape t = new TestShape();
    
    System.out.print("Please input what type of shape you want to create:");
    Scanner in = new Scanner(System.in);
    String type = in.next();
        
    Shape s1 = t.createObject(type);
    
    // 在屏幕上输出 s1所属的类的名字
    System.out.println(s1.toString());
  }
  
  public Shape createObject(String type) {
    Shape s;
    
    if(type.equals("c")) {
      s = new Circle();
    }
    else if(type.equals("r")){
      s = new Rect();
    }
    else if(type.equals("s")){
      s = new Square();
    }
    else {
      //s = null;
      throw new IllegalArgumentException();
    }
    return s;
  }

}

/* 1. 在每个类中增加一个函数Draw();
 * 2. 在基类中的Draw函数应为抽象函数；
 * 3. Draw() 函数在屏幕上输出当前对象的信息，例如半径，或者坐标/宽高等
 * 4. 在主函数中调用createObject创建一个对象，然后调用该对象的Draw()函数
 */
