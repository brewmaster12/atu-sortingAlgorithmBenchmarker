package ie.atu.sw;

public class CountingSort implements SortingAlgorithm {

	@Override
	public void sort(int[] arr) {
		// Code based on this video tutorial from YouTube:
		// https://www.youtube.com/watch?v=YEabFTMDczQ
		
		// Gets minimum and maximum values in array
		int min = arr[0];
		int max = arr[0];
		for (int value : arr) {
		    if (value < min) min = value;
		    if (value > max) max = value;
		}
		
		// Count values in arr and store results in a new array ("count")
		int[] count = new int[max - min + 1];
		for (int value : arr) {
			count[value - min]++;
		}
		
		// Transform count array into cumulative counts
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		
		// Build the output array
		int[] output = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int current = arr[i];
			int positionInArray = count[current - min] - 1;
			output[positionInArray] = current;
			count[current - min]--;
		}
		
		// Copy output back to original array
		System.arraycopy(output, 0, arr, 0, arr.length);
	}

	@Override
	public String getName() {
		return "Counting Sort";
	}

}
