/**
 * 
 */
package unit02;
// int* p = null
public class DemoP21 {
  private static int[] iArr = new int[10] ;
  private static double x;
  private static char c;
  /** Task 1
   * Show Object Reference and "null" literal value
   * Create a function ShowObjRef()
   */
  private static void ShowObjRef() {
    if (iArr == null) 
      System.out.println("null");
    else
      System.out.println("not null");
    //System.out.println(c);
  }
  /** Task 2
   * Show default value for
   * 1. reference type
   * 2. numeric type
   * 3. boolean type
   * 4. char type
   */
  public static void main(String[] args) {
    
    // Task 1: Call ShowObjRef()
    ShowObjRef();
    // Task 3: Call ObjTester.TestObjRef() w/o static modifier
    ObjTester ot = new ObjTester();
    ot.TestObjRef(iArr);

  }

}

/** Task 3:
 * 1. Create a package-local class ObjTester
 * 2. Create a method TestObjRef(Object objRef)
 */
class ObjTester {
  public void TestObjRef(Object objRef) {
    if(objRef == null)
      System.out.println("null objRef");
    else
      System.out.println("valid objRef");
  }
}
/** Task 4:
 * Variables of Primitive Data Types and Object Types
 */