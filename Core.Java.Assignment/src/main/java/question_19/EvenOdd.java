package question_19;

import java.util.ArrayList;

public class EvenOdd {
	
	
    public void EvenOdd() {

        ArrayList<Integer> Numlist = new ArrayList<Integer>();
        double evenSum = 0;
        double oddSum = 0;


        for (int i = 1; i <= 10; i++) {
            Numlist.add(i);
        }

        System.out.println("This is my arrayList populated with integers 1 through 10: " + Numlist + '\n');

        boolean ev = true;
        boolean od = true;

        for (int i = 0; i < Numlist.size(); i++) {
        	
            //checks if numbers in the original list are even
            int num = isEvenOdd(Numlist.get(i));
            if (num == 1) {
                while(ev){
                    System.out.print("Even: ");
                    ev =false;
                }
               System.out.print(Numlist.get(i)+ " ");
                evenSum += Numlist.get(i);
            }

        }
        
        System.out.println(" Even Sum: " + evenSum + '\n');

        for (int i = 0; i < Numlist.size(); i++) {
        	
            //checks if numbers in the original list are odd
            int num = isEvenOdd(Numlist.get(i));
            if (num == 0) {
                while(od){
                    System.out.print("Odd: ");
                    od =false;
                }
                System.out.print(Numlist.get(i)+ " ");
                oddSum += Numlist.get(i);
            }
        }
        System.out.println("Odd Sum: " + oddSum + '\n');

        for (int i = 0; i < Numlist.size(); i++) {
            boolean bp = isPrime(Numlist.get(i));
            if (!bp) {
               Numlist.remove(i);
            }

        }
        System.out.println("Not Prime: " + Numlist);

        }

    protected static int isEvenOdd(int value) {
        if(value % 2 == 0)
        {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static boolean isPrime(int value) {

         //Prime numbers check
        if(value == 1 || value == 0) return false;

        if(value == 2) return true;


        //Multiple of 2
        if (value % 2 == 0) return false;

        //if not then should check odd numbers
        for (int i = 3; i * i <= value; i += 2) {
            if (value % i == 0)
                return false;
        }
        return true;

    }
}
