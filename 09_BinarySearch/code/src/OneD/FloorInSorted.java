package OneD;

public class FloorInSorted {
    public static int findFloor(long arr[], int n, long x)
    {
        int low = 0;
        int high = arr.length;
        int mid = low + (high - low)/2;
        int ans = -1;
        while (high > low) {
            mid = low + (high - low)/2;
            if (arr[mid] > x) {
                high = mid;
            } else {
                ans = mid;
                low = mid+1;
            }
        }

        return ans;
    }
}
