package dt03;

import java.util.Arrays;
import java.util.Stack;
// template <typename T, class E>
// class MyClass{
// }
//top, push, pop, empty
public class MyStack {
  public static void main(String[] args) throws Exception {
    Stack<String> s1 = new Stack<String>();
    s1.push("Hello");
    s1.push("Kitty");
    System.out.println("Top: " + s1.peek());
    System.out.println("Size: " + s1.size());

    S s = new S();
    s.push(s.push(3)+1);
    System.out.println(s.push(5));
    System.out.println("");
    System.out.print(s.toString());
    s.pop();
    s.pop();
    s.pop();
    s.pop();
  }
}

class S {
  private int[] arr = null;
  private int size = 0; //push,pop
  private int capacity = 0;
  private final int limit = 100;
  public S() {
    arr = new int[limit];
    capacity = limit;
  }
  
  private void enlarge() {
    int[] temp = arr;
    // 创建一个大数组，将原数组内容拷贝过去
    // arr = Arrays.copyOf(temp, temp.length+limit); //创建加大拷贝
    arr = new int [temp.length + limit];
    for(int i =0; i< temp.length; i++) {
      arr[i] = temp[i];
    }
    capacity = arr.length;
    temp = null;
  }
  public int push(int elem) {
    if(size == capacity)
      enlarge();
    arr[size++] = elem;
    return elem;
  }
  public int pop() throws Exception {
    if(size == 0)
      throw new Exception("No element in stack!");
    int temp = arr[size-1];
    size --;
    return temp;
  }
  public String toString() {
    String s = "";
    for(int i = size-1; i>0; i--)
      s = s + String.valueOf(arr[i]) +"\n";
    s += arr[0];
    return s;
  }
}