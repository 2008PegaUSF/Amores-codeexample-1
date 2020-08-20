package calcApp;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		double n1, n2;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		
		n1 = sc.nextDouble();
		
		System.out.print("Enter second number: ");
		n2 = sc.nextDouble();
		
		System.out.print("Please select an operator (+, -, *, /, %):  ");
		char operator = sc.next().charAt(0);
		
		sc.close();
		double output;
		
		
		switch(operator) {
			
			case '/':
				output = n1 / n2;
				break;
				
			case '*':
				output = n1 * n2;
				break;
			
			case '+':
				output = n1 + n2;
				break;
			
			case '-':
				output = n2 - n1;
				break;
			
			case '%' :
				output = n1 % n2;
				break;
			
			default: 
				System.out.print("You have chosen poorly");
				return;
		}
		
		System.out.println(n1+ " " +operator+ " "+n2+ ": "+output);
	}
	
}
