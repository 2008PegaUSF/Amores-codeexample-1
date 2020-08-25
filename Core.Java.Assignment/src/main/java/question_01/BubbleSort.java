package question_01;

public class BubbleSort {
	
    public void bubbleSort(int arr[]) {
        int n = arr.length;
      //Iterates through the array by switching two integers based on the greater value
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])        //swaps and compares who is greater between two values
                {
                    
                    int temp = arr[j];       //places the first to another variable
                    arr[j] = arr[j+1];		// sets the second to the beginning
                    arr[j+1] = temp;		// places the greater value ahead
                    
                }
    }

    public void printArray(int arr[]) {
    	int n = arr.length;
    	
    	
    	for (int i=0; i<n; ++i)
        System.out.print(arr[i] + " ");
    	System.out.println();
    
    }
    
   
}
