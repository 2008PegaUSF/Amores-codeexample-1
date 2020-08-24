package question1;

public class Driver {

	public static void main(String[] args) {

		BubbleSort ob = new BubbleSort();
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		ob.bubbleSort(arr);
		System.out.println("Array Sorted");
		ob.printArray(arr);
	}
}