package question_18;

import java.util.Scanner;

public class Main {
	
	 public Main() {
	        super();
	    }

	    public static boolean main(String[] args) {
	        String input;
	        AbstractSubClass userInput;
	        
	       //Asking for the user input
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter String: " );
	        sc.close();
	        
	        while (true) {
	            try {
	                input = sc.nextLine();
	                userInput = new AbstractSubClass();
	                break;
	            } catch (NumberFormatException ignore) {
	                System.out.println("Invalid input, Please enter numeric value");
	            }
	        }

	        boolean checkUpper = userInput.isUpperCase();
	        if(checkUpper){
	            System.out.println("1.)" + input + " There are uppercase Letters");
	        }else{
	            System.out.println("1.)" +input+" There are NOT uppercase Letters");
	        }

	        String Up = userInput.convertToUpper();
	        System.out.println("2.)" + input + " -> goes to uppercase: " + Up);

	        int Ten = userInput.convertToInt();
	        System.out.println("3.)" + input + " + 10 = " + Ten);


	    	return false;
	}
}
