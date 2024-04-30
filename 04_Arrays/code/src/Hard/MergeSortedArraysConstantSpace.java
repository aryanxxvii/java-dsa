package Hard;

import java.util.Arrays;

public class MergeSortedArraysConstantSpace {
    // In original arrays, reshuffle elements to merge
    // {1, 3, 5, 7} & {0, 2, 6, 8, 9}
    // =>
    // {0, 1, 2, 3} & {5, 6, 7, 8, 9}
    // Cannot create third array

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};

        optimal(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void optimal(int[] arr1, int[] arr2) {
        // Take 2 pointers
        // Place i at end of arr1
        // Place j at start of arr2
        // arr1[i] is the largest element of arr1
        // arr2[j] is the smallest element of arr2
        // If arr1[i] < arr2[j], no need to do anything: return;
        // Else: swap & move i to left and j to right
        // Sort both arrays individually

        int i = arr1.length-1;
        int j = 0;
        while (i >= 0 && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                break;
            } else {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }
}
