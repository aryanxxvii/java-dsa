package OneDimensional;

public class _04_SearchRotatedSorted {
    public static void main(String[] args) {

    }

    public static int search(int[] arr, int k) {
        // Find sorted half by first/last index of array and compare with mid
        // Check if k is in sorted half
        // Move accordingly

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == k) {
                return mid;
            }

            // if left half is sorted
            else if (arr[low] <= arr[mid]) {
                // if target is in sorted half
                if (arr[low] <= k && k <= arr[mid]) {
                    high = mid - 1;
                } else low = mid + 1;
            // if right half is sorted
            } else {
                if (arr[high] >= k && k >= arr[mid]) {
                    low = mid + 1;
                } else high = mid - 1;
            }
        }
        return -1;
    }
}
