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
			System.out.println("1����ѯͼ��  2�����ͼ��  3���޸�ͼ��  4��ɾ��ͼ��");
			System.out.println("��������");
			if(scanner.hasNextInt() == false)
			{
				System.out.println("�������");
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
					System.out.println("����ID");
					newBook.setiD(scanner.nextInt());
					System.out.println("����");
					newBook.setBookName(scanner.next());
					System.out.println("����");
					newBook.setAuthor(scanner.next());
					System.out.println("�۸�");
					newBook.setPrice(scanner.nextInt());
					System.out.println("����");
					newBook.setNum(scanner.nextInt());
					bookDaoImplement.addBook(newBook);
					break;
					}
				case 3:{
					Book newBook= new Book();
					System.out.println("����ID");
					newBook.setiD(scanner.nextInt());
					System.out.println("����");
					newBook.setBookName(scanner.next());
					System.out.println("����");
					newBook.setAuthor(scanner.next());
					System.out.println("�۸�");
					newBook.setPrice(scanner.nextInt());
					System.out.println("����");
					newBook.setNum(scanner.nextInt());
					bookDaoImplement.updateBook(newBook);
					break;
				}
					
				case 4:{
						
						System.out.println("����Ҫɾ�����ID");
						bookDaoImplement.deleteBookByID(scanner.nextInt());
						break;
					}
					
				default:
					System.out.println("�������");
					break;
				}
			}
			System.out.println("�Ƿ��˳�  y/n");
			if(scanner.next().equals("y")) break;
		} while (choice!=-1);	
	}
}
