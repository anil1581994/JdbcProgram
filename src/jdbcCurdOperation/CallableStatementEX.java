package jdbcCurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementEX {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB", "root", "root");

		     java.sql.CallableStatement stmt = con.prepareCall("{call InsertUsers(?,?)}");
			stmt.setInt(1,445);
			stmt.setString(2,"mishra");
			stmt.setInt(3,0);
			stmt.execute();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		System.out.println("success");

	}
}
