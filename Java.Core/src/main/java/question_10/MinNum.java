package question_10;

public class MinNum {
	
	public int MinNum(int n1, int n2) {
				
		//Displays onto the console
		System.out.println("The min value of " +n1+ " and "+n2+ " is: ");
		
		//ternary operation
		int minNum = (n1 < n2) ? n1 : n2;
		System.out.print(minNum);
		return minNum;
		
		
	}
	

}
