package jdbcCurdOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionManagements {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil_DB", "root", "root");
			connection.setAutoCommit(false);
			PreparedStatement pst=connection.prepareStatement("insert into Users values(?,?,?)");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true){  
				  
				System.out.println("enter id");  
				String s1=br.readLine();  
				int id=Integer.parseInt(s1);  
				  
				System.out.println("enter name");  
				String name=br.readLine();  
				  
				System.out.println("enter salary");  
				String s3=br.readLine();  
				int salary=Integer.parseInt(s3);  
				  
				pst.setInt(1,id);  
				pst.setString(2,name);  
				pst.setInt(3,salary);  
				pst.executeUpdate();  
				  
				System.out.println("commit/rollback");  
				String answer=br.readLine();  
				if(answer.equals("commit"))
				{  
					connection.commit();  
				}  
				if(answer.equals("rollback")){  
					connection.rollback();  
				}  
				  
				  
				System.out.println("Want to add more records y/n");  
				String ans=br.readLine();  
				if(ans.equals("n")){  
				break;  
				}  
				  
				}  //while

             connection.commit();  
              System.out.println("record successfully saved");  
              connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
