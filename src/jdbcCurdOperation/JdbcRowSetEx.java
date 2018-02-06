package jdbcCurdOperation;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetEx {
@SuppressWarnings("unused")
public static void main(String[] args) {
   try {
	Class.forName("com.mysql.jdbc.Driver");
	 JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
	 rowSet.setUrl("jdbc:mysql://localhost:3306/anil_DB");
	 rowSet.setUsername("root");
	 rowSet.setPassword("root");
	 rowSet.setCommand("select * from emp");
	 rowSet.execute();
	 System.out.println("Employee details in forward direction");
	 System.out.println("empid\tename\tsalary\tdeptNo\tprofile\timage");
	 System.out.println("................................................");
	 while(rowSet.next()) {
		 System.out.println(rowSet.getInt(1)+"\t"+rowSet.getString(2)+"\t"+rowSet.getInt(3)+"\t"+rowSet.getInt(4)+"\t"+rowSet.getString(5)+"\t"+rowSet.getBytes(6));
	 }
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
