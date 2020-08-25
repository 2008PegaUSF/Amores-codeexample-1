package question_01;

public class Driver {

	public static void main(String[] args) {

		BubbleSort ob = new BubbleSort();
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4}; //array of integers given
		ob.bubbleSort(arr);					// calls the bubbleSort method on int array "arr"
		System.out.println("Array Sorted"); 
		ob.printArray(arr);					//prints the sorted array 
	}
}