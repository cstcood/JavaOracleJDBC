package com.user.role.op;

import java.util.Scanner;
import com.shopping.impl.ShoppingDaoImplement;
import com.user.dao.impl.UserDaoImplement;
import com.user.entity.User;

/**
 * @author 16409
 */
public class NormalOperation {

  private Scanner scanner = new Scanner(System.in);
  private User user;

  public NormalOperation(User user) {
    // TODO Auto-generated constructor stub
    this.user = user;
  }

  public void showMenu() {
    ShoppingDaoImplement shoppingDaoImplement = new ShoppingDaoImplement();
    int choice;
    do {
      System.out.println("1、注册用户  2、买书  3输出购物车");
      System.out.println("请输入编号");
      if (!scanner.hasNextInt()) {
        System.out.println("输入错误");
        scanner.next();
        choice = 0;
        continue;
      } else {
        choice = scanner.nextInt();
        switch (choice) {
          case 1: {
            user = new User();
            System.out.println("输入注册的用户名");
            user.setUserName(scanner.next());
            System.out.println("输入注册的密码");
            user.setPassWord(scanner.next());
            user.setType(2);
            UserDaoImplement userDaoImplement = new UserDaoImplement();
            if (userDaoImplement.register(user)) {
              System.out.println("注册成功");
            } else {
              System.out.println("注册失败");
            }

          }
          break;
          case 2: {
            System.out.println("输入书籍编号");
            int bookId = scanner.nextInt();
            System.out.println("输入购买数量");
            int bookNum = scanner.nextInt();
            if (shoppingDaoImplement.addbook(user, bookId, bookNum)) {
              System.out.println("购买成功");
            } else {
              System.out.println("购买失败");
            }

          }
          break;
          case 3:
            shoppingDaoImplement.showShoppigByUser(user);
            break;
          default:
            System.out.println("输入错误");
            break;
        }
      }
      System.out.println("是否退出  y/n");
      if ("y".equals(scanner.next())) {
        break;
      }
    } while (choice != -1);
  }
}
