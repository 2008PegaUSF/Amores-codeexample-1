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
			System.out.println("Please input a number....");
			num = sc.nextFloat();
			num2 = Math.sqrt(num);
			System.out.println("The square root of the number: " +num+ " is: ");
			System.out.println(num2);
			break;
			
		case 2 :
			System.out.println(dateFormat.format(date)); //date at time of instantation
			break;
			
		case 3 :
			String s = "I am learning Core Java";
			String[] Split = s.split(" ");
			printArr(Split);
			break;
			
		
		default: 
			System.out.println("Why do you persist Mr. Anderson?");
			System.out.println("Please comply...." + '\n');
			//caseSwitch();
		}
		
		}
		return x;
} 

	
	public void printArr(String Split[]) {
		int n = Split.length;
		
		for(int i= 0 ; i<n ; ++i) {
			System.out.print(Split[i] + " ");
		}
		
		System.out.println();
		
	}
}
