package com.book.entity;


/**
 * @author 16409
 */
public class Book {

  private int iD;
  private String bookName;
  private String author;
  private int price;
  private int num;

  public Book(int iD, String bookName, String author, int price, int num) {
    this.iD = iD;
    this.bookName = bookName;
    this.author = author;
    this.price = price;
    this.num = num;
  }

  public Book() {

  }

  public int getiD() {
    return iD;
  }

  public void setiD(int iD) {
    this.iD = iD;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public final void outputInfo() {
    System.out.printf("ID:%d bookName:%s author:%s price:%d number:%d %n", this.getiD(),
        this.getBookName(), this.getAuthor(), this.getPrice(),
        this.getNum());
  }


}
