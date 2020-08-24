package question5;

public class SubString {
	
	public SubString() {
		int idx = 4;
		String st = "Hello";
		
		System.out.println("Starting String: " + st);
		String sb = SubString(idx,st);
		System.out.println("Substring: " + sb + " is between 0 and " + idx+ "-1 inclusively");
	}
	
	public static String SubString(int idx, String st) {
		
		
		char[] subString = new char[idx];
		
		for(int i=0; i<idx-1; i++) {
			
			subString[i] = st.charAt(i);
			
		}
		
		String sb2 = new String(subString);
		return sb2;


	}

}
