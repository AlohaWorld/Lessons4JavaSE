package dt02;

//如何修改程序，使得输出结果变为 After swap:i=1 j=0?
public class Parameters {
  public static void main(String[] args) {
    Parameters p = new Parameters();
    p.Hello();
  }
  
  public void Hello() {
    int i = 0, j =1;
    System.out.println("Before swap: "+"i="+i+" j="+j);
    
    swap(i, j);

    System.out.println("After swap: "+"i="+i+" j="+j);
  }
  
  void swap(int x, int y) {
    int t;
    t=x;
    x=y;
    y=t;
  }

}
