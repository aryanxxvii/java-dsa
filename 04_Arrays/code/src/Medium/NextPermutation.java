package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 5, 4};
        int N = arr.length;

        List<Integer> ans = nextPermutation(N, arr);
        System.out.println(ans);
    }
    static List<Integer> nextPermutation(int N, int[] arr){
        // Find pivot
        int pivotIndex = findPivotIndex(arr);
        // If no pivot: reverse whole array
        if (pivotIndex == -1) {
            Arrays.sort(arr);
        }
        // If pivot:
        else {

            // get next greatest element
            int indexNextGreatest = findNextGreatestIndex(arr, pivotIndex);

            // swap with pivot element with next greatest element
            int temp = arr[pivotIndex];
            arr[pivotIndex] = arr[indexNextGreatest];
            arr[indexNextGreatest] = temp;

            // sort all to right of pivot
            Arrays.sort(arr, pivotIndex + 1, arr.length);

        }
        List<Integer> ansList = new ArrayList<>();

        for (int i : arr) {
            ansList.add(i);
        }

        return ansList;
    }

    // Gives index of pivot: defaults to -1
    public static int findPivotIndex(int[] arr) {
        for (int i = arr.length-1; i > 0; i--) {
            if (arr[i] > arr[i-1]) {
                return i-1;
            }
        }
        return -1;
    }

    public static int findNextGreatestIndex(int[] arr, int pivotIndex) {
        int currNextGreatest = Integer.MAX_VALUE;
        int indexNextGreatest = pivotIndex;
        for (int i = pivotIndex + 1; i < arr.length; i++) {
            if (arr[i] > arr[pivotIndex] && arr[i] < currNextGreatest) {
                currNextGreatest = arr[i];
                indexNextGreatest = i;
            }
        }
        return indexNextGreatest;
    }
}
