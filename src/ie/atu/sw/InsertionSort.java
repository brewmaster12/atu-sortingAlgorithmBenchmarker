package ie.atu.sw;

public class InsertionSort implements SortingAlgorithm {

	@Override
	public void sort(int[] arr) {
		// Code credit: Week 9 lecture notes
		int i = 1;
		while (i < arr.length) {
			int j = i;
			while (j > 0 && (arr[j - 1] > arr[j])) {
				// Swap
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				j--;
			}
			i++;
		}
	}

	@Override
	public String getName() {
		return "Insertion Sort";
	}

}
