package unit04.swing;

public class TestInnerClass {
  InnerClass innerClass1 = new InnerClass(1);
  InnerClass innerClass2;

  public class InnerClass {
    InnerClass(int i) {
      System.out.println("Inner Class: "+i);
    }
  }
  public TestInnerClass() {
    innerClass2 = new InnerClass(2);
  }

  public static void main(String[] args) {
    TestInnerClass t = new TestInnerClass();
    innerClass2 = new InnerClass(4);
    @SuppressWarnings("unused")
    InnerClass innerClass3 = t.new InnerClass(3); //new InnerClass(3);
  }

}
