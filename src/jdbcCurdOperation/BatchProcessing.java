package jdbcCurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessing {
	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB", "root", "root");
			stmt = connection.createStatement();
			stmt.addBatch("insert into Users values(456,'raj',5678)");
			stmt.addBatch("update Users set salary=9696 where id=111");
			stmt.addBatch("delete from Users where salary<4000");

			int count[] = stmt.executeBatch();
			int updateCount = 0;
			for (int x : count) {
				updateCount = updateCount + x;
			}
			System.out.println("Total number of record update in database:" + updateCount);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
