package bankImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bankBeans.Customer;
import bankDAO.BankCustomer;
import bankUtils.BankConnect;

public class BankCustomerImplement implements BankCustomer {

	public static BankConnect cf= BankConnect.getInstance();
	static Logger log = LogManager.getLogger(BankCustomerImplement.class);

	@Override
	public Customer getCustomer_UN(String U_Name) throws SQLException {
		Connection cnn= cf.getConnection();
		String sql = "select * from \"CustomerInfo\" where \"Username\"= ?";
		PreparedStatement ps = cnn.prepareStatement(sql);
		ps.setString(1,U_Name);
		ResultSet rs = ps.executeQuery();
		Customer current = null;
		while(rs.next()) {
			current = new Customer(rs.getString(5),rs.getString(4),rs.getString(2),rs.getString(3),rs.getFloat(6), rs.getFloat(7));
		}
		return current;
	}

	@Override
	public void CreateNewCustomer(String L_Name, String F_Name, String U_Name, String Password, float Acc1) throws SQLException {
		Connection cnn = cf.getConnection();
		String sql = "insert into \"CustomerInfo\" (\"Username\", \"PassWord\", \"Lastname\", \"Firstname\", \"Acc1\")   values(?,?,?,?,?)";
		PreparedStatement ps = cnn.prepareStatement(sql);
		ps.setString(1, U_Name);
		ps.setString(2,Password);
		ps.setString(3,L_Name);
		ps.setString(4, F_Name);
		ps.setFloat(5, Acc1);
		ps.executeUpdate();
		
	}

	@Override
	public void AccDeposit(Customer c, float deposit, Scanner in) throws SQLException {
		Connection conn = cf.getConnection();
		String user = c.getUserName();
		float Account2 = c.getAccount2();
		if(Account2 > 0.0) {
			System.out.println("Please select account...."
					+ "\n(1) Account 1\n(2) Account 2");
			int decision = in.nextInt();
			switch(decision) {
			case 1: 
				float OB = c.getAccount1();
				float UpdatedBalance = DepositIntoAcc(OB, deposit);
				c.setAccount1(UpdatedBalance);
				String sql = "update \"CustomerInfo\" set \"Acc1\"=? where \"Username\" = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setFloat(1, UpdatedBalance);
				ps.setString(2, user);
				ps.executeUpdate();
				break;
			case 2:
				float OBalance2 = c.getAccount2();
				float UBalance2 = DepositIntoAcc(OBalance2, deposit);
				c.setAccount2(UBalance2);
				String sql2 = "update \"CustomerInfo\" set \"Acc2\"=? where \"Username\" = ?";
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setFloat(1, UBalance2);
				ps2.setString(2, user);
				ps2.executeUpdate();
				break;
			default:
				System.out.println("Please choose which account to deposit into.");
				AccDeposit(c,deposit,in);
				break;
			}
		} else {
			float OBalance = c.getAccount1();
			float UBalance = DepositIntoAcc(OBalance, deposit);
			c.setAccount1(UBalance);
			String sql = "update \"CustomerInfo\" set \"Acc1\"=? where \"Username\" = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setFloat(1, UBalance);
			ps.setString(2, user);
			ps.executeUpdate();
		}
	}
	
	public float DepositIntoAcc(float Obalance, float deposit) {
		if( deposit < 0) { //if amount given is less than 0 then balance does not change.
			return Obalance;
		}
		float BalanceUpdated = deposit + Obalance;
		return BalanceUpdated;
		
	}

	@Override
	public void AccWithdraw(Customer c, float withdraw, Scanner input) throws SQLException {
		Connection cnn = cf.getConnection();
		String user = c.getUserName();
		float Account2 = c.getAccount2();
		if(Account2 > 0.0) {
			System.out.println("Please choose which account to access: "
					+ "\n(1) Account 1\n(2) Account 2");
			int decision = input.nextInt();
			switch(decision) {
			case 1: 
				float OBalance = c.getAccount1();
				float UBalance = WithdrawOutofAcc(OBalance, withdraw);
				c.setAccount1(UBalance);
				String sql = "update \"CustomerInfo\" set \"Acc1\"=? where \"Username\" = ?";
				PreparedStatement ps = cnn.prepareStatement(sql);
				ps.setFloat(1, UBalance);
				ps.setString(2, user);
				ps.executeUpdate();
				break;
			case 2:
				float OBalance2 = c.getAccount2();
				float UBalance2 = WithdrawOutofAcc(OBalance2, withdraw);
				c.setAccount2(UBalance2);
				String sql2 = "update \"CustomerInfo\" set \"Acc2\"=? where \"Username\" = ?";
				PreparedStatement ps2 = cnn.prepareStatement(sql2);
				ps2.setFloat(1, UBalance2);
				ps2.setString(2, user);
				ps2.executeUpdate();
				break;
			default:
				System.out.println("Please choose which account to withdraw from.");
				AccWithdraw(c,withdraw,input);
				break;
			}
		} else {
			float OBalance = c.getAccount1();
			float UBalance = WithdrawOutofAcc(OBalance, withdraw);
			c.setAccount1(UBalance);
			String sql = "update \"CustomerInfo\" set \"Acc1\"=? where \"Username\" = ?";
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setFloat(1, UBalance);
			ps.setString(2, user);
			ps.executeUpdate();
		}
	}
	
	public float WithdrawOutofAcc(float balance, float withdraw) {
		if(withdraw > balance) {
			System.out.println("OVERDRAFT ERROR: can not complete due to inefficient funds");
			return balance;
		}
		float UpBalance = balance - withdraw;
		return UpBalance;
	}
		


	@Override
	public void AccApply(Customer c, float AccBalance) throws SQLException {
		Connection conn = cf.getConnection();
		String user = c.getUserName();
		float balance = c.getAccount2();
		float AccBalance1 = c.getAccount1();
		if( balance == 0.0) { // if account 1 was deleted and wants to reopen again
			String sql = "update \"CustomerInfo\" set \"Acc2\"=? where \"Username\" = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setFloat(1, balance);
			ps.setString(2, user);
			ps.executeUpdate();		
			c.setAccount2(AccBalance);
		} else if (balance > 0.0 && AccBalance1 > 0.0) {
			System.out.println("ERROR: CANNOT open more than 2 accounts at this time.");
		}
	}
	
	@Override
	public void DELAcc(Customer c, Scanner in) throws SQLException {
		Connection cnn = cf.getConnection();
		String User = c.getUserName();
		float balance = c.getAccount1();
		float balanceCheck = c.getAccount2();
		
		if(balance > 0.0 && balanceCheck > 0.0) { // Allows transfer of money from a deleted account
			System.out.println("Please choose an account to be deleted\n*Note: Only EMPTY Accounts can be deleted."
				+ "\n Action will be done automatically."
				+ "\n(1) Account 1: $" + c.getAccount1()+ "\n(2) Account 2: $" + c.getAccount2() 
				+ "\n(3)Don't delete anything");
			int decide = in.nextInt();
			switch(decide) {
			case 1: 
				// transfer funds from one account to another before account deletion
				String sql = "update \"CustomerInfo\" set \"Acc1\"=? where \"Username\" = ?";
				PreparedStatement ps = cnn.prepareStatement(sql);
				float newbalance = balance + balanceCheck;
				ps.setFloat(1, newbalance);
				ps.setString(2, User);
				ps.executeUpdate();	
				
				String sql2 = "update \"CustomerInfo\" set \"Acc2\"=null where \"Username\" = ?";
				PreparedStatement ps2 = cnn.prepareStatement(sql2);
				ps2.setString(1, User);
				ps2.executeUpdate();	
				c.setAccount1(newbalance);
				c.setAccount2(0);
				System.out.println("Account updated.\n Account 1 is now primary account.");
				break;
			case 2: //Vice versa 
				String sql3 = "update \"CustomerInfo\" set \"Acc1\"=? where \"Username\" = ?";
				PreparedStatement ps3 = cnn.prepareStatement(sql3);
				float newbalance3 = balance + balanceCheck;
				ps3.setFloat(1, newbalance3);
				ps3.setString(2, User);
				ps3.executeUpdate();	
				
				String sql4 = "update \"CustomerInfo\" set \"Acc1\"=null where \"Username\" = ?";
				PreparedStatement ps4 = cnn.prepareStatement(sql4);
				ps4.setString(1, User);
				ps4.executeUpdate();
				c.setAccount1(newbalance3);
				c.setAccount2(0);
				System.out.println("Requested Action completed.\nAccount 1 deleted, account 2 is now set to primary");
				break;
			case 3:
				System.out.println("Account Deletion portal closing...");
				break;
			default: 
				System.out.println("Select an account to delete/update.");
				break;
			}
		} else if(balance > 0.0 && balanceCheck == 0.0) { // when only one account is opened 
				System.out.println("ERROR: Primary account CANNOT be DELETED. Please withdraw all funds from account in order to process.");
		}
		
	}
		

	
	

}
