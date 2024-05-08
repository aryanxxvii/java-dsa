import java.util.Arrays;

public class MergeSort {
    // Divide and conquer
    // Sort both halves separately, recursively
    // Merge the two sorted parts

    // Base condition: Length of array = 1

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1, 5};
        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                merged[k] = left[i];
                k++;
                i++;
            } else {
                merged[k] = right[j];
                k++;
                j++;
            }
        }

        while (i < left.length) {
            merged[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length) {
            merged[k] = right[j];
            k++;
            j++;
        }

        return merged;
    }
}
