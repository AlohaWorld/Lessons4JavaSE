package unit02;

public class DemoP12 {
  private static int[][] a = {
      {1,2,3},
      {4,5,6},
      {7,8},
      {9}
  };
  
  public static void main(String[] args) {
    System.out.println(a.length);

    a[3][1] = 100;
    for(int i = 0 ; i < a.length; i++) {
      System.out.print("length:"+a[i].length+" ");
      for(int j:a[i]) {
        System.out.print(j + ",");
      }
      System.out.println("");
    }
  }
}
