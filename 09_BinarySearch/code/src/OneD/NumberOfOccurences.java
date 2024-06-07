package OneD;

public class NumberOfOccurences {
    public static int count(int[] arr, int n, int x) {
        // code here
        int n1 = findFirst(arr, x);
        if (n1 == -1) {
            return 0;
        }
        int n2 = findLast(arr, x);
        return n2 - n1 + 1;

    }

    public static int findFirst(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        int mid = 0;
        int ans = -1;

        while (high > low) {
            mid = low + (high-low)/2;

            if (arr[mid] == k) {
                ans = mid;
                high = mid;
            } else if (arr[mid] > k) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    public static int findLast(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        int mid = 0;
        int ans = -1;

        while(high > low) {
            mid = low + (high - low)/2;
            if (arr[mid] == k) {
                ans = mid;
                low = mid+1;
            } else if (arr[mid] > k) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}
