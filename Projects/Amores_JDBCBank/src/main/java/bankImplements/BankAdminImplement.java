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
	
	
	public Admin getAdmin_UN(String username) throws SQLException {
		Connection cnn= bc.getConnection();
		String sql = "select * from \"AdminInfo\" where \"Username\"= ?";
		PreparedStatement ps = cnn.prepareStatement(sql);
		ps.setString(1,username);
		ResultSet rs = ps.executeQuery();
		Admin c = null;
		while(rs.next()) {
			c = new Admin(rs.getString(5),rs.getString(4),rs.getString(2),rs.getString(3));
		}
		return c;
	}

	@Override
	public void newCustomer(String LastName, String FirstName, String userName, String password, float acc1) throws SQLException {
		Connection cnn = cf.getConnection();
		String sql = "insert into \"CustomerInfo\" (\"Username\", \"PassWord\", \"Firstname\", \"Lastname\", \"Acc1\")  values(?,?,?,?)";
		PreparedStatement ps = cnn.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2,password);
		ps.setString(3,LastName);
		ps.setString(4, FirstName);
		ps.setFloat (5, acc1);
		ps.executeUpdate();
	}

	@Override
	public Customer viewCustomerUser(String username) throws SQLException {
		Connection cnn= cf.getConnection();
		String sql = "select * from \"CustomerInfo\" where \"Username\"= ?";
		PreparedStatement ps = cnn.prepareStatement(sql);
		ps.setString(1,username);
		ResultSet rs = ps.executeQuery();
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getString(5),rs.getString(4),rs.getString(2),rs.getString(3),rs.getFloat(6), rs.getFloat(7));
		}
		return c;
	}

	@Override
	public List<Customer> AllCustomers() throws SQLException {
		List<Customer> custList=new ArrayList<Customer>();
		Connection cnn= cf.getConnection();
		Statement stmt= cnn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from \"CustomerInfo\"");
		Customer a = null;
		while(rs.next()) {
			a = new Customer(rs.getString(5),rs.getString(4),rs.getString(2),rs.getString(3),rs.getFloat(6),rs.getFloat(7));
			custList.add(a);
		}
		return custList;
	}

	@Override
	public void updateInfoCustomer(Customer c, Scanner sc) throws SQLException {
		Connection conn= cf.getConnection();
		System.out.println("What updates would you like to implement?"
				+ "\n(1) Change First Name\n(2) Change Last Name"
				+ "\n(3) Change Username \n(4) Change Password\n(0) To Exit for Customer Transactions");
		int decide = sc.nextInt();
		switch(decide) {
		case 0:
			break;
		case 1:
			System.out.println("Update first name to....");
			String fname = sc.next();
			String username = c.getUserName();
			String sql = "update \"CustomerInfo\" set \"Firstname\"=? where \"Username\" = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, username);
			ps.executeUpdate();	
			c.setFirstName(fname);
			updateInfoCustomer(c,sc);
			break;
		case 2: 
			System.out.println("Update last name to.....");
			String newLN = sc.next();
			String newUN = c.getUserName();
			String sql2 = "update \"CustomerInfo\" set \"LastName\"=? where \"UserName\" = ?";
			PreparedStatement psl = conn.prepareStatement(sql2);
			psl.setString(1, newLN);
			psl.setString(2, newUN);
			psl.executeUpdate();	
			c.setLastName(newLN);
			updateInfoCustomer(c,sc);
			break;
		case 3:
			System.out.println("Please update User name to......");
			String Uname = sc.next();
			String u_n = c.getUserName();
			String sql3 = "update \"CustomerInfo\" set \"Username\"=? where \"Username\" = ?";
			PreparedStatement psU = conn.prepareStatement(sql3);
			psU.setString(1, Uname);
			psU.setString(2, u_n);
			psU.executeUpdate();	
			c.setUserName(Uname);
			updateInfoCustomer(c,sc);
			break;
		case 4:
			System.out.println("Pleas type in new password");
			String UN_Pass = c.getUserName();
			String sql4 = "update \"CustomerInfo\" set \"PassWord\"=? where \"UserName\" = ?";
			PreparedStatement psp = conn.prepareStatement(sql4);
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
		BankCustomerImplement custImp = new BankCustomerImplement();
		System.out.println("Opening transcactions log");
		System.out.println();
		System.out.println("Here's the User's Information: \n"+ customer.toString());
		System.out.println();
		System.out.println("(1) Deposit\n(2) Withdraw\n(3) Apply for a New Account\n(4) Delete an account *Account must be empty to DELETE\n(0) To Log Out");
		int decision = sc.nextInt();
		switch(decision) {
		case 0: 
			System.out.println("Logging out....");
			break;
		case 1:
			System.out.println("Opening Deposit Portal");
			System.out.println("Please specify deposit amount....");
			float deposit = sc.nextFloat();
			try {
				custImp.AccDeposit(customer,deposit,sc);
				System.out.println("Deposit of $" + deposit + "....transaction completed");
			} catch (SQLException e) {
				System.out.println("ERROR: Deposit FAILED.");
				e.printStackTrace();
			}
			updateTransactions(customer,sc);
			break;
		case 2:
			System.out.println("Opening Withdrawal Portal....");
			System.out.println("Please specify amount being withdrawn......");
			float withdraw = sc.nextFloat();
			try {
				custImp.AccWithdraw(customer, withdraw,sc);
				System.out.println("Withdraw of $" + withdraw + "....transaction completed.");
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
				float account2 = sc.nextFloat();					
				custImp.AccApply(customer,account2);
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
				custImp.DELAcc(customer,sc);
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
		Connection conn= cf.getConnection();
		System.out.println("(1) Do you want to send a single user or multiple users to the shadow realm? \n(2) Do you want to send all users to the shadow realm? \n(3) No one GOES to the SHADOW REALM....Today.");
		int decide = input.nextInt();
		switch(decide) {
		case 1:
			System.out.println("Please give the username of the user you'd like to send to the shadow realm");
			String userDelete = input.next();
			String sql = "delete from \"CustomerInfo\" where \"UserName\" = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userDelete);
			ps.executeUpdate();	
			break;
		case 2:
			System.out.println("Send ALL USERS TO THE SHADOW REALM ? (Yes--> 1 / No--> 0)");
			int decision = input.nextInt();
			if(decision == 1) {
				String sql2 = "truncate \"CustomerInfo\" cascade";
				PreparedStatement ps2 = conn.prepareStatement(sql2);
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
