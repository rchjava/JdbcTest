import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpShow {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection( 
					 
				    "jdbc:mysql://localhost:3306/sqlpractise","root","root");

					
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from Emp");

					rs.next();

					String name = rs.getString("name");

					System.out.println(name);
					st.close();
					con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
