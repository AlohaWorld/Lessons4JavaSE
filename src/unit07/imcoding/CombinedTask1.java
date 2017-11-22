package unit07.imcoding;

import java.io.IOException;

public class CombinedTask1 {
  public static void main(String[] args) throws InterruptedException, IOException {
    int i = 0; 
    int j = 0;
    while(true) {
      System.out.print((char)('a'+i));
      System.out.print(" ");
      Thread.sleep(50);
      i++;
      if(i==26) {
        System.out.print("\n");
        i=0;
      }
      
      System.out.print(j++ +" ");
      
      if(j%20 == 0)
        System.out.print("\n");
      
      if(System.in.available() > 0) {
        System.exit(0);
      }
    }
  }
}
