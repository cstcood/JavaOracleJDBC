package com.user.entity;

import java.util.logging.Logger;

/**
 * @author 16409
 */
public class User {

  private int id;
  private String userName;
  private String passWord;
  private int type;


  public User(int id, String userName, String passWord, int type) {
    this.id = id;
    this.userName = userName;
    this.passWord = passWord;
    this.type = type;
  }
  //create the Construction with no attribute
  //return with the type identify with function


  public User() {

  }

  public final int getType() {
    return type;
  }

  public final void setType(int type) {
    this.type = type;
  }

  public final int getId() {
    return id;
  }

  public final void setId(int id) {
    if (id < 0) {
      id *= -1;
    }
    this.id = id;
  }

  public final String getUserName() {
    return userName;
  }

  public final void setUserName(String userName) {
    this.userName = userName;
  }

  public final String getPassWord() {
    return passWord;
  }

  public final void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public final void outputInfo() {

    Logger logger = Logger.getLogger("Login");
    logger.severe(String
        .format("ID: %d userName: %s passWord: %s type: %d%n", this.getId(), this.getUserName(),
            this.getPassWord(), getId()));
  }
}
