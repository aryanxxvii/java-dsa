package Easy;

public class BinarySearch {
    public static int binarysearch(int arr[], int n, int k) {
        // code here
        int low = 0;
        int high = arr.length;
        int mid = low + (high-low)/2;

        while (high > low) {
            mid = low + (high-low)/2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
