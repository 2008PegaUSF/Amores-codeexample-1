package question_17;

import java.util.Scanner;

public class InterestCalculator {
	
	public void InterestCalculator() {
		
		//Scanner needed for input; allows the user to input key details to calculate the interest generated. 
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
	
	public static float Interest(float principle, float rate, float years) {   //Basic math to calculate the interest 
		float interest = (principle*rate*years)/100;
		return interest; 
	}
	
}
