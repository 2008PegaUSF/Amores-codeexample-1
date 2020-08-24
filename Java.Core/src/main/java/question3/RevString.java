package question3;

import java.util.Scanner;

public class RevString {
	public void RevString () {
		
		//Allows user to input string
		Scanner sc = new Scanner(System.in);
		System.out.print("Input a string: ");
		char[] letters = sc.nextLine().toCharArray();
		sc.close();
		
		
		System.out.print("Reversed string out: ");
		
		//Reverses inputed string (method)
		for (int i = letters.length-1; i>=0; i--) {
			System.out.print(letters[i]);
		}
		
		System.out.print("\n");
		
	}
}