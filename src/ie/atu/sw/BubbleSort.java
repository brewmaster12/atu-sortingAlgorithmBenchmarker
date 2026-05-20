package ie.atu.sw;

public class BubbleSort implements SortingAlgorithm {

	@Override
	public void sort(int[] arr) {
		// Code credit: Week 9 lecture notes
		int n = arr.length;
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 1; i < n; i++) {
				if (arr[i-1] > arr[i]) {
					// Swap
					int temp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = temp;
					swapped = true;
				}
			}
		} while (swapped);
	}

	@Override
	public String getName() {
		return "Bubble Sort";
	}

}
