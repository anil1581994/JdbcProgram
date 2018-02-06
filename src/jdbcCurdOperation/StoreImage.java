package jdbcCurdOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//insert image in data base
public class StoreImage {
@SuppressWarnings({ "unused", "null" })
public static void main(String[] args) {
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	File file=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB", "root", "root");
		String query="update emp set image=? where empid=?";
		
		preparedStatement = connection.prepareStatement(query);
	
		FileInputStream inputStream = new FileInputStream(new File("/home/bridgeit/anil/UI(front-end)/images/jasmin.jpeg"));
	
		
		preparedStatement.setBinaryStream(1, inputStream, inputStream.available());
		preparedStatement.setInt(2,29);  
		
		int count =preparedStatement.executeUpdate();
		System.out.println("number of rows updated:-->"+count);
		
	} catch (ClassNotFoundException e) 
	{
		
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally
	{
        try
        {
        	
            if(preparedStatement != null)
               preparedStatement.close();
            if(connection != null) 
            	connection.close();
        } catch(Exception ex)
        {
        	
        }
   }

}
}
