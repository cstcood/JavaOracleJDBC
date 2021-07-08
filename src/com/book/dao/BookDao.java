package com.book.dao;

import com.book.entity.Book;

/**
 * @author 16409
 */
public interface BookDao {

  /**
   * print the information of book to the console
   * @return void
   */
  void showBook();

  /**
   * delete the information of book from database
   * @param ID the id of the deleted books
   * @return void
   */
  void deleteBookByID(int ID);

  /**
   * add the information of book to database
   * @param book the added books
   * @return void
   */
  void addBook(Book book);


  /**
   * update the information of book from database
   * @param book the updated books
   * @return void
   */
  void updateBook(Book book);

  /**
   * normal user buy the specify book lead to the deducing of the book
   * @param Id the id of updated books
   * @param num the number of the bought books
   * @return boolean
   */
  boolean buybook(int Id, int num);
}
