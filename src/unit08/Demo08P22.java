package unit08;

import java.sql.*;

public class Demo08P22 {
  public void main(String[] args) throws Exception {
    // 加载mysql的jdbc驱动类到JVM中
    // 使用Class.forname()；参数为mysql数据库的驱动的类的名字
    // 为了调试代码，可将jdbc驱动名字输出到控制台
    String mysqlDriverName = "com.mysql.jdbc.Driver";
    Class.forName(mysqlDriverName);
    System.out.println(mysqlDriverName + " loaded");

    // 创建一个数据库Connection；注意：此处不使用new运算符
    // 使用DriverManager类中的静态方法getXXX
    // 该方法的第一个参数是数据库的路径url
    String mysqlUrl = "jdbc:mysql://localhost/javabook?useSSL=false";
    Connection connection = DriverManager.getConnection(mysqlUrl, "scott", "tiger");
    System.out.println(mysqlUrl + " has connected");

    // 创建一个 Statement；注意：此处不使用new运算符
    // 调用Connection中的createXXX方法创建
    Statement statement = connection.createStatement();

    // 执行一个查询，参数是一个包含SQL语句的字符串
    // 此处使用Statement中的executeXXX方法；
    // 此处返回一个Resultset对象引用；
    ResultSet resultSet = statement.executeQuery("select * from Course");

    // 使用一个循环，读取Resultset对象中的信息
    // 使用Resultset.next()移动结果集的光标并判断是否到尾部
    // 使用Resultset.getXXX()来获取一条记录中的每个字段
    // getXXX()函数的参数是字段的编号，从1开始
    while (resultSet.next())
      System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t"
          + resultSet.getString(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getString(5));

    // 创建UpdateThread线程对象，传递合适的参数并启动之

    // 主线程睡一会儿

    // 关闭数据库连接
    connection.close();
    Integer x = 3;
    x++;
  }
}


/**
 * 编写一个线程类UpdateThread，执行数据库更新操作
 */
class UpdateThread {
  // 通过构造函数，获取一个已有的数据库连接

  // Override run方法


  // 重用已有的数据库连接，创建一个 Statement；

  // 执行一个Update SQL语句
  // 将某个课程的学分改为6学分

  // 执行查询语句，将Course表中的信息检索出来

  // 读取并显示结果集中的信息
}
