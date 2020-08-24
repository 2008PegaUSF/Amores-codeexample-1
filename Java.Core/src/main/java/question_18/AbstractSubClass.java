package question_18;

public class AbstractSubClass extends AbstractString {
	
	  public AbstractSubClass() {

	        this.thatString = toString();
	    }

	    @Override
	    public boolean isUpperCase() {
	        String lowerString = thatString.toLowerCase();
	        
	        //checks the string to see if it was converted to lower case 
	        boolean equal = lowerString.equals(thatString);

	        //if they are equal then myString doesn't have upper case letters
	        if(equal){
	            return false;
	        }else{
	            //if they are not equal then myString did have upper case letters
	            return true;
	        }
	    }

	    @Override
	    public String convertToUpper() {
	        //this just cast myString to all uppercase letters
	        return thatString.toUpperCase();
	    }

	    @Override
	    public int convertToInt() {
	        int num = 10;
	        //since a string is scanned to add an integer to the string
	        //type cast character by character
	        for(int i = 0; i<thatString.length();i++){
	            num = num + (int)thatString.charAt(i);
	        }
	        return num;
	    }
	}
