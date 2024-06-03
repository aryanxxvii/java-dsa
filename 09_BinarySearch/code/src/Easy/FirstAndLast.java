package Easy;

import java.util.ArrayList;

public class FirstAndLast {
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        int n1 = findFirst(arr, x);
        int n2 = -1;
        if (n1 != -1) {
            n2 = findLast(arr, x);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(n1);
        ans.add(n2);
        return ans;
    }

    public static int findFirst(int arr[], int k) {
        int low = 0;
        int high = arr.length;
        int mid = 0;
        int ans = -1;

        while (high > low) {
            mid = low + (high - low)/2;

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

    public static int findLast(int arr[], int k) {
        int low = 0;
        int high = arr.length;
        int mid =0;
        int ans = -1;
        while (high > low) {
            mid = low + (high - low)/2;
            if (arr[mid] == k) {
                ans = mid;
                low = mid+1;
            } else if (arr[mid] > k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
