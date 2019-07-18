import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpSearch {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection( 
				    "jdbc:mysql://localhost:3306/sqlpractise","root","root");
			int empno;
			System.out.println("enter emply num");
			Scanner sc=new Scanner(System.in);
			empno = sc.nextInt();
			String cmd ="select * from emp where empno=?";
			PreparedStatement pst =con.prepareStatement(cmd);
			pst.setInt(1, empno);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				System.out.println("name"+rs.getString("name"));
				System.out.println("dept"+rs.getString("dept"));
				System.out.println("design"+rs.getString("desig"));
				System.out.println("basic"+rs.getInt("basic"));
			} else {
				System.out.println("record not found");
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
