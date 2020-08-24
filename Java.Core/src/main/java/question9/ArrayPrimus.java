package question9;

import java.util.ArrayList;

public class ArrayPrimus {
	
	
    public static ArrayList<Integer> Cybertron = new ArrayList<Integer>();
    public static ArrayList<Integer> Primes = new ArrayList<Integer>();
    public static ArrayList<Integer> Decepticons = new ArrayList<Integer>();
	


	public ArrayPrimus() {
		
		  //Creates Cybertron array
  		for(int i=1; i<= 100; i++) {
  			Cybertron.add(i);
  		}
		
		for(int primes : Cybertron) {
			
			//Organizes values either into Primes or Decepticons arrays
			//checks if true Prime
			boolean arePrime = testPrime(primes);
			
			if(arePrime) {
				Primes.add(primes);
				
			} else {
				Decepticons.add(primes);
		}
					
	}		
			//Prints  two separate lists to the console.
			System.out.println("Wanted Decepticons: ");
			System.out.println(Decepticons + "\n");
			
			System.out.println("The Primes: ");
			System.out.println(Primes);
			
		}
			
	 public static boolean testPrime(int value) {
		 
		 
		 if(value == 1 || value == 0) return false; 
		 if (value == 2)			  return true;
		 
		 //Checks to see if value is multiple of 2
		 if(value % 2 == 0) 		  return false;
		 
		 //Checks odd values
		 for(int i = 3;  i * i <=value; i += 2) {
			 if(value % i == 0) 	  return false;
		 }
		 
		 							  return true;
	}
}
