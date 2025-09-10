package dsa;

import java.util.Arrays;

/**
 * SortingAlgorithm
 * ----------------
 * A collection of classic sorting algorithms with detailed documentation.
 * 
 * Supported Algorithms:
 *  1. Bubble Sort
 *  2. Selection Sort
 *  3. Insertion Sort
 *  4. Merge Sort
 *  5. Quick Sort
 */

public class SortingAlgorithm {

    /**
     * Bubble Sort
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * Stable: Yes
     */
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Selection Sort
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * Stable: No
     */
    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    /**
     * Insertion Sort
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * Stable: Yes
     */
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    /**
     * Merge Sort
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * Stable: Yes
     */
    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            result[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
        return result;
    }

    /**
     * Quick Sort
     * Time Complexity: O(n log n) [Best/Average], O(n^2) [Worst]
     * Space Complexity: O(log n)
     * Stable: No
     */
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // ----------------- TEST DRIVER -----------------
    public static void main(String[] args) {
        SortingAlgorithm sorter = new SortingAlgorithm();
        int[] arr = {64, 25, 12, 22, 11};

        // Bubble Sort
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        sorter.bubbleSort(arr1);
        System.out.println("Bubble Sort: " + Arrays.toString(arr1));

        // Selection Sort
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        sorter.selectionSort(arr2);
        System.out.println("Selection Sort: " + Arrays.toString(arr2));

        // Insertion Sort
        int[] arr3 = Arrays.copyOf(arr, arr.length);
        sorter.insertionSort(arr3);
        System.out.println("Insertion Sort: " + Arrays.toString(arr3));

        // Merge Sort
        int[] arr4 = sorter.mergeSort(Arrays.copyOf(arr, arr.length));
        System.out.println("Merge Sort: " + Arrays.toString(arr4));

        // Quick Sort
        int[] arr5 = Arrays.copyOf(arr, arr.length);
        sorter.quickSort(arr5, 0, arr5.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(arr5));
    }
}
