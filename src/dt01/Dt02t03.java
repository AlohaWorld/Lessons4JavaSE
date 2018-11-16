package dt01;
import java.util.*;
public class Dt02t03 {

  public static void main(String[] args) {
    Calendar c1 = Calendar.getInstance();
    c1.set(1949, 10, 1);
    Calendar c2 = Calendar.getInstance();
    c2.set(2018, 10, 17);
    
    long m1 = c1.getTimeInMillis();
    long m2 = c2.getTimeInMillis();
    
    long m = Math.abs(m1-m2);
    long day = m/1000/60/60/24;
    System.out.println("1949.10.1  ~ 1970 :" + m1);
    System.out.println("2018.10.17 ~ 1970 :" + m2);
    System.out.println("Days in 1949.10.1~2018.10.17 :" + day);
  }
}
