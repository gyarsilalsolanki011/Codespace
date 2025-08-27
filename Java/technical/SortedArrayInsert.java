import java.util.Scanner;

// Short the given array and then insert given variable
public class SortedArrayInsert {

    // Custom method to sort array (Bubble Sort)
    public static void sortArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Method to insert element in sorted order
    public static int[] insertInSortedOrder(int[] arr, int element) {
        int n = arr.length;
        int[] newArr = new int[n + 1];

        int i = 0;
        // Copy elements smaller than element
        while (i < n && arr[i] < element) {
            newArr[i] = arr[i];
            i++;
        }

        // Insert element at correct position
        newArr[i] = element;

        // Copy remaining elements
        while (i < n) {
            newArr[i + 1] = arr[i];
            i++;
        }

        return newArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Step 1: Sort
        sortArray(arr);
        System.out.print("Sorted Array: ");
        printArray(arr);

        // Step 2: Insert element at correct place
        System.out.print("Enter element to insert: ");
        int element = sc.nextInt();

        int[] newArr = insertInSortedOrder(arr, element);

        System.out.print("Array after insertion: ");
        printArray(newArr);

        sc.close();
    }
}
