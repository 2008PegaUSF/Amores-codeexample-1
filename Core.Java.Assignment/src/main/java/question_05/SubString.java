package question_05;

public class SubString {
	
	public SubString() {
		int idx = 4;
		String st = "Hello";
		
		System.out.println("Starting String: " + st);
		String sb = SubString(idx,st);
		System.out.println("Substring: " + sb + " is between 0 and " + idx+ "-1 inclusively");
	}
	
	public static String SubString(int idx, String st) {
		
		
		char[] subString = new char[idx]; //Creates a substring of the length of the index called on
		
		for(int i=0; i<idx-1; i++) { 	  //iterates until index is met 
			
			subString[i] = st.charAt(i);  //Assigns the character till idx-1 to the substring "subString" is reached
			
		}
		
		String sb2 = new String(subString);  //The substring is converted to a string
		return sb2;							 //Just returns the string 


	}

}
