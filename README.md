# Sorting Algorithm Benchmarker

> Computational Thinking with Algorithms — H.Dip. in Science (Software Development)  
> ATU, Galway City Campus | **50% of module grade**

---

## Overview

A Java benchmarking application that measures and compares the performance of five sorting algorithms across a range of input sizes. Each algorithm is run **10 times per input size** and the average runtime (in milliseconds) is printed to the console in a formatted table.

---

## Algorithms Implemented

| Algorithm | Type |
|---|---|
| Bubble Sort | Comparison-based |
| Selection Sort | Comparison-based |
| Insertion Sort | Comparison-based |
| Merge Sort | Efficient comparison-based |
| Counting Sort | Non-comparison-based |

---

## Running the Application

```bash
javac ie/atu/sw/*.java
java ie.atu.sw.BenchmarkRunner
```

---

## Sample Output

```
Input size    100     250     500     750    1000   ...
Bubble Sort   0.134   0.207   0.519   0.533  0.787  ...
Selection     0.012   0.059   0.202   0.406  0.674  ...
Insertion     0.015   0.078   0.262   0.539  0.802  ...
Merge Sort    0.042   0.032   0.062   0.098  0.132  ...
Counting      0.015   0.031   0.056   0.081  0.105  ...
```

Results are formatted to 3 decimal places. Total benchmark time is printed on completion.

---

## Project Structure

```
src/
└── ie/atu/sw/
    ├── BenchmarkRunner.java   # Entry point — runs and prints benchmarks
    ├── SortingAlgorithm.java  # Interface implemented by all sort classes
    ├── ArrayGenerator.java    # Generates random and copied arrays
    ├── DatasetGenerator.java  # Pre-generates all test data before benchmarking
    ├── BubbleSort.java
    ├── SelectionSort.java
    ├── InsertionSort.java
    ├── MergeSort.java
    └── CountingSort.java
```

---

## Configuration

Input sizes and other parameters can be adjusted in `BenchmarkRunner.java`:

```java
private int[] sizes = {100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000};
private int reps = 10;
private int valueRange = 10_000;
```

A larger size set (up to 1,000,000) is also included as a commented-out option.
