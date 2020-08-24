package question_15;

public class InterfaceTester implements Solvers {

	    @Override
	    public double add(double one, double two) {
	        return one+two;
	    }

	    @Override
	    public double subtract(double one, double two) {
	        return one - two;
	    }

	    @Override
	    public double multiply(double one, double two) {
	        return one*two;
	    }

	    @Override
	    public double divide(double one, double two) {
	        if(two == 0){
	            System.out.println("error");
	        }else{
	            return one /two;
	        }
	        return 0;
	    }
	}


