package question_12;

import java.util.ArrayList;

public class EvenArray {

    public ArrayList<Integer> evenArray() {

        ArrayList<Integer> EA = new ArrayList<Integer>(); //EA is the new ArrayList
        
        //Populates 100 numbers
        for (int i=1; i<=100; i++) {
        	if (i % 2 ==0) {
        		EA.add(i);
        	}
        	//Enhanced for loop to populate array with even numbers
        for (int even : EA) {
        	System.out.print(even + " ");
        }
      }
		return EA;
    }
}


//Test checks ArrayList EA against an ArrayList of known even numbers

