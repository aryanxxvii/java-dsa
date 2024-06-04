package Easy;

public class SearchInRotatedSorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 4;
        int ans = find(arr, k);
        System.out.println(ans);
    }

    public static int find(int[] arr, int k) {
        // Identify Sorted Half using mid

        // Check if element lies in sorted half by comparing first, last and element
        int ans = -1;

        int low = 0;
        int high = arr.length-1;
        int mid = low + (high - low)/2;


        while (high >= low) {
            mid = low + (high - low)/2;

            if (arr[mid] == k) {
                ans = mid;
            }
// check right half
            if (arr[mid] <= arr[high]) {
                if (k >= arr[mid] && arr[high] >= k) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else {
                if (arr[mid] >= k && arr[low] <= k) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            // right half sorted
            if (arr[mid] <= arr[high]) {
                // k lies in sorted half
                if (arr[high] >= k && k >= arr[mid]) {
                    // move low to mid+1
                    low = mid+1;
                // k lies in other half
                } else {
                    high = mid-1;
                }

            // left half sorted
            } else if (arr[mid] >= arr[low]) {
                // k lies in sorted half
                if (arr[low] <= k && arr[mid] >= k) {
                    high = mid-1;

                } else {
                    low = mid+1;
                }
            }
        }
        return ans;
    }

}
