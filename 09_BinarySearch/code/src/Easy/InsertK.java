package Easy;

public class InsertK {
    public static int searchInsertK(int Arr[], int N, int k)
    {
        // code here
        return findOrCeil(Arr, k);
    }

    public static int findOrCeil(int arr[], int k) {
        int low = 0;
        int high = arr.length;
        int mid = 0;
        int ans = -1;
        while (high > low) {
            mid = low + (high - low)/2;
            if (arr[mid] == k) {
                ans = mid;
                return ans;
            }
            else if (arr[mid] > k) {
                high = mid;
            } else {
                ans = mid;
                low = mid+1;
            }
        }
        return ans+1;
    }
}
