

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Main {
	static Scanner sc;
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
		public static void main(String[] args) {
			sc = new Scanner(System.in);
			
			String sql = "select * from MCStudents";
			try{
				Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/MCDB", "root", "password");
				stmt = con.createStatement();
				/*PreparedStatement pstmt = con.prepareStatement("Delete from MCStudents WHERE Address = ?");
				pstmt.setString(1, "Quicken Loans Arena");
				
					pstmt = con.prepareStatement("Insert Into MCStudents (FirstName, LastName) values(?,?);");
				pstmt.setString(1, "Lebron");
				pstmt.setString(2, "James");
				pstmt.executeUpdate();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					System.out.print(rs.getString("StudentID") + "\t");
					System.out.print(rs.getString("FirstName") + "\t");
					System.out.print(rs.getString("LastName")+"\t");
					System.out.print(rs.getString("Address"));
					
					System.out.println();
				}*/
				delete();
				}catch (SQLException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
			} finally {
				try {
					stmt.close();
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}

		}
		public static void select(){
			boolean whereFlag = false;
			String query = "select * from MCStudents";
			System.out.println("Enter StudentID");
			String iD = sc.nextLine();
			System.out.println("Enter FirstName");
			String fN = sc.nextLine();
			System.out.println("Enter LastName");
			String lN = sc.nextLine();
			
			if (!iD.equals("")){
				query += (whereFlag)? " And ": " Where ";
				whereFlag = true;
				query += "StudentID = " + iD;				
			}
			if (!fN.equals("")){
				query += (whereFlag)? " And ": " Where ";
				whereFlag = true;
				query += "FirstName = " + "\"" + fN+ "\"";				
			}
			if (!lN.equals("")){
				query += (whereFlag)? " And ": " Where ";
				whereFlag = true;
				query += "LastName = " + "\"" + lN + "\"";				
			}
			System.out.println(query);
			try {
				rs = stmt.executeQuery(query);
				while(rs.next()){
					System.out.print(rs.getString("StudentID") + "\t");
					System.out.print(rs.getString("FirstName") + "\t");
					System.out.print(rs.getString("LastName")+"\t");
					System.out.print(rs.getString("Address"));
					
					System.out.println();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

		}
		
		public static void delete(){
			boolean whereFlag = false;
			String query = "Delete from MCStudents";
			System.out.println("Enter StudentID");
			String iD = sc.nextLine();
			System.out.println("Enter FirstName");
			String fN = sc.nextLine();
			System.out.println("Enter LastName");
			String lN = sc.nextLine();
			
			if (!iD.equals("")){
				query += (whereFlag)? " And ": " Where ";
				whereFlag = true;
				query += "StudentID = " + iD;				
			}
			if (!fN.equals("")){
				query += (whereFlag)? " And ": " Where ";
				whereFlag = true;
				query += "FirstName = " + "\"" + fN+ "\"";				
			}
			if (!lN.equals("")){
				query += (whereFlag)? " And ": " Where ";
				whereFlag = true;
				query += "LastName = " + "\"" + lN + "\"";				
			}
			System.out.println(query);
			try {
				stmt.execute(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

		}
}
