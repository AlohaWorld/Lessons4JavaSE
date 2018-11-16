package unit02;

public class DemoP11 {
 
  public static void main(String[] args) {
    int[] c = {0,1,2,3,4};
    demo0 d = new demo0();
    int[] z = d.reverse(c);
    d.print(z);
    d.print(c);

  }
}

class demo0 {
  //private int[] a = {0,1,2,3,4,5};
  int[] reverse(int[] x) {
    for(int i =0;i < x.length/2; i++) {
      int t = x[i];
      x[i] = x[x.length-i-1]; //?
      x[x.length-i-1] = t;
    }
    return x;
  }
  public void print(int[] x) {
    for(int i : x) {
        System.out.println(i);
    }
  }
}