package jdbcCurdOperation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatement1 
{
 public static void main(String[] args) 
      {
	 
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB", "root", "root");  
		CallableStatement cstmt=con.prepareCall("{call selectfromemp}");  
		ResultSet resultSet = cstmt.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getString(2));
			
		}
		/*cstmt.setInt(1,112);  
		cstmt.setString(2,"akhil");  
		cstmt.execute();  
	cstmt.execute();*/
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	} catch (SQLException e) {
	
		e.printStackTrace();
	}  
	
	  
	System.out.println("success");  
	
    }  
}



