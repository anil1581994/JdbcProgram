package jdbcCurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//purpose:to get specific record ResultSet Object by making it scrollable
@SuppressWarnings("unused")
public class ResultsetInterface {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB", "root", "root");
			@SuppressWarnings("unused")
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select * from emp");
			rs.absolute(4);
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
		} catch (ClassNotFoundException e) {

			System.out.println("class not found Exception");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
