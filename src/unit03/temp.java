package unit03;

public class temp {

  public temp() {
    // TODO Auto-generated constructor stub
  }

}

public class Test {
  public static void main(String[] args) {
    new Person().printPerson();
    new Student().printPerson();
  }
}
class Student extends Person {
  private String getInfo() {
    return "Student";
  }
}
class Person {
  private String getInfo() {
    return "Person";
  }
  public void printPerson() {
    System.out.println(getInfo());
  }
}