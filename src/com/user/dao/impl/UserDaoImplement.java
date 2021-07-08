package com.user.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import com.sql.OracleJdbc;
import com.tool.DecodeTools;
import com.user.dao.UserDao;
import com.user.entity.User;

/**
 * @author 16409
 */
public class UserDaoImplement implements UserDao {

  private HashSet<String> UserSet;
  private OracleJdbc oJdbc = OracleJdbc.getInstence();


  public final void getUser() {

    if (oJdbc == null) {
      oJdbc = OracleJdbc.getInstence();
    }
    if (UserSet == null) {
      UserSet = new HashSet<>();
    }
    UserSet.clear();
    ResultSet reslut = oJdbc.query("select * from user1");
    try {
      while (reslut.next()) {
        UserSet.add(reslut.getString("uname"));

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public final User login(final String userName, final String passWord) {
    if (oJdbc == null) {
      oJdbc = OracleJdbc.getInstence();
    }
    String passWordDecode;
    passWordDecode = DecodeTools.getMd5Str(passWord);
    try (ResultSet reslut = oJdbc.query(
        "select * from user1 where uname='" + userName + "' and upwd='" + passWordDecode + "'")) {
      try {
        if (reslut.next()) {
          return new User(reslut.getInt("ID"), reslut.getString("uname"), reslut.getString("upwd"),
              reslut.getInt("type"));
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }

  public final Boolean register(User user) {
    if (oJdbc == null) {
      oJdbc = OracleJdbc.getInstence();
    }
    getUser();
    if (UserSet.contains(user.getUserName())) {
      return false;
    }
    return (oJdbc.update(
        String.format("insert into user1 values(%d,'%s','%s',%d)",
            UserSet.size() + 1, user.getUserName(), DecodeTools.getMd5Str(user.getPassWord()),
            user.getType())) > 0);


  }


}
