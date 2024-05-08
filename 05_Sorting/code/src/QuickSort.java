public class QuickSort {
    // Choose a pivot element
    // After first pass, all elements less than pivot should be on left, and others on right
    // Basically, pivot will be at its correct position

    public static void main(String[] args) {

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start)/2;
        int pivot = arr[mid];

        while (start <= end) {

            // If already sorted, it will not swap
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }

        }

        // pivot is at correct index
        // sort the two halves now

        quickSort(arr, low, end);
        quickSort(arr, start, high);

    }

}
