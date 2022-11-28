package unit05;

public class Demo05P11 {
  public static void main(String[] args) {
    int dividend = 10;
    int divisor = 0;
    try {
      MyDivide d = new MyDivide(dividend, divisor);
      d.setDivisor(0);
      System.out.println(d.divide());
    } catch (ArithmeticException e) {
      System.out.println("异常类型是：" + e.getClass().getName());
      System.out.println("抓住ArithmeticExcepion一只");
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("异常类型是：" + e.getClass().getName());
      System.out.println("抓住Excepion一只");
      System.out.println(e.getMessage());
    }
  }
}


class MyDivide {
  private int divisor; // 除数
  private int dividend; // 被除数

  /**
   * @param divisor
   * @param divident
   */
  public MyDivide(int dividend, int divisor) {
    super();
    this.divisor = divisor;
    this.dividend = dividend;
  }


  public int getDivisor() {
    return divisor;
  }

  public void setDivisor(int divisor) throws Exception {
    if (divisor == 0) {
      throw (new Exception("不能将除数设置为0"));
    }
    this.divisor = divisor;
  }

  public int getDivident() {
    return dividend;
  }

  public void setDivident(int dividend) {
    this.dividend = dividend;
  }

  public int divide() throws ArithmeticException {
    if (0 == divisor) {
      ArithmeticException e = new ArithmeticException("除数是零，blahblah");
      throw e;
    } else
      return dividend / divisor;
  }
}
