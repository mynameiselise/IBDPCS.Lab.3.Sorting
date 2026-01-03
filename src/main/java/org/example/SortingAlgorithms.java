package org.example;

/**
 * Sorting Algorithms Implementation
 *
 * Name: ______Elise_______________
 * Date: ______October 31, 2025_______________
 *
 * This class implements bubble sort and selection sort algorithms.
 * Complete the implementation and analyze the time complexity.
 */
public class SortingAlgorithms {

    /**
     * Bubble Sort Algorithm
     * The bubble sort algorithm uses pairs to check if the next element in the list 
     * is larger than the current element (assuming you are sorting lowest to highest).
     * If the items are in the wrong order then they swap.
     *
     * Time Complexity: O(n^2) - explain: The algorithm uses two for loops and repeatedly compares each element with the elements next to it.
                                          This leads to a large number of comparisons as the size of the list increases.
     * //note: time complexity = worst case scenario for number of steps

     * Space Complexity: O(1) - explain: Bubble sort sorts the array in place and does not require
                                         any additional memory beyond a small number of temporary variables.
     * //note: space complexity = worst case scenario for how much memory is used
     *
     * @param arr The array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        // TODO: Implement bubble sort
        // Hint 1: You'll need nested loops
        // Hint 2: The outer loop controls the number of passes
        // Hint 3: The inner loop performs comparisons and swaps
        // Hint 4: After each pass, the largest element "bubbles" to its correct position

        int n = arr.length;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {

            // Add a boolean flag to optimize (optional enhancement)
            boolean swapped = false;

            // Inner loop for comparisons in each pass
            // Note: Why do we use (n - i - 1)? Think about what happens after each pass

            // YOUR CODE HERE
            for(int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            // Optional optimization: if no swaps occurred, array is sorted
            if (!swapped) break;
        }
    }

    /**
     * Selection Sort Algorithm  
     * The selection sort algorithm uses a variable to track the index of the highest value
     * element (sorting lowest to highest). At the end of the pass, the highest value is
     * moved into the correct space.
     *
     * Time Complexity: O(n^2) - explain: The algorithm repeatedly scans the remaining unsorted portion of the data set
                                          to find the highest/smallest value. This results in a large number of comparisons
                                          as the size of the data set increases.

     * Space Complexity: O(1) - explain: Selection sort sorts the data set in place and only uses a small number of
                                         extra variables to store indexes and temporary values.
     *
     * @param arr The array to be sorted
     */
    public static void selectionSort(int[] arr) {
        // TODO: Implement selection sort
        // Hint 1: Find the minimum element in the unsorted portion
        // Hint 2: Swap it with the element at the beginning of unsorted portion
        // Hint 3: Move the boundary between sorted and unsorted portions

        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {

            // Find the minimum element in unsorted array
            // YOUR CODE HERE
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            // YOUR CODE HERE
            if(minIndex != i){
                swap(arr, i, minIndex);
            }
        }
    }

    /**
     * Helper method to swap two elements in an array
     * @param arr The array
     * @param i First index
     * @param j Second index
     */
    private static void swap(int[] arr, int i, int j) {
        // TODO: Implement swap
        // Remember: You need a temporary variable
        // YOUR CODE HERE
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Helper method to print an array
     * @param arr The array to print
     * @param message Optional message to display before the array
     */
    public static void printArray(int[] arr, String message) {
        System.out.print(message + ": ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Creates a copy of an array (useful for testing both sorts on same data)
     * @param original The array to copy
     * @return A new array with the same values
     */
    public static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }

    /**
     * Main method for testing your implementations
     */
    public static void main(String[] args) {
        // Test Case 1: Small unsorted array
        int[] testArray1 = {10, 8, 349, 3, 39, 1};

        System.out.println("=== Test Case 1: Basic Array ===");
        int[] bubbleArray1 = copyArray(testArray1);
        int[] selectionArray1 = copyArray(testArray1);

        printArray(testArray1, "Original array");

        // Test bubble sort
        bubbleSort(bubbleArray1);
        printArray(bubbleArray1, "After bubble sort");

        // Test selection sort
        selectionSort(selectionArray1);
        printArray(selectionArray1, "After selection sort");

        System.out.println();

        // Test Case 2: Already sorted array
        int[] testArray2 = {1, 2, 3, 4, 5};

        System.out.println("=== Test Case 2: Already Sorted ===");
        int[] bubbleArray2 = copyArray(testArray2);
        int[] selectionArray2 = copyArray(testArray2);

        printArray(testArray2, "Original array");
        bubbleSort(bubbleArray2);
        printArray(bubbleArray2, "After bubble sort");
        selectionSort(selectionArray2);
        printArray(selectionArray2, "After selection sort");

        System.out.println();

        // Test Case 3: Reverse sorted array
        int[] testArray3 = {5, 4, 3, 2, 1};

        System.out.println("=== Test Case 3: Reverse Sorted ===");
        int[] bubbleArray3 = copyArray(testArray3);
        int[] selectionArray3 = copyArray(testArray3);

        printArray(testArray3, "Original array");
        bubbleSort(bubbleArray3);
        printArray(bubbleArray3, "After bubble sort");
        selectionSort(selectionArray3);
        printArray(selectionArray3, "After selection sort");

        System.out.println();

        // Test Case 4: Array with duplicates
        int[] testArray4 = {3, 5, 3, 2, 5, 1, 2};

        System.out.println("=== Test Case 4: With Duplicates ===");
        int[] bubbleArray4 = copyArray(testArray4);
        int[] selectionArray4 = copyArray(testArray4);

        printArray(testArray4, "Original array");
        bubbleSort(bubbleArray4);
        printArray(bubbleArray4, "After bubble sort");
        selectionSort(selectionArray4);
        printArray(selectionArray4, "After selection sort");

        // Performance comparison
        System.out.println("\n=== Performance Analysis ===");
        System.out.println("Complete the following analysis:");
        System.out.println("1. Which algorithm performed fewer comparisons on an already sorted array?");
        System.out.println("   Answer: Optimized bubble sort does fewer comparisons");
        System.out.println("2. Which algorithm performed fewer swaps on a reverse sorted array?");
        System.out.println("   Answer: Selection sort");
        System.out.println("3. What is the worst-case time complexity for bubble sort? O(n^2)");
        System.out.println("4. What is the worst-case time complexity for selection sort? O(n^2)");
        System.out.println("5. What is the best-case time complexity for bubble sort? O(n)");
        System.out.println("6. What is the best-case time complexity for selection sort? O(n^2)");

        System.out.println();

        // Algorithm Tracing Exercise
        System.out.println("\n=== Algorithm Tracing ===");
        System.out.println("1. Trace through the following array step by step for BOTH algorithms:");
        System.out.println("Array: [5, 2, 8, 1, 9]");
        System.out.println();
        System.out.println("Bubble Sort Trace:");
        System.out.println("Pass 1: [2, 5, 1, 8, 9]");
        System.out.println("Pass 2: [2, 1, 5, 8, 9]");
        System.out.println("Pass 3: [1, 2, 5, 8, 9]");
        System.out.println("Pass 4: no swaps needed");
        System.out.println();
        System.out.println("Selection Sort Trace:");
        System.out.println("Pass 1: [1, 2, 8, 5, 9]"); //pass here contains the result of that pass
        System.out.println("Pass 2: [1, 2, 8, 5, 9]");
        System.out.println("Pass 3: [1, 2, 5, 8, 9]");
        System.out.println("Pass 4: [1, 2, 5, 8, 9]");
        System.out.println();
        System.out.println("2. Explain why bubble sort can be optimized but selection sort cannot:");
        System.out.println("Bubble sort can be optimized but selection sort cannot. This is because bubble sort can stop early when a full pass makes no swaps as it's proven that the data set is already sorted. " +
                "However, selection sort still has to scan the remaining unsorted portion of the data set each pass to confirm what the smallest element is. " +
                "Hence, even if the data set is already sorted, it still performs the same comparisons.");

        System.out.println("3. Explain how you would implement this optimisation within your bubble sort algorithm:");
        System.out.println("I would implement this optimisation by adding an if statement to see if any swaps occured during a pass. " +
                "If no swaps occured, the code would break.");
    }
    
}
