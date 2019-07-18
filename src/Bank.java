import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bank {
	
	private int accountNo;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private int amount;
	private String cheqFacil;
	private String accountType;
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCheqFacil() {
		return cheqFacil;
	}
	public void setCheqFacil(String cheqFacil) {
		this.cheqFacil = cheqFacil;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
    Connection con;
    PreparedStatement pst;

	
	public int generateAccountNo() {
		con=ConnectionHelper.getConnection();
		try {
			pst=con.prepareStatement("select case when max(accountNo) is NULL THEN 1 " +
					" else MAX(AccountNo)+1 END accno from Accounts");
			ResultSet rs=pst.executeQuery();
			rs.next();
			int accountNo=rs.getInt("accno");
			return accountNo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	
	public String createAccount(Bank objBank){
		con=ConnectionHelper.getConnection();
		String cmd="insert into Accounts(AccountNo,FirstName,LastName,City,State,Amount," +
				"Cheqfacil,AccountType) values(?,?,?,?,?,?,?,?)";
		try {
			pst=con.prepareStatement(cmd);
			pst.setInt(1,objBank.getAccountNo());
			pst.setString(2,objBank.getFirstName()); 
			pst.setString(3,objBank.getLastName()); 
			pst.setString(4,objBank.getCity());
			pst.setString(5,objBank.getState()) ;
			pst.setInt(6,objBank.getAmount());
			pst.setString(7,objBank.getCheqFacil());
			pst.setString(8,objBank.getAccountType());
			pst.executeUpdate();
			return "Account Created...";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public ResultSet searchAccount(int accountNo){
		con=ConnectionHelper.getConnection();
		String cmd="select * from Accounts where AccountNo=?";
		try {
			pst=con.prepareStatement(cmd);
			pst.setInt(1,accountNo);
			ResultSet rs=pst.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

}
