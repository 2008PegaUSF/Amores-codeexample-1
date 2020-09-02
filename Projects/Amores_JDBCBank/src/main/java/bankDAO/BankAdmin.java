package bankDAO;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import bankBeans.Admin;
import bankBeans.Customer;
import bankUtils.BankConnect;

public interface BankAdmin {
	
	public static BankConnect cf= BankConnect.getInstance();
	
	public Admin getAdmin_UN(String username) throws SQLException;
	
	public void newCustomer(String LastName,String FirstName,String userName,String password, float acc1) throws SQLException;
	
	// View User's account information
	
	/*	user information
	 *  names associated with the account
	 *  balance information
	 */
	
	public Customer viewCustomerUser(String username) throws SQLException;
	
	public List<Customer> AllCustomers() throws SQLException;
	
	// Updating a User's Account
	
	/* 
	 * Deposit/Withdraw from account
	 * Apply for new Account
	 * Delete an Account for User (NOT Delete all Users)
	 */
	
	public void updateInfoCustomer(Customer c, Scanner sc) throws SQLException;
	
	// Delete ALL Accounts in the Bank
	public void deleteALL(Scanner input) throws SQLException;
}
