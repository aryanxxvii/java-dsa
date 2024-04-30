package Medium;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr1 = {2,1,3,1,4}; // 2 3 1
        int[] arr2 = {3,2,1}; // 1 2 3
        optimal(arr1);
    }

    public static int[] optimal(int[] arr) {
        // Find the element till where next array will remain same
        // That element will be the last pivot element
        // 5 4 3 1p 2 3
        // 3 is the pivot
        // Now swap this with the smallest number to the right of pivot: 1
        // 5 4 3 2p 3 1
        // Now sort the array to the right of pivot
        // ANS: 5 4 3 2 1 3

        int[] ans = new int[arr.length];
        int pivot = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i+1]) {
                pivot = i;
            }
        }
        System.out.println(pivot);
        reverseToRight(arr, pivot);
        Arrays.sort(arr, pivot, arr.length-1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        return ans;
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
