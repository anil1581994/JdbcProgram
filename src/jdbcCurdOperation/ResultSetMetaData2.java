package jdbcCurdOperation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ResultSetMetaData2 {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		@SuppressWarnings("unused")
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB","root","root");
		DatabaseMetaData dbmd=connection.getMetaData();  
		  
		System.out.println("Driver Name: "+dbmd.getDriverName());  
		System.out.println("Driver Version: "+dbmd.getDriverVersion());  
		System.out.println("UserName: "+dbmd.getUserName());  
		System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
		System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
	      connection.close(); 
		  
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
