package bankDAO;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import bankBeans.Admin;
import bankBeans.Customer;
import bankUtils.BankConnect;

public interface BankAdmin {
	
	public static BankConnect cf= BankConnect.getInstance();
	
	public Admin getAdmin_UN(String U_NAME) throws SQLException;
	
	public void newCustomer(String L_NAME,String F_NAME,String U_NAME,String PW, float Acc1) throws SQLException;
	

	public Customer viewCustomerUser(String U_NAME) throws SQLException;
	
	public List<Customer> AllCustomers() throws SQLException;
	
	
	public void updateInfoCustomer(Customer c, Scanner sc) throws SQLException;
	
	// Delete ALL Accounts in the Bank
	public void deleteALL(Scanner input) throws SQLException;
}
