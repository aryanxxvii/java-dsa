import java.util.Arrays;

public class InsertionSort {
/*
    Pick an element from unsorted part, place it at correct position in sorted part
    Assume 0th index is sorted part initially

    5s, 4, 1, 3, 2 => Place 4 at correct position in sorted part
    4s, 5s, 1, 3, 2 => Place 1 at correct position in sorted part
    1s, 4s, 5s, 3, 2 and so on...
 */


    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // Array is sorted till i

            int currentElement = arr[i];
            int previousIndex = i - 1;

            // Find correct position of currentElement and move all to right
            while (previousIndex >= 0 && arr[previousIndex] > currentElement) {
                arr[previousIndex + 1] = arr[previousIndex];
                previousIndex--;
            }

            // Place element at correct position
            arr[previousIndex + 1] = currentElement;
        }
    }

}