package unit08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// 导入sql包

public class Demo08P11 {

  public static void main(String[] args) throws Exception {
    // 加载mysql的jdbc驱动类到JVM中
    Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 5.x vs 8.x
    // 创建一个数据库Connection；注意：此处不使用new运算符
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javabook?useSSL=false",
        "scott", "tiger");
    // 创建一个 Statement；注意：此处不使用new运算符
    Statement st = conn.createStatement();
    // 执行一个查询，参数是一个SQL语句
    // 此处使用Statement中的方法；
    // 此处返回一个Resultset对象引用；
    // 查询内容1：从Student表中检索出姓氏为Smith的学生的名字、中间名和姓氏
    // 查询内容2：从Student表中检索出姓氏为Smith的学生的所有信息
    // 查询内容3：从Course表中检索所有的信息
    st.executeUpdate("update Course set numOfCredits = 5 where numOfCredits = 10");

    ResultSet rs = st.executeQuery("select * from Course;");



    // 使用一个循环，读取Resultset对象中的信息
    // 使用Resultset.next()移动结果集的光标并判断是否到尾部
    // 使用Resultset.getXXX()来获取一条记录中的某个字段信息
    int count = 0;
    while (rs.next()) {
      count++;
      System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
          + rs.getString(3) + " "
          + rs.getString(4) + " " + rs.getString(5));
    }
    System.out.println("Total records: " + count);

    ResultSet rsSum = st.executeQuery("select count(courseId) from Course;");
    while (rsSum.next()) {
      System.out.println("Total records: " + rsSum.getInt(1));
    }
    // 关闭数据库连接
    conn.close();
  }

}
