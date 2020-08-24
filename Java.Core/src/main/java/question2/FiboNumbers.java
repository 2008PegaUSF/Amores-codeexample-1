package question2;

public class FiboNumbers {
	
	//Method to input and display Fibonacci sequence
	public int printFiboNumbers(int n) {
		
		int f1 = 0, f2 =1, i;
		
		if(n < 0)
			return n;
		
		//Method to add next number in the sequence
		for (i = 1; i <=n; i++) {
			
			System.out.print(f1 + " ");
			int next = f1 + f2;
			f1 = f2;
			f2 = next;
		}
		return n;
	}
}

