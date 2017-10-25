package unit03;
// This example use classes defined in Faculty.java
public class ObjectToString {
  public static void main(String[] args){
    Faculty faculty = new Faculty();
    System.out.println("\n\n"+faculty.toString());
    System.out.println(faculty.getClass());
    System.out.println((new ObjectToString()).toString());
  }
}
