package com.shopping.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import com.book.dao.impl.BookDaoImplement;
import com.book.entity.Book;
import com.shopping.ShoppingDao;
import com.sql.OracleJdbc;
import com.user.entity.User;

/**
 * @author 16409
 */
public class ShoppingDaoImplement implements ShoppingDao {

  private OracleJdbc jdbc;
  private HashSet<String> order;


  //获取JDBC实例
  private void getJDBC() {
    jdbc = OracleJdbc.getInstence();
  }

  private void getOrderList() {
    if (order == null) {
      order = new HashSet<>();
    }
    order.clear();
    ResultSet result = jdbc.query("select * from shopping");
    try {
      while (result.next()) {
        order.add(result.getString("uname") + result.getString("bname"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean addbook(User user, int id, int num) {
    if (jdbc == null) {
      getJDBC();
    }
    BookDaoImplement bookDaoImplement = new BookDaoImplement();
    List<Book> booklist = bookDaoImplement.getbookList();
    getOrderList();
    String bookName = "";
    for (Book book : booklist) {
      if (book.getiD() == id) {
        bookName = book.getBookName();
      }
    }
    if ("".equals(bookName)) {
      return false;
    }
    if (!bookDaoImplement.buybook(id, num)) {
      return false; //数量不够
    }
    getOrderList();
    if (order.contains(user.getUserName() + bookName)) {
      return
          jdbc.update(String.format("update shopping set num=num+%d where Uname='%s' and Bname='%s'"
              , num, user.getUserName(), bookName
          )) > 0;
    }
    return jdbc.update(String.format("insert into shopping values(%d,'%s','%s'，%d)"
        , order.size() + 1, user.getUserName(), bookName, num
    )) > 0;
  }

  public void showShoppigByUser(User user) {
    if (jdbc == null) {
      getJDBC();
    }
    ResultSet result = jdbc
        .query(String.format("select * from shopping  where uname='%s'", user.getUserName()));
    try {
      while (result.next()) {
        System.out.printf("书籍名称 :%s 本数:%d %n", result.getString("bname"), result.getInt("num"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


}
