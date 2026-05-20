package ie.atu.sw;

public class SelectionSort implements SortingAlgorithm {

	@Override
	public void sort(int[] arr) {
		// Code credit: Week 9 lecture notes		
		for (int i = 0; i < arr.length-1; i++) {
			int minIndex = i;
			
			// Finds smallest element
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			// Swap
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}

	@Override
	public String getName() {
		return "Selection Sort";
	}

}
