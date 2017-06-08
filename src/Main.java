

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
		public static void main(String[] args) {
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "select * from MCStudents";
			try{
				Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/MCDB", "root", "password");
				stmt = con.createStatement();
				PreparedStatement pstmt = con.prepareStatement("Delete from MCStudents WHERE Address = ?");
				pstmt.setString(1, "Quicken Loans Arena");
				
				/*pstmt = con.prepareStatement("Insert Into MCStudents (FirstName, LastName) values(?,?);");
				pstmt.setString(1, "Lebron");
				pstmt.setString(2, "James");*/
				pstmt.executeUpdate();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					System.out.print(rs.getString("StudentID") + "\t");
					System.out.print(rs.getString("FirstName") + "\t");
					System.out.print(rs.getString("LastName")+"\t");
					System.out.print(rs.getString("Address"));
					
					System.out.println();
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
			} finally {
				try {
					rs.close();
					stmt.close();
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}

		}
		
}
