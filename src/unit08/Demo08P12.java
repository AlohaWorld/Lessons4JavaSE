package unit08;

// 导入sql包

public class Demo08P12 {

  public static void main(String[] args) {
    // 加载mysql的jdbc驱动类到JVM中
    //    使用Class.forname()；参数为mysql数据库的驱动的类的名字
    //    为了调试代码，可将jdbc驱动名字输出到控制台
    
    // 创建一个数据库Connection；注意：此处不使用new运算符
    //    使用DriverManager类中的静态方法getXXX
    //    该方法的第一个参数是数据库的路径url
    
    // 创建一个 Statement；注意：此处不使用new运算符
    //    调用Connection中的createXXX方法创建
    
    // 执行一个查询，参数是一个SQL语句
    //    此处使用Statement中的方法；
    //    此处返回一个Resultset对象引用；
    // 查询内容1：从Student表中检索出姓氏为Smith的学生的名字、中间名和姓氏
    // 查询内容2：从Student表中检索出姓氏为Smith的学生的所有信息
    // 查询内容3：从Course表中检索所有的信息
    
    // 使用一个循环，读取Resultset对象中的信息
    //    使用Resultset.next()移动结果集的光标并判断是否到尾部
    //    使用Resultset.getXXX()来获取一条记录中的每个字段
    //    getXXX()函数的参数是字段的编号，从1开始
    
    // 关闭数据库连接
  }

}
