package question4;

import java.util.Scanner;

public class Nfactorial {
	
	 public static int  Nfactorial(int num) {
		//int i;
		int fact = 1;
		
		/*Allows the user to input an integer for calc
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter an integer: ");
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
