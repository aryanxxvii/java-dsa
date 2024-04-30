package Medium;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 2}; // 2 1 3
        int[] arr2 = {3,2,1};
        int[] arr3 = {5, 4, 3, 1, 2, 3, 0};
        int[] ans = optimal(arr3);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] optimal(int[] arr) {
        int pivot = -1;

        // Find pivot value => if value at i is less than next value, it is pivot,
        for (int i = 0; i < arr.length - 1;  i++) {
            if (arr[i] < arr[i+1]) {
                pivot = i;
            }
        }



        // If no pivot, reverse whole array and return
        if (pivot == -1) {
            reverseToRight(arr, 0);
            return arr;
        }

        // Find next greatest element to swap with pivot value
        int nextGreatest = Integer.MAX_VALUE;
        int nextGreatestIndex = pivot;
        for (int i = pivot; i < arr.length; i++) {
            if (arr[i] > arr[pivot]) {
                if (arr[i] < nextGreatest) {
                    nextGreatest = arr[i];
                    nextGreatestIndex = i;
                }
            }
        }
        int temp = arr[nextGreatestIndex];
        arr[nextGreatestIndex] = arr[pivot];
        arr[pivot] = temp;



        // Reverse right half of pivot
        reverseToRight(arr, pivot + 1);
        return arr;
    }


    // UTILITY FUNCTIONS
    public static void reverseToRight(int[] arr, int start) {
        int end = (arr.length - 1);
        int mid = (start + end)/2;
        while (start <= mid) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
