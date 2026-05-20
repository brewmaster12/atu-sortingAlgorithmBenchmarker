package ie.atu.sw;

import java.util.Arrays;
import java.util.List;

public class BenchmarkRunner {
	private int[] sizes = {100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000};
	//private int[] sizes = {10_000, 25_000, 50_000, 75_000, 100_000, 125_000, 250_000, 375_000, 500_000, 625_000, 750_000, 875_000, 1_000_000};
	private int reps = 10;
	private int valueRange = 10_000;
	private List<SortingAlgorithm> algorithms = Arrays.asList(
			new BubbleSort(),
			new SelectionSort(),
	        new InsertionSort(),
	        new MergeSort(),
	        new CountingSort()
	    );

	private void go() {
		// Print header
		System.out.print("Input size");
		for (int size : sizes) System.out.print("\t" + size);
		System.out.println();
		
		// Generates all inputs that will be used
		List<int[][]> inputDataset = DatasetGenerator.generate(sizes, reps, valueRange); 
		
		// For each algorithm ...
		for (SortingAlgorithm algo : algorithms) {
			// Print algo name
			System.out.print(algo.getName());
			// For each set of input sizes ...
			for (int i = 0; i < sizes.length; i++) {
				// Get the set of test arrays and run them through the algo
				int[][] testArrays = inputDataset.get(i);
				runAlgorithm(algo, testArrays);
			}
			// Print result of each algo
			System.out.println();
		}
	}
	
	private void runAlgorithm(SortingAlgorithm algo, int[][] testArrays) {

		long sum = 0;
		for (int rep = 0; rep < reps; rep++) {			
			int[] cloned = ArrayGenerator.copyArr(testArrays[rep]);
			
			long startTime = System.nanoTime();
			algo.sort(cloned); // Run input through algo
			long endTime = System.nanoTime();
			
			long timeElapsed = endTime-startTime;
			sum += timeElapsed;
		}
		// Get average time elapsed
		double average = (double) sum / reps;
		double resultMillis = average/1000000.0;
		
		// Prints result in millis rounded to 3 decimal places
		System.out.print("\t" + String.format("%.3f", resultMillis));
	}
	
	public static void main(String[] args) {
		BenchmarkRunner benchmarker = new BenchmarkRunner();
		
		long startTime = System.currentTimeMillis();
		benchmarker.go();
		long endTime = System.currentTimeMillis();
		
		long timeElapsed = endTime-startTime;
		double seconds = (double) timeElapsed / 1000;
		System.out.println("Done. Time: " + seconds + " sec");
	}
}
