package question_14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class caseSwitch {
	
	public double caseSwitch(int x) {
		int choice = 0;
		float num;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
		Date date = new Date();
		

		Scanner sc = new Scanner(System.in);
		
		while(choice !='3') {
			System.out.println("Please choose..."
					+"\n1  "
					+ "\n2 "
					+"\n3  ");
			choice = sc.nextInt();
					
		double num2 = 0;
		switch(choice) {
		
		case 1 :
			System.out.println("Please input a number....");   //Inputs a number and provides the square root of that number
			num = sc.nextFloat();
			num2 = Math.sqrt(num);
			System.out.println("The square root of the number: " +num+ " is: ");
			System.out.println(num2);
			break;
			
		case 2 :
			System.out.println(dateFormat.format(date)); //date at time of instantation
			break;
			
		case 3 :
			String s = "I am learning Core Java";		//Splits the string and prints out the string back
			String[] Split = s.split(" ");
			printArr(Split);
			break;
			
		
		default: 
			System.out.println("Why do you persist Mr. Anderson?"); //Please enjoy the Matrix reference if you don't comply....
			System.out.println("Please comply...." + '\n');
			//caseSwitch();
		}
		break;
		}
		
		return x;
} 

	
	public void printArr(String Split[]) {       //Separate method that is called to print out the new string.
		int n = Split.length;
		
		for(int i= 0 ; i<n ; ++i) {
			System.out.print(Split[i] + " ");
		}
		
		System.out.println();
		
	}
}
