package bankBeans;

public class Admin {
	
	// Private fields 
	// NO args constructors that contains the fields
	// Getters and Setters Primarily
	
	private String F_Name;
	private String L_Name;
	private String U_Name;
	private String PassWord;
	
	public Admin() {
		super();
	}
	public Admin(String firstName, String lastName, String userName, String password) {
		this.F_Name = firstName;
		this.L_Name = lastName;
		this.U_Name = userName;
		this.PassWord = password;
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
	@Override
	public String toString() {
		return "Admin [firstName=" + F_Name + ", lastName=" + L_Name + ", userName=" + U_Name + ", password="
				+ PassWord + "]";
	}
	
	
}
