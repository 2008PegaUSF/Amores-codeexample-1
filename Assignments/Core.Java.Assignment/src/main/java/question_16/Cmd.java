package question_16;

public class Cmd {
	
	 public static int Cmd(String st) {
		 int count = 0; //Created counter 
		 for (int i = 0; i<st.length(); i++) {
			 if(st.charAt(i) != ' ') {
				 count++;
			 }
			 System.out.println("Number of characters found in this String" +st+ "is: ");
			 System.out.println(st.length());
			 
		 }
		return count;
	 }
}
