package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 16409
 */
public class OracleJdbc {

  private static Connection connection = null;
  private static final String url = "jdbc:oracle:thin:@192.168.159.134:1521:orcl";
  private  static OracleJdbc INSTENCE;

  private OracleJdbc() {
    getConn();
  }
  //单例模式实现
  public static synchronized OracleJdbc getInstence() {

        if (INSTENCE == null) {
          INSTENCE = new OracleJdbc();
        }
        return INSTENCE;
    }

  //获取连接器
  public static synchronized Connection getConn() {
    if (connection == null) {

      try {
        /* In the past, it was required to load a JDBC driver before creating a java.sql.Connection.
         Nowadays, when using JDBC 4.0 drivers, this is no longer required and Class.forName() can be
         safely removed because JDBC 4.0 (JDK 6) drivers available in the classpath are automatically
          loaded.This rule raises an issue when Class.forName() is used with one of the following values:*/
        connection = DriverManager.getConnection(url, "scott", "12345");
      } catch (SQLException  e) {
        e.printStackTrace();
      }
    }
    if (connection == null) {
      throw new NullPointerException();
    }
    return connection;
  }

  //获取SQL代码结果
  public ResultSet query(String sql) {
    try {
      PreparedStatement preparedStatement = getConn().prepareStatement(sql);
      return preparedStatement.executeQuery();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public int update(String sql) {
    try {
      AtomicInteger tResultSet = new AtomicInteger();
      try (PreparedStatement preparedStatement = getConn().prepareStatement(sql)) {
          tResultSet.set(preparedStatement.executeUpdate());
      }
      return tResultSet.get();

    } catch (SQLException |NullPointerException e) {
      e.printStackTrace();
    }
    return 0;
  }

  public void close() {
    try {
      getConn().close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
