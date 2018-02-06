package jdbcCurdOperation;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DeleteQuery {
@SuppressWarnings("unused")
public static void main(String[] args) {
	try {
		  Class.forName("com.mysql.jdbc.Driver");
		  
		  Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB","root","root");
		  Statement stmt=(Statement) connection.createStatement();
		  String query="delete from emp where empid=4";
		  int result=stmt.executeUpdate(query);
		  System.out.println(result+":record is deleted from the table & updated");	
	}
	catch (ClassNotFoundException e)
	{
		
		e.printStackTrace();
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
}
}
