package com.book.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import com.book.dao.BookDao;
import com.book.entity.Book;
import com.sql.OracleJdbc;

/**
 * @author 16409
 */


public class BookDaoImplement implements BookDao {


  private List<Book> bookList;
  private HashSet<Integer> bookId;
  private OracleJdbc jdbc;

  //��ȡJDBCʵ��
  private void getJDBC() {
    jdbc = OracleJdbc.getInstence();
  }

  //�����ݿ��ȡ�������list��
  private void getBook() {
    if (bookList == null || bookId == null) {
      bookList = new ArrayList<>();
      bookId = new HashSet<>();
    }
		if (jdbc == null) {
			getJDBC();
		}
    bookId.clear();
    bookList.clear();
    ResultSet result = jdbc.query("select * from book");
    try {
      while (result.next()) {
        Book book = new Book(result.getInt("ID"), result.getString("bname"),
            result.getString("author"), result.getInt("bprice")
            , result.getInt("num"));
        bookId.add(book.getiD());
        bookList.add(book);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void showBook() {
		if (bookList == null) {
			getBook();
		}
    bookList.sort(Comparator.comparingInt(Book::getiD));
    for (Book book : bookList) {
      book.outputInfo();
    }
  }

  @Override
  public void deleteBookByID(int ID) {
		if (jdbc == null) {
			getJDBC();
		}
		if (jdbc.update("delete from book where ID='" + ID + "'") >= 1) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
    getBook();
  }

  @Override
  public void addBook(Book book) {
		if (jdbc == null) {
			getJDBC();
		}
    book.outputInfo();
    if (bookId.contains(book.getiD())) {

      System.out.println("���ʧ�� �����ظ�");
      return;
    }
    if (jdbc.update("insert into book values(" +
        String.format("%d,'%s',%d,'%s',%d", book.getiD(), book.getBookName(), book.getPrice(),
            book.getAuthor(), book.getPrice()) + ")") > 0) {
      System.out.println("��ӳɹ�");
      bookId.add(book.getiD());
      bookList.add(book);
    }


  }

  @Override
  public void updateBook(Book book) {
		if (jdbc == null) {
			getJDBC();
		}
    getbookList();
    if (!bookId.contains(book.getiD())) {

      System.out.println("�޸�ʧ��û�м�¼ ");
      return;
    }
    if (jdbc.update(String.format(
        "update book set bname='%s',bprice=%d,author='%s',num=%d where id=%d"
        , book.getBookName(), book.getPrice(), book.getAuthor(), book.getNum(), book.getiD()))
        > 0) {

      System.out.println("�޸ĳɹ�");
      getBook();
    }
  }

  public List<Book> getbookList() {

		if (bookList == null) {
			getBook();
		}
    return bookList;
  }


  @Override
  public boolean buybook(int Id, int num) {
    ResultSet result = jdbc.query(String.format("select * from book where id=%d", Id));
    try {
      if (result.next()) {
        Book book = new Book(result.getInt("ID"), result.getString("bname"),
            result.getString("author"), result.getInt("bprice")
            , result.getInt("num"));
        if (book.getNum() > num) {
          return jdbc.update(String.format(
              "update book set num=num-%d where id=%d"
              , num, Id)) > 0;
        }
      }
      return false;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

}
