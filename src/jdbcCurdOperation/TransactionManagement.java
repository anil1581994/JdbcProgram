package jdbcCurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionManagement {
@SuppressWarnings({ "unused", "resource" })
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB","root","root");
		Statement stmt=connection.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from Users");
		System.out.println(".....Before Transaction......");
		System.out.println("................................");
		System.out.println("id\t name\t salary");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
		}
		
		//connection.setAutoCommit(false);//change default behavior of commit
		stmt.executeUpdate("update Users set salary=1099 where id=111");
		stmt.executeUpdate("update Users set salary=10500 where id=222");
		System.out.println("Do you want Commit your transaction[yes/no]");
		Scanner scanner=new Scanner(System.in);
		String choice=scanner.next();
		if(choice.equals("yes"))
		{
			connection.commit();
			System.out.println("your Transaction is commited");
			
		}else
		{
			connection.rollback();
			System.out.println("Your transaction is cancelled");
		}
		System.out.println("....after Transaction.....");
		System.out.println(".............................");
		//ResultSet rs1=stmt.executeQuery("select * from Users");
		System.out.println("id\t name\t salary");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+""+rs.getDouble(3));
		}
		connection.close();
	} catch (SQLException | ClassNotFoundException e) {
		
		e.printStackTrace();
	}
}
}
