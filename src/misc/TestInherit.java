package misc;
public class TestInherit {
  public static void main(String[] args) {
    Base circle1 = new Circle();            Base circle2 = new Circle();
    Circle trueCircle1 = new Circle();      Circle trueCircle2 = new Circle();
    //以下4个对e()函数的调用，都是在编译期就决定了
    System.out.println(circle1.e(circle2)); //调用Base.e()
    System.out.println(trueCircle1.e(trueCircle2));//调用Circle.e()
    System.out.println(circle1.e(trueCircle1)); //调用Base.e()，因为circle1是基类对象引用
    //下面代码调用base.e()，因为trueCircle1虽然是派生类对象引用，但其中也包含基类方法。
    //    编译器会检查e()参数circle1，发现是基类对象引用，因此选择trueCircle1中的基类方法e()
    System.out.println(trueCircle1.e(circle1)); 
  }
}

class Base {
  public boolean e(Base b) {
    return false;
  }
}
class Circle extends Base {
  int radius = 1;
  public boolean e(Circle circle) { //与基类e()函数形成Overload
    return this.radius == circle.radius;
  }
}