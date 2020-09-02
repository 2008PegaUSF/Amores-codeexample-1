package bankImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bankBeans.Admin;
import bankBeans.Customer;
import bankDAO.BankAdmin;
import bankUtils.BankConnect;

public class BankAdminImplement implements BankAdmin {

	public static BankConnect bc= BankConnect.getInstance();
	static Logger log = LogManager.getLogger(BankAdminImplement.class);
	
	
	public Admin getAdmin_UN(String U_NAME) throws SQLException {
		Connection cnn= bc.getConnection();
		String sql = "select * from \"AdminInfo\" where \"Username\"= ?";
		PreparedStatement ps = cnn.prepareStatement(sql);
		ps.setString(1,U_NAME);
		ResultSet rs = ps.executeQuery();
		Admin c = null;
		while(rs.next()) {
			c = new Admin(rs.getString(5),rs.getString(4),rs.getString(2),rs.getString(3));
		}
		return c;
	}

	@Override
	public void newCustomer(String L_NAME, String F_NAME, String U_NAME, String PW, float Acc1) throws SQLException {
		Connection cnn = cf.getConnection();
		String sql = "insert into \"CustomerInfo\" (\"Username\", \"PassWord\", \"Firstname\", \"Lastname\", \"Acc1\")  values(?,?,?,?)";
		PreparedStatement ps = cnn.prepareStatement(sql);
		ps.setString(1, U_NAME);
		ps.setString(2,PW);
		ps.setString(3,L_NAME);
		ps.setString(4, F_NAME);
		ps.setFloat (5, Acc1);
		ps.executeUpdate();
	}

	@Override
	public Customer viewCustomerUser(String U_NAME) throws SQLException {
		Connection cnn= cf.getConnection();
		String sql = "select * from \"CustomerInfo\" where \"Username\"= ?";
		PreparedStatement ps = cnn.prepareStatement(sql);
		ps.setString(1,U_NAME);
		ResultSet rs = ps.executeQuery();
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getString(5),rs.getString(4),rs.getString(2),rs.getString(3),rs.getFloat(6), rs.getFloat(7));
		}
		return c;
	}

	@Override
	public List<Customer> AllCustomers() throws SQLException {
		List<Customer> CustomerList=new ArrayList<Customer>();
		Connection cnn= cf.getConnection();
		Statement stmt= cnn.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from \"CustomerInfo\"");
		Customer a = null;
		while(rs.next()) {
			a = new Customer(rs.getString(5),rs.getString(4),rs.getString(2),rs.getString(3),rs.getFloat(6),rs.getFloat(7));
			CustomerList.add(a);
		}
		return CustomerList;
	}

	@Override
	public void updateInfoCustomer(Customer c, Scanner sc) throws SQLException {
		int decide;
		String F_NAME;
		String L_NAME;
		String U_NAME;
		String currentUN;
		String newUN;
		String UN_Pass;
		Connection cnn= cf.getConnection();
		
		System.out.println("What updates would you like to implement?"
				+ "\n(1) Change First Name\n(2) Change Last Name"
				+ "\n(3) Change Username \n(4) Change Password\n(0) To Exit for Customer Transactions");
		decide = sc.nextInt();
		switch(decide) {
		case 0:
			break;
		case 1:
			System.out.println("Update first name to....");
			F_NAME = sc.next();
			U_NAME = c.getUserName();
			String sql = "update \"CustomerInfo\" set \"Firstname\"=? where \"Username\" = ?";
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, F_NAME);
			ps.setString(2, U_NAME);
			ps.executeUpdate();	
			c.setFirstName(F_NAME);
			updateInfoCustomer(c,sc);
			break;
		case 2: 
			System.out.println("Update last name to.....");
			L_NAME = sc.next();
			U_NAME = c.getUserName();
			String sql2 = "update \"CustomerInfo\" set \"LastName\"=? where \"UserName\" = ?";
			PreparedStatement psl = cnn.prepareStatement(sql2);
			psl.setString(1, L_NAME);
			psl.setString(2, U_NAME);
			psl.executeUpdate();	
			c.setLastName(L_NAME);
			updateInfoCustomer(c,sc);
			break;
		case 3:
			System.out.println("Please update User name to......");
			newUN = sc.next();
			currentUN = c.getUserName();
			String sql3 = "update \"CustomerInfo\" set \"Username\"=? where \"Username\" = ?";
			PreparedStatement psU = cnn.prepareStatement(sql3);
			psU.setString(1, newUN);
			psU.setString(2, currentUN);
			psU.executeUpdate();	
			c.setUserName(newUN);
			updateInfoCustomer(c,sc);
			break;
		case 4:
			System.out.println("Pleas type in new password");
			UN_Pass = c.getUserName();
			String sql4 = "update \"CustomerInfo\" set \"PassWord\"=? where \"UserName\" = ?";
			PreparedStatement psp = cnn.prepareStatement(sql4);
			psp.setString(1, UN_Pass);
			psp.setString(2, UN_Pass);
			psp.executeUpdate();	
			c.setPassword(UN_Pass);
			updateInfoCustomer(c,sc);
			break;
		default:
			System.out.println("Please select which you'd like to change to");
			updateInfoCustomer(c,sc);
			break;
		}
		
	}
	
	public void updateTransactions(Customer customer, Scanner sc) {
		int decision;
		float DEP;
		float WIT;
		float Acc2;
		BankCustomerImplement CIP = new BankCustomerImplement();
		
		System.out.println("Opening transcactions log");
		System.out.println();
		System.out.println("Here's the User's Information: \n"+ customer.toString());
		System.out.println();
		System.out.println("(1) Deposit\n(2) Withdraw\n(3) Apply for a New Account\n(4) Delete an account *Account must be empty to DELETE\n(0) To Log Out");
		decision = sc.nextInt();
		
		switch(decision) {
		case 0: 
			System.out.println("Logging out....");
			break;
			
		case 1:
			System.out.println("Opening Deposit Portal");
			System.out.println("Please specify deposit amount....");
			DEP = sc.nextFloat();
			try {
				CIP.AccDeposit(customer,DEP,sc);
				System.out.println("Deposit of $" + DEP + "....transaction completed");
			} catch (SQLException e) {
				System.out.println("ERROR: Deposit FAILED.");
				e.printStackTrace();
			}
			updateTransactions(customer,sc);
			break;
			
		case 2:
			System.out.println("Opening Withdrawal Portal....");
			System.out.println("Please specify amount being withdrawn......");
			WIT = sc.nextFloat();
			try {
				CIP.AccWithdraw(customer, WIT,sc);
				System.out.println("Withdraw of $" + WIT + "....transaction completed.");
			} catch (SQLException e) {
				System.out.println("ERROR: Withdrawal FAILED");
				e.printStackTrace();
			}
			updateTransactions(customer,sc);
			break;
		case 3:
			System.out.println("Opening account creation portal:  ");
			try {
				System.out.println("Please set amount to deposit into new account: ");
				Acc2 = sc.nextFloat();					
				CIP.AccApply(customer,Acc2);
				System.out.println("Account generated");
			} catch (SQLException e1) {
				System.out.println("Account generation denied.");
				e1.printStackTrace();
			}
			updateTransactions(customer,sc);
			break;
		case 4:
			System.out.println("Account Deletion Portal: ");
			try {
				CIP.DELAcc(customer,sc);
			} catch (SQLException e) {
				System.out.println("ERROR: Account cannot be DELETED");
				e.printStackTrace();
			}
			updateTransactions(customer,sc);
			break;
			
		default:
			System.out.println("Please Select one of the Options");
			updateTransactions(customer,sc);
		}
	}
	

	@Override
	public void deleteALL(Scanner input) throws SQLException {
		int decide;
		String USERDEL;
		Connection cnn= cf.getConnection();
		
		System.out.println("(1) Do you want to send a single user or multiple users to the shadow realm? \n(2) Do you want to send all users to the shadow realm? \n(3) No one GOES to the SHADOW REALM....Today.");
		decide = input.nextInt();
		
		switch(decide) {
		case 1:
			System.out.println("Please give the username of the user you'd like to send to the shadow realm");
			USERDEL = input.next();
			String sql = "delete from \"CustomerInfo\" where \"UserName\" = ?";
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, USERDEL);
			ps.executeUpdate();	
			break;
		case 2:
			System.out.println("Send ALL USERS TO THE SHADOW REALM ? (Yes--> 1 / No--> 0)");
			decide = input.nextInt();
			if(decide == 1) {
				String sql2 = "truncate \"CustomerInfo\" cascade";
				PreparedStatement ps2 = cnn.prepareStatement(sql2);
				ps2.executeUpdate();	
			} else {
				System.out.println("Okay, you have been merciful today.");
			}
			break;
		case 3:
			System.out.println("Okay, you have been merciful today." + "\n" + "Good Job Lord Admin");
			break;
		}

			

	}
	
	
}
