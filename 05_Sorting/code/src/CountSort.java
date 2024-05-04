import java.util.Arrays;

public class CountSort {
    // Only for small numbers
    // TC can even be O(N)

    // Make count array which keeps count of element X at index X
    // If array is {1, 3, 2, 3}
    // Count array will be  {0, 1, 1, 2}
    //                      {0, 1, 2, 3} => Indices
    // Kind of like hashmaps
    // Can optimize space by taking count array from range of elements instead of 0

    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 3, 2, 4, 3, 7};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }

        int[] count = new int[maxElement+1];

        for (int i : arr) {
            count[i]++;
        }

        int arrPointer = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                for (int c = 0; c < count[i]; c++) {
                    arr[arrPointer++] = i;
                }
            }
        }
    }
}
