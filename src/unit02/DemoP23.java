/**
 * 
 */
package unit02;

public class DemoP23 {

  /** Task 1
   * Create an array of Object (SimpleCircle)
   * Try finding what are in the array
   *   1. Call element's method
   *   2. Using eclipse debug view to show variables
   */
  /** Task 2
   * Implement finalize()
   * Set all Object Reference to null
   * Call gc()
   */
  public static void main(String[] args) {
    CircleWithStaticMembers [] ca = new CircleWithStaticMembers[5];
    for(int i = 0; i < ca.length; i++) {
      ca[i] = new CircleWithStaticMembers(i+1);
      System.out.println(ca[i].getNumberOfObjects());
    }
    for(CircleWithStaticMembers c : ca) {
      System.out.println(c.getArea());
      System.out.println(c.getNumberOfObjects());
    }
    // gc
    for(int i = 0; i < ca.length; i++) {
      ca[i] = null;
      System.gc();
    }
    
  }

}
