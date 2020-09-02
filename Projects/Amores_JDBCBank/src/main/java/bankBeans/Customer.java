package bankBeans;

public class Customer {
	
	private String F_Name;
	private String L_Name;
	private String U_Name;
	private String PassWord;
	private float Acc1;
	private float Acc2;
	
	public Customer() {
		super();
	}
	public Customer(String FirstName, String LastName, String Username, String Password,float account1, float account2) {
		this.F_Name = FirstName;
		this.L_Name = LastName;
		this.U_Name = Username;
		this.PassWord = Password;
		this.Acc1 = account1;
		this.Acc2 = account2;
	}
	public Customer(String FirstName, String LastName, String Username, String Password,float account1) {
		this.F_Name = FirstName;
		this.L_Name = LastName;
		this.U_Name = Username;
		this.PassWord = Password;
		this.Acc1 = account1;
	}
	public String getFirstName() {
		return F_Name;
	}
	public void setFirstName(String firstName) {
		this.F_Name = firstName;
	}
	public String getLastName() {
		return L_Name;
	}
	public void setLastName(String lastName) {
		this.L_Name = lastName;
	}
	public String getUserName() {
		return U_Name;
	}
	public void setUserName(String userName) {
		this.U_Name = userName;
	}
	public String getPassword() {
		return PassWord;
	}
	public void setPassword(String password) {
		this.PassWord = password;
	}
	
	public float getAccount1() {
		return Acc1;
	}
	public void setAccount1(float account1) {
		this.Acc1 = account1;
	}
	public float getAccount2() {
		return Acc2;
	}
	public void setAccount2(float account2) {
		this.Acc2 = account2;
	}
	@Override
	public String toString() {
		if(getAccount2() == 0) {
		return "Customer Information\n" + "Name: " + F_Name + " " + L_Name + "\n"
				+ "Username: " + U_Name + "\nAccount 1 Balance: $" + Acc1;
		}
		return "Customer Information\n" + "Name: " + F_Name + " " + L_Name + "\n"
		+ "Username: " + U_Name + "\nAccount 1 Balance: $" + Acc1 + "\nAccount 2 Balance: $" + Acc2;
	}
	
}
