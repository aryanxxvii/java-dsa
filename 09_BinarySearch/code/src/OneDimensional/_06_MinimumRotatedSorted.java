package OneDimensional;

public class _06_MinimumRotatedSorted {
    public static void main(String[] args) {
    }

    public static int minimum(int[] arr) {
        // Find sorted half
        // Compare ans with minimum value in sorted half
        // Eliminate sorted half

        int low = 0;
        int high = arr.length;
        int ans = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = low + (high - low)/2;

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                ans = Math.min(arr[low], ans);
                high = mid - 1;
            } else if (arr[mid] <= arr[high]) {
                ans = Math.min(arr[mid], ans);
                low = mid + 1;
            }
        }
        return ans;
    }
}
