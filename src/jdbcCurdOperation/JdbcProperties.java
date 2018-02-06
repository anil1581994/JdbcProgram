package jdbcCurdOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcProperties {
@SuppressWarnings({ "unused", "resource", "null" })
public static void main(String[] args) {
	Properties p=new Properties();
	Connection connection=null;
	FileInputStream fis=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	     fis=new FileInputStream("/home/bridgeit/Documents/AnilWorkSpace/JDBCApp1/src/jdbcCurdOperation/db.properties");
		p.load(fis);
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		 connection=DriverManager.getConnection(url, username, password);
		Statement stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from emp");
		System.out.println(".......Access your credentials from properties file...");
	   System.out.println("empid\tename\tsalary\tdeptNo\tprofile\timage");
		while(rs.next())
		{
	     System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getBytes(6));
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(connection==null)
			connection.close();
			if(fis==null)
				fis.close();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
