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
	public Customer(String FirstName, String LastName, String Username, String Password,float Acc1, float Acc2) {
		this.F_Name = FirstName;
		this.L_Name = LastName;
		this.U_Name = Username;
		this.PassWord = Password;
		this.Acc1 = Acc1;
		this.Acc2 = Acc2;
	}
	public Customer(String FirstName, String LastName, String Username, String Password,float Acc1) {
		this.F_Name = FirstName;
		this.L_Name = LastName;
		this.U_Name = Username;
		this.PassWord = Password;
		this.Acc1 = Acc1;
	}
	public String getFirstName() {
		return F_Name;
	}
	public void setFirstName(String F_Name) {
		this.F_Name = F_Name;
	}
	public String getLastName() {
		return L_Name;
	}
	public void setLastName(String L_Name) {
		this.L_Name = L_Name;
	}
	public String getUserName() {
		return U_Name;
	}
	public void setUserName(String U_Name) {
		this.U_Name = U_Name;
	}
	public String getPassword() {
		return PassWord;
	}
	public void setPassword(String PW) {
		this.PassWord = PW;
	}
	
	public float getAccount1() {
		return Acc1;
	}
	public void setAccount1(float Acc1) {
		this.Acc1 = Acc1;
	}
	public float getAccount2() {
		return Acc2;
	}
	public void setAccount2(float Acc2) {
		this.Acc2 = Acc2;
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
