package OneD;

public class CountRotations {
    // find minimum element index
    // get length of rotated part by comparing with total length
    // index is the number of rotations

    public static int findKRotation(int arr[], int n) {
        // code here

        int high = n-1;
        int low = 0;
        int mid = 0;

        int min = 0;


        while (high >= low) {
            mid = low + (high - low)/2;

            // check if left is sorted
            if (arr[low] <= arr[mid]) {
                min = arr[low] < arr[min] ? low : min;
                low = mid + 1;
            } else {
                min = arr[mid] < arr[min] ? mid : min;
                high = mid -1;
            }
        }

        return min;


    }
}
