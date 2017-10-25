package dt01;

public class TestArray {
  //定义一个数组a
  private int[] a = new int[10];
  int i = 100;
  public static void main(String[] args) {
    //创建一个 TestArray的对象t
    TestArray t = new TestArray();
    //通过t对象调用printArray()
    t.printArray();
    System.out.println(t.i);
  } 
  //构造函数，初始化数组a为 1...10
  public TestArray() {
 //   a = new int[10];
    // 用循环语句，初始化数组a
    for(int i=0; i<a.length; i++) {
      a[i] = i+1;
    }
  }
  
  //定义printArray(可能有参数) 函数，输出数组a的元素
  public void printArray() {
    //用循环语句，逐个输出数组a的元素
    for(int i=0; i<a.length; i++) {
      System.out.println(a[i]);
    }
  }
}


