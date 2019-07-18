import java.util.Scanner;

public class CreateAccountmain {

	public static void main(String[] args) {
		
		Bank objBank=new Bank();
		objBank.setAccountNo(objBank.generateAccountNo());
		//System.out.println(objBank.generateAccountNo());
		System.out.println("Enter FirstName, LastName, City, State, Amount, CheqFacil and " +
				"Account Type ");
		Scanner scr=new Scanner(System.in);
		objBank.setFirstName(scr.nextLine());
		objBank.setLastName(scr.nextLine());
		objBank.setCity(scr.nextLine());
		objBank.setState(scr.nextLine());
		objBank.setAmount(Integer.parseInt(scr.nextLine())); 
		objBank.setCheqFacil(scr.nextLine());
		objBank.setAccountType(scr.nextLine());
		System.out.println(objBank.createAccount(objBank));
	}
}
