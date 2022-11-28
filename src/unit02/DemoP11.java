package unit02;

public class DemoP11 {

  public static void main(String[] args) {
    // 创建一个整型数组
    int[] arr = {1, 2, 3, 4, 5};

    DemoP11 d = new DemoP11();
    // 反转数组元素
    int[] arr2 = d.reverse(arr);
    // 打印原数组与反转后的数组
    d.print(arr);
    d.print(arr2);
    // 将reverse和print函数放到一个类中，创建这个类的对象，操纵数组

  }

  int[] reverse(int[] a) {
    int[] t = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      t[i] = a[a.length - i - 1];
    }
    return t;
  }

  void print(int[] a) {
    for (int i : a) {
      System.out.println(i);
    }
  }

}


// 创建一个类
class demo0 {
  // reverse函数

  // print函数；考虑使用基于范围的for循环
  public void print(int[] x) {}
}
