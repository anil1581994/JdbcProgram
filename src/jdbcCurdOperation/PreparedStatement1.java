package jdbcCurdOperation;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;


//purpose:use same query for multiple times and compile once
public class PreparedStatement1 {
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB","root","root");
		String query="insert into emp values(?,?,?,?,?)";
	    PreparedStatement preparedstatement=connection.prepareStatement(query);
	   
	    preparedstatement.setInt(1,8);
	    preparedstatement.setString(2, "imran");
	    preparedstatement.setInt(3,7999);
	    preparedstatement.setInt(4,50);
	    preparedstatement.setString(5,"Blockchain");
	   
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
