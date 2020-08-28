package question_11;

import question_11AnotherPackage.*;

public class theCalling {
	public theCalling() {}
	
	public static void main (String[] args) {   //Calls floats from another package
		theCalled numbers = new theCalled();
		System.out.println(numbers.f1);
		System.out.println(numbers.f2);
	}
}
