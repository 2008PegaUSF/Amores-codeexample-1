package bankDAO;

import java.sql.SQLException;
import java.util.Scanner;

import bankBeans.Customer;

public interface BankCustomer {
	
	//Get Customer from bank database
	public Customer getCustomer_UN(String U_NAME) throws SQLException;
	
	// Create Customer Login and Account Information
	public void CreateNewCustomer(String L_NAME,String F_NAME,String U_NAME,String PW, float Acc1) throws SQLException;

	
	//Opens Account deposit portal
	public void AccDeposit(Customer c, float DEP, Scanner in) throws SQLException;
	
	//Opens Account withdrawal portal
	public void AccWithdraw(Customer c, float WIT, Scanner in) throws SQLException;
	
	//Open Account creation portal
	public void AccApply(Customer c, float AB) throws SQLException;
		
	//Opens Account deletion portal
	public void DELAcc(Customer c, Scanner in) throws SQLException;
	
}
