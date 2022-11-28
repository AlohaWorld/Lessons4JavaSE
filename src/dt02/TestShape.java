package dt02;

import java.util.Scanner;

/**
 * @author cyd
 * @version 1.0.1
 */
public class TestShape {
  /**
   * 
   * @param args
   * @author cyd
   * @date 2021年9月15日 上午10:31:02
   */
  public static void main(String[] args) {
    // Create one circle and one rect
    // 提示用户请用户输入要创建的对象类型；
    // 调用下面的函数创建对象
    System.out.println("Please input 1(Circle), 2(Rect):");
    Scanner in = new Scanner(System.in);
    int type = in.nextInt();
    Shape s = createShape(type);
    // 输出该对象的信息（调用对象的toString()获取对象信息）
    System.out.println(s.toString());
  }

  // 写一个函数，根据函数参数 type，创建对象
  // type值为1， 创建一个圆；
  // type值为2， 创建一个矩形
  public static Shape createShape(int type) {
    Shape s;
    if (type == 1) {
      s = new Circle();
    } else if (type == 2) {
      s = new Rect();
    } else
      s = new Shape();
    return s;
  }
}


class Shape {
  @Override
  public String toString() {
    return "Shape";
  }
}


class Rect extends Shape {
  @Override
  public String toString() {
    return "Rect";
  }
}


class Circle extends Shape {
  @Override
  public String toString() {
    return "Circle";
  }
}
