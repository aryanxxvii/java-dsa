package OneDimensional;

public class _02_Bound_SearchInsert_FloorCeil {
    public static void main(String[] args) {

    }

    public static int lowerBound(int[] arr, int k) {
        // Lower Bound: Smallest number >= x
        // Upper Bound: Smallest number > x (Strictly greater)

        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] >= k) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }

    public static void searchInsertPosition(int[] arr, int k) {
        // Same as Lower Bound
        // Insert at Lower Bound position
    }

    public static void ceil() {
        // Ceil: Smallest number >= x : Same as Lower Bound
    }

    public static int floor(int[] arr, int k) {
        // Floor: Largest number <= x

        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] <= mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
