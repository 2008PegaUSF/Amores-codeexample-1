package bankDAO;

import java.sql.SQLException;
import java.util.Scanner;

import bankBeans.Customer;

public interface BankCustomer {
	
	//Get Customer from bank database
	public Customer getCustomer_UN(String username) throws SQLException;
	
	// Create Customer Login and Account Information
	public void CreateNewCustomer(String LastName,String FirstName,String userName,String password, float Acc1) throws SQLException;

	
	//Opens Account deposit portal
	public void AccDeposit(Customer c, float deposit, Scanner in) throws SQLException;
	
	//Opens Account withdrawal portal
	public void AccWithdraw(Customer c, float withdraw, Scanner in) throws SQLException;
	
	//Open Account creation portal
	public void AccApply(Customer c, float accountBalance) throws SQLException;
		
	//Opens Account deletion portal
	public void DELAcc(Customer c, Scanner in) throws SQLException;
	
}
