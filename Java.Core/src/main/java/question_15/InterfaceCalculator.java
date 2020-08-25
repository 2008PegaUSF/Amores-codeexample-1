package question_15;

public class InterfaceCalculator  extends InterfaceTester {    //Actual main method

    public static void main(String[] args) {

        InterfaceCalculator cal= new InterfaceCalculator(); 
        double d1 = 10;
        double d2= 9;

        System.out.println("Numbers are: "+d1+ " and " +d2);
        System.out.println("Addition: "+ cal.add(d1,d2));
        System.out.println("Subtraction: "+ cal.subtract(d1,d2));
        System.out.println("Multiplication: "+ cal.multiply(d1,d2));
        System.out.println("Division: "+ cal.divide(d1,d2));
    }

}

