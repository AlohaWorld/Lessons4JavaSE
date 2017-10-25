package unit03;

public class Apple extends Fruit{
  /*
  public Apple() { 
    System.out.println("Apple's ctor is invoked"); 
  }
  */
  public static void main(String[] args) {
    Apple apple = new Apple();
    System.out.println("Apple created!");
  }
}

class Fruit {
  public Fruit(String name) {
    System.out.println("Fruit's constructor is invoked");
  }
}
