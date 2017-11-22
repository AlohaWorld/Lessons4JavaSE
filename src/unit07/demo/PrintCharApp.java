package unit07.demo;

import java.io.IOException;

public class PrintCharApp {

  public static void main(String[] args) {
    PrintChar pc = new PrintChar();

  }

}


class PrintChar {
  public PrintChar() {
    for (int j = 0; j < 100; j++) {
      for (int i = 0; i < 26; i++) {
        System.out.print((char) ('a' + i) + " ");
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
        try {
          if(System.in.available()>0) {
            System.exit(0);
          }
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      System.out.print("\n");
    }
  }
}
