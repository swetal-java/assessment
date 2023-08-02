package LibraryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class library {
	public static void main(String[] args)  {
		Connection connection = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Choice: ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1: 
			System.out.println("Register");
			System.out.print("Enter ID:");
			int id = sc.nextInt();
			System.out.print("Enter Name: ");
			String name =sc.next();
			System.out.print("Enter Contact: ");
			long contact = sc.nextLong();
			System.out.print("Enter Password: ");
			String password = sc.next();
		
			try {
				String databaseurl = "jdbc:mysql://localhost:3308/advancejava";
				String dbname = "root";
				String dbpassword = "";
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(databaseurl,dbname,dbpassword);
				
				if(connection != null) {
					PreparedStatement pStatement = connection.prepareStatement("insert into user (id,name,contact,password) values (?,?,?,?)");
					pStatement.setInt(1, id);
					pStatement.setString(2, name);
					pStatement.setLong(3, contact);
					pStatement.setString(4, password);
					pStatement.executeUpdate();
					System.out.println("Data is inserted..");
				}else {
					System.out.println("Connection is null");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2:
			System.out.println("---Login---");
			System.out.print("Enter Name: ");
			String lname =sc.next();
			System.out.print("Enter password: ");
			String lpassword = sc.next();
            try {
            	String databaseurl = "jdbc:mysql://localhost:3308/advancejava";
				String dbname = "root";
				String dbpassword = "";
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(databaseurl,dbname,dbpassword);
				if(connection != null) {
					PreparedStatement pStatement = connection.prepareStatement("select * from user where name= ? and password = ?");
					pStatement.setString(1, lname);
					pStatement.setString(2, lpassword);
					ResultSet rSet = pStatement.executeQuery();
					if(rSet.next()) {
						System.out.println("1. Add Books");
						System.out.println("2. Delete Books");
						System.out.println("3. Search Books");
						System.out.println("4. Edit Books");
						System.out.println("5. View Book List");
						System.out.println("6. Change Password");
						System.out.println("7. Close Application");
						
						System.out.print("Enter The Choice: ");
						int actionchoice = sc.nextInt();
						switch(actionchoice) {
						case 1 :
							System.out.println("1. Computers");
							System.out.println("2. Electronics");
							System.out.println("3. Electrical");
							System.out.println("4. Civil");
							System.out.println("5. Back to Menu");
							
							System.out.print("ENter choice for Book: ");
							int bookchoice = sc.nextInt();
							switch(bookchoice) {
							case 1: 
								System.out.print("Enter the category: ");
								String bcategory = sc.next();
								System.out.print("Enter Book Id: ");
								int bid = sc.nextInt();
								System.out.print("Enter Book Name: ");
								String bname = sc.next();
								System.out.print("Enter Author Name: ");
								String bauthor = sc.next();
								System.out.print("Enter book quantity: ");
								int bquantity = sc.nextInt();
								System.out.print("Enter the price: ");
								int bprice = sc.nextInt();
								
								try {
									String databaseurl1 = "jdbc:mysql://localhost:3308/advancejava";
									String dbname1 = "root";
									String dbpassword1 = "";
									Class.forName("com.mysql.cj.jdbc.Driver");
									connection = DriverManager.getConnection(databaseurl1,dbname1,dbpassword1);
									if(connection != null) {
										PreparedStatement pStatement1 = connection.prepareStatement("insert into book_tbl (bid,bname,bcategory,bauthor,bquantity,bprice) values (?,?,?,?,?,?)");
										pStatement1.setInt(1,bid);
										pStatement1.setString(2, bname);
										pStatement1.setString(3, bcategory);
										pStatement1.setString(4, bauthor);
										pStatement1.setInt(5, bquantity);
										pStatement1.setInt(6, bprice);
										pStatement1.executeUpdate();
										System.out.println("Book-Data is inserted..");
									}else {
										System.out.println("Connection is null");
									}
								} catch (Exception e) {
									// TODO: handle exception
									e.printStackTrace();
								}
							} 
						}
					}
				}
           } catch (Exception e) {
	          // TODO: handle exception
           }
		
		}
	}

}
