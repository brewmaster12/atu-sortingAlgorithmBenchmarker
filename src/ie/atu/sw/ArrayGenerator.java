package ie.atu.sw;

import java.util.Random;

public class ArrayGenerator {
	
	public static int[] randomArray(int n, int valueRange) {
		int[] arr = new int[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) { // Populate arr with random ints
			int randomNumber = random.nextInt(valueRange + 1); // Generate random number between 0 and maxValue
			arr[i] = randomNumber; // Append random number to index i
		}
		return arr; // Return the array
	}

	// Taken from Week 10 "Java Benchmarking Code" notes
	public static int[] copyArr(int[] src){
        int[] dest = new int[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
}
