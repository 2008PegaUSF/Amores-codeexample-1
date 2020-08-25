package question_03;

import java.util.Scanner;

public class RevString {
	
	  
	char[] letters;
	
	  public void input(){
		//Allows user to input string
		Scanner sc = new Scanner(System.in);
		System.out.print("Input a string: ");
		letters = sc.nextLine().toCharArray();
		sc.close();
	}
	  public char[] RevString(String string) {
		//input();
		letters = string.toCharArray();
		char[] let = new char[letters.length];
		System.out.print("Reversed string out: ");
		//Reverses inputed string (method)
		for (int i = letters.length-1; i>=0; i--) {
			System.out.print(let[i]);
		}
		return let;
		}
}