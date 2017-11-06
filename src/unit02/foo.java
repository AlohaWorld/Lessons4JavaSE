package unit02;
// This file is for syntax highlighting
class JavaClass { //a local class, 同一个包中的类可见，其他包中不能用import导入。

//final class JavaClass {
	//...
}

public class foo { //在所有类中可见，在其他包中可以用import导入
	//@SuppressWarnings("unused")
   public static int x;
	public static void main(String[] args) {
	  int i=0;
	  JavaClass jClass = new JavaClass();
	  System.out.println("JavaClass has been created");
	  System.out.println("x="+x+" i="+i);
	}
}