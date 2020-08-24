package question_13;

public class halfTriangle {
	
	
 public static int halfTriangle() {
        int z = 0;
        System.out.println(z); //first print out the first element 0
        
        //for for the second and third levels
        for (int i = 0; i <= 1; i+=1)
        {
            for (int j = 0; j <= i; j++)
            {
                System.out.print(z+1);

                if(j%2==0){
                    System.out.print(z);
                }
            }
            System.out.print("\n");
        }
        //last level of the pyramid
        for(int i =0; i<3;i+=2){
            if(i%2==0)
            {
                System.out.print(z);
            }
            System.out.print(z+1);
        }
        System.out.println("\n");
		return z;
    }
 	
}
