package unit05;

public class AssertionDemo {
  public static void main(String[] args) {
    int i;
    int sum = 0;
    for (i = 0; i < 10; i++) {
      sum += i;
    }

    // When an assertions is true, nothing happens.
    assert i == 10; // i equals 10
    assert sum < 10 && sum < 5 * 10 : "sum is " + sum;

    System.out.println("i=" + i + " sum=" + sum);
  }
}

/**
 * Eclipse中开启断言(Assert),方法有二:
 * 1.Run -> Run Configurations -> Arguments页签 -> VM arguments
 *   文本框中加上断言开启的标志:-enableassertions 或者-ea 就可以了
 * 2.在myEclipse中,Windows -> Preferences ->Java ->Installed JREs ->
 *   点击正使用的JDK ->Edit ->Default VM Arguments文本框中输入:-ea
 */
