package question_07;

import java.util.Comparator;
import java.util.Arrays;

public class compareEmployee extends Employee {
	
	public compareEmployee (String name, String department, int age) {
		super(name, department, age);
	}
	
	public static class compareDepart implements Comparator<Employee> {

		@Override //Compares employee department location
		public int compare(Employee o1, Employee o2) {
			if (o1.getDepart().compareTo(o2.getDepart()) > 0) {
				return 1;
			} else if (o1.getDepart().compareTo(o2.getDepart()) < 0){
				return -1; 
			} else {
			return 0;
		}
	}
}
	public static class compareName implements Comparator<Employee> {

		@Override //Compares name of Employee
		public int compare(Employee o1, Employee o2) {
			if (o1.getName().compareTo(o2.getName()) > 0) {
                return 1;
            } else if (o1.getName().compareTo(o2.getName()) < 0) {
                return -1;
            } else {
                return 0;
            }
		}
	}
	
	
	public static class compareAge implements Comparator<Employee> {

		@Override // Compares by employee age
		public int compare(Employee o1, Employee o2) {
			if (o1.getAge() < o2.getAge()) {
                return 1;
            } else if (o1.getAge() > o2.getAge()) {
                return -1;
            } else {
			return 0;
		}
		
	}
}
	
	public static void main(String[] args) {
		
		//Test case
		String name = "Luke Skywalker ";      //I hope you like my Star Wars references
		String name2 = "Jade Skywalker ";	  //This is EU (according to Disney)
		
		int age = 35;
		int age2 = 27;
		
		String depart = "Jedi";
		String depart2 = "Imperial Officer";
		
		Employee e1 = new Employee(name, depart, age);
		Employee e2 = new Employee(name2, depart2, age2);
		
		//Places test case in new Array
		Employee[] eArray = {e1, e2};
		
		//Calls on comparison methods
		compareDepart departCheck = new compareDepart();
		compareName nameCheck = new compareName();
		compareAge ageCheck = new compareAge();
		
		//Organizes data 
		Arrays.sort(eArray,departCheck);
		System.out.println("Sort by department: ");
		for(Employee employee : eArray) {
			System.out.println("Age: "+employee.getAge()+" Name: "+employee.getName()+" Department: "+ employee.getDepart());
	}
		
		Arrays.sort(eArray, nameCheck);
		System.out.println("\n"+ "Sort by name: ");
		for(Employee employee : eArray) {
			System.out.println("Age: "+employee.getAge()+" Name: "+employee.getName()+" Department: "+ employee.getDepart());
		}
		
		Arrays.sort(eArray, ageCheck);
		System.out.println("\n"+ "Sort by age: ");
		for(Employee employee : eArray) {
			System.out.println("Age: "+employee.getAge()+ " Name: "+employee.getName()+" Department: "+ employee.getDepart());
		}
		
		
	}
	

}
