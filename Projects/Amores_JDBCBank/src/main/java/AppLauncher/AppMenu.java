package AppLauncher;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import bankBeans.Admin;
import bankBeans.Customer;
import bankImplements.BankAdminImplement;
import bankImplements.BankCustomerImplement;


public class AppMenu {
	
	static Scanner sc = new Scanner(System.in);
	
	//Customer Creation Portal *Initialized at the selection by the user in App Menu
	public static void createCustomer() {
		String F_NAME;
		String L_NAME; 
		String U_NAME;
		String PW;
		float Acc1;
		
		BankCustomerImplement customCreation = new BankCustomerImplement();
		
		System.out.println("Thank you for choosing Saffron City Bank!");
		System.out.println("Please enter your first name");
		F_NAME = sc.next();
		
		System.out.println("Please enter your last name");
		L_NAME = sc.next();
		
		System.out.println("Please enter a  user name");
		U_NAME = sc.next();
		
		System.out.println("please type in password");
		PW = sc.next();
		
		System.out.println("Thank you for creating an account!");
		System.out.println("\nPlease enter amount to be deposited: ");
		Acc1 = sc.nextFloat();
		try {
			customCreation.CreateNewCustomer(L_NAME, F_NAME, U_NAME, PW, Acc1);
			System.out.println("Account Created! \nWelcome!");
			launchPortal();
		} catch (SQLException e) {
			System.out.println("Could not create Account \nPlease try again later");
			e.printStackTrace();
		}
	}
	

	//Customer Login Portal Prompt
	public static void currentLogin() {
		String currentPW;
		String PW;
		String user;
		
		BankCustomerImplement CDI = new BankCustomerImplement();
		
			System.out.println("Please enter account Username");
			user = sc.next();
				
			try {
				Customer c = CDI.getCustomer_UN(user);
				currentPW = c.getPassword();
				System.out.println("Please enter account password, otherwise please enter forgot password");
				PW = sc.next();
				
				if(currentPW.equals(PW)) {
					customerWelcomeSN(c);
				} else if(PW.equals("forgot password")) {
					launchPortal();
				} else {
					System.out.println("Password is incorrect");
					currentLogin();
				}
			} catch (SQLException e) {
				System.out.println("User not found.");
				e.printStackTrace();
			} catch (NullPointerException e) {
				System.out.println("User does not exist.");
				e.printStackTrace();
			}
	}
	
	//Administration Portal Login Prompt
	public static void adminLogin() {
		String user;
		String currentPW;
		
		BankAdminImplement BAI = new BankAdminImplement();
		
		System.out.println("Please Enter your Username");
		user = sc.next();
			
		try {
			Admin c = BAI.getAdmin_UN(user);
			currentPW = c.getPassword();
			System.out.println("Enter your password");
			String password = sc.next();
			if(currentPW.equals(password)) {
				AdminSN(BAI);
			} else if(password.equals("quit")) {
				launchPortal();
			} else {
				System.out.println("Incorrect Password");
				adminLogin();
			}
		} catch (SQLException e) {
			System.out.println("User not found.");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("User does not exist.");
			e.printStackTrace();
		}
	}
	
	
	public static void customerWelcomeSN(Customer c) {
		int decision;
		float deposit;
		float withdraw;
		float Acc2;
		
		BankCustomerImplement CDI = new BankCustomerImplement();
		
		System.out.println("Welcome to the Customer Portal");
		System.out.println("Account Information is being displayed");
		System.out.println(c.toString());
		System.out.println("Please choose a selection....");
		System.out.println("(1) Deposit\n(2) Withdraw\n(3) Apply for a New Account\n(4) Delete an account");
				   decision = sc.nextInt();
			switch(decision) {
			case 0: 
				System.out.println("Exiting customer portal....");
				launchPortal();
				break;
			case 1:
				System.out.println("Welcoem to the cash deposit Portal ");
				System.out.println("Please set amount to be  deposited...");
						deposit = sc.nextFloat();
				try {
					CDI.AccDeposit(c,deposit,sc);
					System.out.println("Deposit of $" + deposit + " transaction completed");
				} catch (SQLException e) {
					System.out.println("ERROR: Transaction cannot be completed.");
					e.printStackTrace();
				}
				customerWelcomeSN(c);
				break;
				
			case 2:
				System.out.println("Welcome to the cash withdrawal portal.");
				System.out.println("Please set amount to be withdrawn...");
				 	withdraw = sc.nextFloat();
				try {
					CDI.AccWithdraw(c, withdraw,sc);
					System.out.println("Withdraw of $" + withdraw + " transaction completed.");
				} catch (SQLException e) {
					System.out.println("ERROR: Transaction cannot be completed.");
					e.printStackTrace();
				}
				customerWelcomeSN(c);
				break;
			case 3:
				System.out.println("Welcoem to the account creation portal! ");
				try {
					System.out.println("Please set amount to be deposited into new account.");
						Acc2 = sc.nextFloat();					
					CDI.AccApply(c,Acc2);
					System.out.println("Account creation complete! ");
				} catch (SQLException e1) {
					System.out.println("ERROR : Account creation cannot be completed.");
					e1.printStackTrace();
				}
				customerWelcomeSN(c);
				break;
			case 4:
				System.out.println("Account Deletion Portal");
				try {
					CDI.DELAcc(c,sc);
				} catch (SQLException e) {
					System.out.println("ERROR: Request denied.");
					e.printStackTrace();
				}
				customerWelcomeSN(c);
				break;
			default:
				System.out.println("Select an option please");
				customerWelcomeSN(c);
			}
	}
	
	// Administration Portal
	public static void AdminSN(BankAdminImplement c) {
		int decision;
		
		System.out.println("Bank Administration Portal");
		System.out.println("Please select an operation");
		System.out.println("(1) View a User's Information\n(2) View ALL Users\n(3) Create a new account for a User\n"
				+ "(4) Update a User's Account with the Company\n"
				+ "(5) Delete ALL Users...\n(0) To Log Out");
			decision = sc.nextInt();
			switch(decision) {
			case 0: 
				System.out.println("Closing Portal....");
				launchPortal();
				break;
			case 1:
				System.out.println("Account View");
				System.out.println("Enter customer username:");
				String username = sc.next();
				try {
					Customer view = c.viewCustomerUser(username);
					System.out.println();
					System.out.println(view.toString());
					System.out.println();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				AdminSN(c);
				break;
			case 2:
				System.out.println("");
				try {
					List<Customer> cList = c.AllCustomers();
					for(Customer cust : cList) {
						System.out.println(cust.toString());
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				AdminSN(c);
				break;
			
			case 3:
				System.out.println("Account Creation Portal: ");
				newCustomerSN();
				AdminSN(c);
				break;
			case 4:
				System.out.println("Updating account....");
				System.out.println("Enter customer username:");
				String user = sc.next();
				try {
					Customer update = c.viewCustomerUser(user);
					c.updateInfoCustomer(update, sc);
					c.updateTransactions(update, sc);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				AdminSN(c);
				break;
			case 5:
				System.out.println("Data Deletion Portal: ");
				try {
					c.deleteALL(sc);
				} catch (SQLException e) {
					System.out.println("ERROR: Data cannot be DELETED");
					e.printStackTrace();
				}
				AdminSN(c);
				break;
			default:
				System.out.println("Please Select one of the Options Please");
				AdminSN(c);
			}
	}
	
	public static void newCustomerSN() {
		float Acc1;
		String F_NAME;
		String L_NAME; 
		String U_NAME;
		String PW;
		
		BankAdminImplement BAI = new BankAdminImplement();
		System.out.println("Please Enter User's First Name");
		F_NAME = sc.next();
		System.out.println("Please enter User's Last Name");
		L_NAME = sc.next();
		System.out.println("Please enter user name: ");
		U_NAME = sc.next();
		System.out.println("Please enter password: ");
		PW = sc.next();
		System.out.println("Update value of new account: ");
		Acc1 = sc.nextFloat();
		try {
			BAI.newCustomer(L_NAME, F_NAME, U_NAME, PW, Acc1);
			System.out.println("Account Created! \nWelcome!");
		} catch (SQLException e) {
			System.out.println("ERROR: Account could not be created, try again later.");
			e.printStackTrace();
		}
	}
	
	public static void launchPortal() {
		int decision;
		
		System.out.println("Welcome to Saffron City Bank");
		System.out.println("Before logging in, please choose one of the following....");
		System.out.println("(1) New Customer \n(2) Current Customer \n(3) SFC Admin \n(0) To Exit Application");
		decision = sc.nextInt();
		
		switch(decision) {
		case 0: //Closes out the application
			System.out.println("Exiting Application\nThank you for choosing SFC Bank");
			break;
		case 1: // Account Creation Portal
			createCustomer();
			break;
		case 2: // Customer Portal
			currentLogin();
			break;
		case 3: // Admin Portal
			adminLogin();
			break;
			
		default:
			System.out.println("Please make choice or application will reset.");
			launchPortal();
			break;
		}	
	}
	
		
}