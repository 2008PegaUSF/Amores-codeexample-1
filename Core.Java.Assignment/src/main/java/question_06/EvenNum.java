package question_06;

//import java.util.Scanner;

public class EvenNum {
	/*public EvenNum() {
		Allows user to input a number into the check method
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter number to be checked: ");
		
		Optional scanner functionality is commented out for testing purposes.
		
		
	}*/
	
	boolean t = true;
	public boolean canEven(int n) {
		
		int x = n/2;
		int ans = x*2;
		//Method to check number
		if(ans == n) {
			System.out.println(n + " can even");
			boolean t1 = true;
		}
		else {
			System.out.println(n + " cant even");
			boolean t1 = false;
		}
		return t;
	}
}
