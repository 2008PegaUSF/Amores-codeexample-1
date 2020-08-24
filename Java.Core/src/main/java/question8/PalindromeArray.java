package question8;

import java.util.ArrayList;


public  class PalindromeArray {
	public static ArrayList<String> wordBank = new ArrayList<String>();
	public  static ArrayList<String> hasPalindrome = new ArrayList<String>();
	public  static ArrayList<String> noPalindrome = new ArrayList<String>();

	
	public void addtoArray(){
	wordBank.add("karan");
	wordBank.add("madam");
	wordBank.add("tom");
	wordBank.add("civic");
	wordBank.add("radar");
	wordBank.add("sexes");
	wordBank.add("jimmy");
	wordBank.add("kayak");
	wordBank.add("john");
	wordBank.add("refer");
	wordBank.add("billy");
	wordBank.add("did");
}	
	
		
	
	
	
	//Array check
	public PalindromeArray() {
		addtoArray();
		
		for(String palin : wordBank) {
			
			//boolean check if word is a palindrome
			boolean Pal = contPalindrome(palin);
			
			//if its a palindrome
			if(Pal) {
				
				//adds found palindrome to palindrome Array
				hasPalindrome.add(palin);
				
			} else {
				//adds the rest of the words to the non palindrome Array
				noPalindrome.add(palin);
				
			}
					
		}
		
		//Displays on the console after iterated through the loop
		System.out.println("Started list: ");
		System.out.println(wordBank);
		
		System.out.println("List of Palindromes: ");
		System.out.println(hasPalindrome);
}


 public static boolean contPalindrome(String value) {
	 for(String palin : wordBank) {
	 if(value == null || value.isEmpty()) 
		 return false;
	 else {
		 return new StringBuilder(value).reverse().toString().equals(value); 
	 }
  }
	return false;
	 
 }






	
}

  
 


