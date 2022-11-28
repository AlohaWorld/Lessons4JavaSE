/**
 * 
 */
package unit02;

public class DemoP21 {
  // Create an int array with new
  static int[] x = new int[5];
  static int[] y;

  /**
   * Task 1 Show Object Reference and "null" literal value Create a function ShowObjRef()
   */
  private static void ShowObjRef() {
    int[] z = null;
    System.out.println("array x: " + x);
    System.out.println("array y: " + y);
    System.out.println("array z: " + z);
  }

  /**
   * Task 2 Show default value for 1) reference type 2) numeric type 3) boolean type 4) char type
   */
  public static void main(String[] args) {

    // Task 1: Call ShowObjRef()
    ShowObjRef();

    // Task 3: Call ObjTester.TestObjRef() w/o static modifier
    ObjTester o = new ObjTester();
    int[] p = null;
    System.out.println(o.TestObjRef(p));
  }
}


/* Task 3: 
 * 1. Create a package-local class ObjTester 
 * 2. Create a method TestObjRef(Object objRef) 判断objRef是否为空
 */
class ObjTester {
  public boolean TestObjRef(Object objRef) {
    return objRef == null;
  }
}
/**
 * Task 4: Variables of Primitive Data Types and Object Types
 */
