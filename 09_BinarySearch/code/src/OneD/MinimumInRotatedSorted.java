package OneD;

public class MinimumInRotatedSorted {
    // keep ans = int_max
    // find sorted half
    // get smallest value from sorted half (first element)
    // put it in ans if smaller
    // pick non sorted half
    // repeat


    public static int findMin(int arr[], int n)
    {
        //complete the function here
        // keep track of minimum , compare with mid at each step
        // choose unsorted array always

        int high = n-1;
        int low = 0;
        int mid = 0;
        int min = Integer.MAX_VALUE;

        while (high >= low) {
            mid = low + (high - low)/2;

            // check if left is sorted
            if (arr[low] <= arr[mid]) {
                min = Math.min(arr[low], min);
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }

        return min;


    }
}
