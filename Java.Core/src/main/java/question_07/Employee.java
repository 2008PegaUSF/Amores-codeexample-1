package question_07;

public class Employee {
	
	//Access control and employee information
	protected String name; 
	protected String department; 
	protected int age;
	
	//Constructors
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;		
	}
	
	//Getters
	public String getName() {
		return name;
		
	}
	
	public String getDepart() {
		return department;
	}
	
	public int getAge() {
		return age;
	}
	
	//Setters
	public void setName(String name) {
		this.name = name; 
	}
	
	public void setDepart(String department) {
		this.department = department;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String info() {
		return "Employee{" +
				"name='" + name + '\'' +
				", department='" + department + '\'' +
				", age=" + age +
				'}';
	}
}
