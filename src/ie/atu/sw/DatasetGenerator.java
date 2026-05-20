package ie.atu.sw;

import java.util.ArrayList;
import java.util.List;

public class DatasetGenerator {
    public static List<int[][]> generate(int[] sizes, int reps, int valueRange) {
        List<int[][]> dataset = new ArrayList<>();
        // For each input data size ...
        for (int size : sizes) {
        		// Create "reps" amount of random arrays
            int[][] testArrays = new int[reps][size];
            for (int i = 0; i < reps; i++) {
                testArrays[i] = ArrayGenerator.randomArray(size, valueRange);
            }
            // Add them to the ArrayList
            dataset.add(testArrays);
        }
        return dataset;
    }
}