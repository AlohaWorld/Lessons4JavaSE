package unit02;

public class DemoP13 {

  public static void main(String[] args) {
    // Task 1: Create an double array1 with new
    double[] a = new double[10];
    // for(double j : a)
    for (int i = 0; i < a.length; i++) {
      a[i] = Math.random();
    }
    /* Task 2: Create an double array2 with inline initialization;
     */
    double[] b = {1.1, 2.2, 3.3, 4.4};
    /* Task 3: What will happen if you try separating the array definition 
     * and the initialization expression?
     */

    // Task 2: Output array2's length
    print(a);
    System.out.println("b's length : " + b.length);
    print(b);

    // Task 4: Can we change the array size?
    // b.length = 10;
    // Task 2: Modify the elements, w/o length

    // Task 4: What will happen when exceeding the array boundary?
  }

  static void print(double[] x) {
    for (double i : x) {
      System.out.print(" " + i);
    }
    System.out.print("\n");
  }
}
