package com.test;

import java.util.Scanner;
import java.util.logging.Logger;
import com.user.dao.impl.UserDaoImplement;
import com.user.entity.User;
import com.user.role.RoleJudge;

/**
 * @author 16409
 */
class Test {

  private static Scanner scanner;

  public static void main(final String[] args) {
    scanner = new Scanner(System.in);
    Logger logger = Logger.getLogger("SQL Thread");
    logger.info("thread is starting");
    UserDaoImplement userDaoImplement = new UserDaoImplement();
    System.out.println("请输入用户名");
    String userName = scanner.nextLine();
    System.out.println("请输入密码");
    String passWord = scanner.nextLine();
    User user = userDaoImplement.login(userName, passWord);
    if (user == null) {
      System.out.println("错误");
    } else {
      System.out.println("成功");
      user.outputInfo();
      RoleJudge roleJudge = new RoleJudge();
      roleJudge.judge(user);
    }
  }

}
