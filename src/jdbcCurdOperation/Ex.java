package jdbcCurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex {
	
		public static void main(String[] args) 
		{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB","root","root");
			String query="insert into emp values(?,?,?,?,?)";
		    PreparedStatement preparedstatement=connection.prepareStatement(query);
		    
		    Scanner scanner=new Scanner(System.in);
		    System.out.println("Enter id");
		    int empid=scanner.nextInt();
		    System.out.println("enter name");
		    String ename=scanner.next();
		    System.out.println("Enter salary");
		    int salary=scanner.nextInt();
		    System.out.println("enter deptNo");
		    int deptNo=scanner.nextInt();
		    System.out.println("enter profile");
		    String profile=scanner.next();
		    
		    preparedstatement.setInt(1,empid);
		    preparedstatement.setString(2,ename);
		    preparedstatement.setInt(3,salary);
		    preparedstatement.setInt(4,deptNo);
		    preparedstatement.setString(5,profile);
		    
		     int count=preparedstatement.executeUpdate(); 
		      
		    System.out.println("number records update in database:"+count);
		    connection.close();
			
		} catch (ClassNotFoundException e)
		{
			System.out.println("class not found please check driver class jar");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
		}

		
	}


