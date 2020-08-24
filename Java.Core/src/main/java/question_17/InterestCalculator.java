package question_17;

import java.util.Scanner;

public class InterestCalculator {
	
	public void InterestCalculator() {
		
		//Scanner needed for input; allows the user to create a 
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello!" +'\n' + "Welcome to Revature Bank!");
		
		System.out.println("Please enter principle: ");
		float principle = sc.nextFloat();
		
		System.out.println("Please enter time invested in YEARS: ");
		float years = sc.nextFloat();
		
		System.out.println("Please enter annual rate of interest: ");
		float rate = sc.nextFloat();
		
		float interest = Interest(principle, years, rate);
	
		System.out.println("The interest generated is: " + interest);
	}
	
	public static float Interest(float principle, float rate, float years) {
		float interest = (principle*rate*years)/100;
		return interest; 
	}
	
}
