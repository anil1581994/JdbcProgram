package jdbcCurdOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveImage {
	
@SuppressWarnings("unused")
public static void main(String[] args) {
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	File file=null;
	try {
		 Class.forName("com.mysql.jdbc.Driver");
		 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB", "root", "root");
		 String query="select* from emp";
		 preparedStatement = connection.prepareStatement(query);
		 ResultSet rs=preparedStatement.executeQuery();  
		 if(rs.next())
		 {  //now  cursor on 1st row  
		               
		 Blob b=rs.getBlob(6);//6 means 6th column data  ..get binary lob
		 byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  ..convert blob  to byte array
		               
		 FileOutputStream fout=new FileOutputStream("/home/bridgeit/anil/UI(front-end)/images/imagelob");  
		 fout.write(barr);  
		               
		 fout.close();  
		 }//end of if  
		 System.out.println("ok");  
	} catch (ClassNotFoundException e) {
		
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
	}
}

}
