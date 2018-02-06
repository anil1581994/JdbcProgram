package jdbcCurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultsetMetaData1 {
@SuppressWarnings("unused")
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB","root","root");
		String query="select * from emp";
		PreparedStatement prepareStatement=connection.prepareStatement(query);
		ResultSet rs=prepareStatement.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		System.out.println("Total numbe of column:"+rsmd.getColumnCount());
		System.out.println("column name 1 index:"+rsmd.getColumnCount());
		System.out.println("data type 3rd column:"+rsmd.getColumnType(3));
         System.out.println("table name of column:"+rsmd.getTableName(3));
         connection.close();
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
