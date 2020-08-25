package question_04;

import java.util.Scanner;

public class Nfactorial {
	
	 public static int  Nfactorial(int num) {
		//int i;
		int fact = 1; //for testing purposes.
		
		/*Allows the user to input an integer for calc
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter an integer: ");    //Originally meant to use the scanner class for user input
		i = in.nextInt();*/
		if(num == 0) {
			System.out.println(0);
		}else {
		for(int j=1 ; j< num; j++) {
			fact = fact*j;
		}
			System.out.println("Factorial: " + fact);
		}
		return fact;
	
	 }
}
