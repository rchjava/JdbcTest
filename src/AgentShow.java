import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AgentShow {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection( 
				    "jdbc:mysql://localhost:3306/sqlpractise","root","root");
			int AgentID;
			System.out.println("enter the agent id");
			Scanner sc=new Scanner(System.in);
			AgentID = sc.nextInt();
			String cmd = "select*from agent where AgentID=?";
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setInt(1, AgentID);
			ResultSet rs = pst.executeQuery();
		if(rs.next()){
			System.out.println("AgentID raju :"+rs.getInt("AgentID"));
			System.out.println("FirstName"+rs.getString("FirstName"));
			System.out.println("MI"+rs.getString("MI"));
			System.out.println("FullName"+rs.getString("FullName"));
			System.out.println("Gender"+rs.getString("Gender"));
			System.out.println("Dob"+rs.getString("Dob"));
			System.out.println("SSN"+rs.getInt("SSN"));
		}else {
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
