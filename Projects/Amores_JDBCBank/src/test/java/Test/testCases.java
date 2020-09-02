package Test;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import bankBeans.Customer;
import bankImplements.BankAdminImplement;
import bankImplements.BankCustomerImplement;

public class testCases {
		
		// Temporary Objects for test cases
		BankCustomerImplement testCustomer = new BankCustomerImplement();	
		BankAdminImplement testAdmin = new BankAdminImplement();
		

		
		// test to see if deposits are functional
		@Test
		void testDeposit() {
			BankCustomerImplement ct = new BankCustomerImplement();
			Assertions.assertEquals(100,ct.DepositIntoAcc(50,50));
		}

		// checks to see if an input of a negative number will break code
		@Test
		void testNegDeposit() {
			BankCustomerImplement ct = new BankCustomerImplement();
			Assertions.assertEquals(100,ct.DepositIntoAcc(100, -10));
		}
		
		
		// test to see if withdrawals are functional
		@Test
		void testWithdraw() {
			BankCustomerImplement temp = new BankCustomerImplement();
			Assertions.assertEquals(100,temp.WithdrawOutofAcc(150,50));
		}
		
		// checks if error is caught when over withdrawing out of account 
		@Test
		void testWithdrawOver() {
			BankCustomerImplement temp = new BankCustomerImplement();
			Assertions.assertEquals(100,temp.WithdrawOutofAcc(100,150));
		}


}
