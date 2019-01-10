import java.util.Scanner;
import java.sql.*;
import java.util.*;


public class Bookstore {
	public static void main(String[] args) throws Exception {

		int count = 1;
		List list = new ArrayList();
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		
		System.out.println("Book Store");
		System.out.println();
		
		System.out.println("1. Add new book");
		System.out.println("2. Search book");
		System.out.println("3. Update book");
		System.out.println("4. Delete book");
		System.out.println("5. Exit");
		boolean quit = false;

		System.out.print("Please enter your choice: ");
		menu = scan.nextInt();
		System.out.println();
		
		
		try (
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore_db?useSSL=false", "myuser", "xxxxx");
								
								//Database URL: "jdbc:mysql: //hostname:port/databaseName", "username", "password"
			
			Statement statement = conn.createStatement();
		){
		
		switch (menu) {
		
		case 1:
			
			String strInsert = "insert into books" + "values (id, Title, Author, Qty)";
			System.out.println("The SQL query is:" + strInsert);
			int countInserted = statement.executeUpdate(strInsert);
			System.out.println(countInserted + " records inserted. \n");
		
		

		case 2:

			String strSelect = "select * from books";
			System.out.println("The SQL query is:" + strSelect);
			System.out.println();
			
			ResultSet resultSet = statement.executeQuery(strSelect);
			
			System.out.println("Records selected: are:");
			
			int rowCount = 0;
			
			while(resultSet.next()) {
				
				String title = resultSet.getString("Title");
				String author = resultSet.getString("Author");
				int id = resultSet.getInt ("id");
				int Qty = resultSet.getInt("Qty");
				
				System.out.println(title + ", " + author + ", " + id + ", " + Qty);
				++rowCount;	
			}
			System.out.println("Total number of records searched:" + rowCount + "\n");
		
			
			
		case 3:
			
			String strUpdate = "update books set id, Title, Author, Qty";
			System.out.println("The SQL query is:" + strUpdate);
			int countUpdated = statement.executeUpdate(strUpdate);
			System.out.println(countUpdated + " records updated \n");
			
			
		case 4:
			
			String strDelete = "delete from books where id, Title, Author, Qty; ";
			System.out.println("The SQL query is:" + strDelete);
			int countDeleted = statement.executeUpdate(strDelete);
			System.out.println(countDeleted + " records deleted \n");
			
		
		case 5:	
			
			System.exit(0);
			
			}
		} 
	}
}
