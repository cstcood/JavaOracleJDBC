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
      System.out.println("1��ע���û�  2������  3������ﳵ");
      System.out.println("��������");
      if (!scanner.hasNextInt()) {
        System.out.println("�������");
        scanner.next();
        choice = 0;
        continue;
      } else {
        choice = scanner.nextInt();
        switch (choice) {
          case 1: {
            user = new User();
            System.out.println("����ע����û���");
            user.setUserName(scanner.next());
            System.out.println("����ע�������");
            user.setPassWord(scanner.next());
            user.setType(2);
            UserDaoImplement userDaoImplement = new UserDaoImplement();
            if (userDaoImplement.register(user)) {
              System.out.println("ע��ɹ�");
            } else {
              System.out.println("ע��ʧ��");
            }

          }
          break;
          case 2: {
            System.out.println("�����鼮���");
            int bookId = scanner.nextInt();
            System.out.println("���빺������");
            int bookNum = scanner.nextInt();
            if (shoppingDaoImplement.addbook(user, bookId, bookNum)) {
              System.out.println("����ɹ�");
            } else {
              System.out.println("����ʧ��");
            }

          }
          break;
          case 3:
            shoppingDaoImplement.showShoppigByUser(user);
            break;
          default:
            System.out.println("�������");
            break;
        }
      }
      System.out.println("�Ƿ��˳�  y/n");
      if ("y".equals(scanner.next())) {
        break;
      }
    } while (choice != -1);
  }
}
