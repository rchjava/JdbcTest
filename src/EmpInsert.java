import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpInsert {
	
	public static void main(String[] args) {
		int empno,basic;
		String name,dept,desig;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter emply number");
		empno = Integer.parseInt(sc.nextLine());
		System.out.println("enter name");
		name = sc.nextLine();
		System.out.println("enter department ");
		dept = sc.nextLine();
		System.out.println("enter designination");
		desig = sc.nextLine();
		System.out.println("enter basic");
		basic = Integer.parseInt(sc.nextLine());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection( 
				    "jdbc:mysql://localhost:3306/sqlpractise","root","root");
			String cmd = "Insert into emp values(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(cmd);
			pst.setInt(1,empno);
			pst.setString(2,name);
			pst.setString(3, dept);
			pst.setString(4,desig);
			pst.setInt(5, basic);
			pst.executeUpdate();
			System.out.println("record inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		
	}

}
