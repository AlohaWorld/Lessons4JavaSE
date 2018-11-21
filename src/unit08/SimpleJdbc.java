package unit08;

import java.sql.*;

public class SimpleJdbc {
  public static void main(String[] args)
      throws SQLException, ClassNotFoundException {
    // Load the JDBC driver
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver loaded");

    // Establish a connection
    Connection connection = DriverManager.getConnection
      ("jdbc:mysql://localhost/javabook?useSSL=false", "scott", "tiger");
    System.out.println("Database connected");

    Thread t = new DBThread(connection);
    t.start();
    
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // Create a statement
    Statement statement = connection.createStatement();

    // Execute a statement
    ResultSet resultSet = statement.executeQuery
//      ("select firstName, mi, lastName from Student where lastName "
//        + " = 'Smith'");
//        ("select * from Student where lastName "
//            + " = 'Smith'");
        ("select * from Course");

    // Iterate through the result and print the student names
    while (resultSet.next())
      System.out.println(resultSet.getString(1) + "\t" +
        resultSet.getString(2) + "\t" + resultSet.getString(3) +
        "\t" + resultSet.getString(4)  + "\t" + resultSet.getString(5));

    // Close the connection
    connection.close();
  }
}

class DBThread extends Thread {
  private Connection conn = null;
  DBThread(Connection conn) {
    this.conn = conn;
  }
  public void run() {
    try {
      // Create a statement
      Statement statement = conn.createStatement();
      // Execute a statement
      statement.executeUpdate("update Course set "
          + "numOfCredits=4 where CourseId=44411119");
      // Execute a statement
      ResultSet resultSet = statement.executeQuery
//        ("select firstName, mi, lastName from Student where lastName "
//          + " = 'Smith'");
//          ("select * from Student where lastName "
//              + " = 'Smith'");
          ("select * from Course");
      // Iterate through the result and print the student names
      while (resultSet.next())
        System.out.println(resultSet.getString(1) + "\t" +
          resultSet.getString(2) + "\t" + resultSet.getString(3) +
          "\t" + resultSet.getString(4)  + "\t" + resultSet.getString(5));

    } catch (SQLException e) {
      e.printStackTrace();
    }
    // Close the connection
  }
}