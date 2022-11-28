package unit02;

public class DemoP24 {

  /* Task 1
   * 1. Create a SimpleCircle class
   * 2. Use a static member to count the instances
   * 3. In main(), create some instances, output the number of the instances
   */

  /* Task 2
   * In main()
   * 1. Create an array of Object (SimpleCircle)
   * 2. Print each circle's area by calling SimpleCircle's member "getArea()"
   * 3. Print the number of the instances of SimpleCircle
   */

  /* Task 3
   * 1. Implement finalize()
   * 2. Modify the codes in main() to set all object reference to null and call gc()
   */
  public static void main(String[] args) {

    // gc
    for (int i = 0; i < ca.length; i++) {
      ca[i] = null;
      System.gc();
    }

  }

}
