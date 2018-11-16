/**
 * 
 */
package unit01;

/**
 * @author cyd
 * @version 1.0
 */
public class ForDemo {

  /**
   * @param args
   * @author cyd
   * @date 2018年9月26日 上午11:19:18
   */
    public static void main(String[] args) {
    int arr[] = {1,3,5,7,9};
    int count = 0;
    for(int item: arr) {
      System.out.println(item);
      count ++ ;
    }
    System.out.println("Count is: " + count + 
        " "+(new Test9()).show());

  }
}

