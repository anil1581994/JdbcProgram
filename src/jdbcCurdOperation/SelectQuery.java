package jdbcCurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		String query = "select * from emp";
		try {
			// register driver class..1
			Class.forName("com.mysql.jdbc.Driver");
			// create connection object..2
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB", "root", "root");
			// create statement object...3
			stmt = con.createStatement();
			// Execute query....4
			ResultSet rs = stmt.executeQuery(query);
			// process the  Resultset object...5
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " "
						+ rs.getString(5));

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}
}