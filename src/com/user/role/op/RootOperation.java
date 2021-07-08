package com.user.role.op;
import java.util.Scanner;
import com.book.dao.impl.BookDaoImplement;
import com.book.entity.Book;
import com.user.entity.User;

public class RootOperation {
	User user;
	public RootOperation(User user) {
		this.user=user;
		// TODO Auto-generated constructor stub
	}
	private Scanner scanner=new Scanner(System.in);
	public void showMenu() {
		BookDaoImplement bookDaoImplement=new BookDaoImplement();
		int choice=-1;
		do {	
			System.out.println("1、查询图书  2、添加图书  3、修改图书  4、删除图书");
			System.out.println("请输入编号");
			if(scanner.hasNextInt() == false)
			{
				System.out.println("输入错误");
				scanner.next();
				choice=0;
				continue;
			}else{
				choice= scanner.nextInt();
				switch (choice) {
				case 1 : 
					bookDaoImplement.showBook();
					break;
				case 2:{
					Book newBook= new Book();
					System.out.println("输入ID");
					newBook.setiD(scanner.nextInt());
					System.out.println("书名");
					newBook.setBookName(scanner.next());
					System.out.println("作者");
					newBook.setAuthor(scanner.next());
					System.out.println("价格");
					newBook.setPrice(scanner.nextInt());
					System.out.println("数量");
					newBook.setNum(scanner.nextInt());
					bookDaoImplement.addBook(newBook);
					break;
					}
				case 3:{
					Book newBook= new Book();
					System.out.println("输入ID");
					newBook.setiD(scanner.nextInt());
					System.out.println("书名");
					newBook.setBookName(scanner.next());
					System.out.println("作者");
					newBook.setAuthor(scanner.next());
					System.out.println("价格");
					newBook.setPrice(scanner.nextInt());
					System.out.println("数量");
					newBook.setNum(scanner.nextInt());
					bookDaoImplement.updateBook(newBook);
					break;
				}
					
				case 4:{
						
						System.out.println("输入要删除书的ID");
						bookDaoImplement.deleteBookByID(scanner.nextInt());
						break;
					}
					
				default:
					System.out.println("输入错误");
					break;
				}
			}
			System.out.println("是否退出  y/n");
			if(scanner.next().equals("y")) break;
		} while (choice!=-1);	
	}
}
