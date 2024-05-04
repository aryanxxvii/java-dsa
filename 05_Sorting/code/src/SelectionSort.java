import java.util.Arrays;

public class SelectionSort {
/*
    Pick the smallest element from unsorted part, put it at the beginning fo unsorted

    {3, 2, 1} => {1, 3, 2} => {1, 2, 3}
 */

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 3, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            // Array is sorted till i

            int smallestIndex = i;

            // Find the smallest value to right of sorted part
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallestIndex] > arr[j]) {
                    smallestIndex = j;
                }
            }

            // Bring smallest element to end of sorted part
            int temp = arr[smallestIndex];
            arr[smallestIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
