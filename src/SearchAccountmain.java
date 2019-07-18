import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchAccountmain {

	
	public static void main(String[] args) {
		int accountNo;
		System.out.println("Enter AccountNo  ");
		Scanner scr=new Scanner(System.in);
		accountNo=scr.nextInt();
		Bank objBank=new Bank();
		ResultSet rs=objBank.searchAccount(accountNo);
		try {
			if(rs.next()){
				System.out.println("First Name " +rs.getString("FirstName"));
				System.out.println("Last Name " +rs.getString("LastName"));
				System.out.println("City " +rs.getString("City"));
				System.out.println("State " +rs.getString("State"));
				System.out.println("Amount " +rs.getString("Amount"));
				System.out.println("CheqFacil " +rs.getString("Cheqfacil"));
			}
			else {
				System.out.println("Record Not Found...!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
