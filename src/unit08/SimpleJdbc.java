package unit08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleJdbc {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    // Load the JDBC driver
    // Class.forName("com.mysql.jdbc.Driver"); // mysql 5.x
    Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 8.x
    System.out.println("Driver loaded");

    // Establish a connection
    String url5 = "jdbc:mysql://localhost/javabook";
    String url8 = "jdbc:mysql://localhost/javabook?useSSL=false";
    Connection connection = DriverManager.getConnection(url8, "scott", "tiger");
    System.out.println("Database connected");

    Thread t = new DBThread(connection);
    t.start();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Create a statement
    Statement statement = connection.createStatement();

    // Execute a statement
    ResultSet resultSet = statement.executeQuery
    // ("select firstName, mi, lastName from Student where lastName "
    // + " = 'Smith'");
    // ("select * from Student where lastName "
    // + " = 'Smith'");
    ("select * from Student");// where name = 'Adam'");

    // statement.execute
    // Iterate through the result and print the student names
    while (resultSet.next())
      System.out.println( /* resultSet.getString(0) + "\t" + */
          resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3)
              + "\t" + resultSet.getString(4) + "\t" + resultSet.getString(5));

    // Close the connection
    connection.close();
  }
}


class DBThread extends Thread {
  private Connection conn = null;

  DBThread(Connection conn) {
    this.conn = conn;
  }

  @Override
  public void run() {
    try {
      // Create a statement
      Statement statement = conn.createStatement();
      // Execute a statement
      statement.executeUpdate("update Course set " + "numOfCredits=4 where CourseId=44411119");
      // Execute a statement
      ResultSet resultSet = statement.executeQuery
      // ("select firstName, mi, lastName from Student where lastName "
      // + " = 'Smith'");

      ("select * from Course");
      // Iterate through the result and print the student names
      while (resultSet.next())
        System.out.println(
            resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3)
                + "\t" + resultSet.getString(4) + "\t" + resultSet.getString(5));

    } catch (SQLException e) {
      e.printStackTrace();
    }
    // Close the connection
  }
}
