package ie.atu.sw;

public class MergeSort implements SortingAlgorithm {

	@Override
	public void sort(int[] arr) {
		divide(arr);
	}
	
	private void divide(int[] arr) {
		// Code based on this video tutorial from YouTube:
		// https://www.youtube.com/watch?v=bOk35XmHPKs
		
		// Base case
		if (arr.length < 2) return;
		
		// Divide array into two halves
		int midIndex = arr.length / 2;
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[arr.length - midIndex];
		
		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = arr[i];
		}
		for (int i = midIndex; i < arr.length; i++) {
			rightHalf[i - midIndex] = arr[i];
		}
		
		// Recur for each side
		divide(leftHalf);
		divide(rightHalf);
		
		merge(arr, leftHalf, rightHalf);
	}
	
	private void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
		
		int i = 0, j = 0, k = 0;
		
		// Compare elements from both halves and put smaller one into arr
		while (i < leftHalf.length && j < rightHalf.length) {
			if (leftHalf[i] <= rightHalf[j]) {
				arr[k] = leftHalf[i];
				i++;
			} else {
				arr[k] = rightHalf[j];
				j++;
			}
			k++;
		}
		
		// Copy any remaining elements from halves
		while (i < leftHalf.length) {
			arr[k] = leftHalf[i];
			i++;
			k++;
		}
		while (j < rightHalf.length) {
			arr[k] = rightHalf[j];
			j++;
			k++;
		}
	}

	@Override
	public String getName() {
		return "Merge Sort";
	}
}
