package SearchOnRange;

import java.util.Arrays;
import java.util.Collections;

public class _13_MBouquets {
    public static void main(String[] args) {

    }

    public static boolean possible(int[] arr, int days, int m, int k) {
        int count = 0;
        int bouquets = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= days) count++;
            else {
                bouquets += count/k;
                count = 0;
            }
        }
        bouquets += count/k;
        return bouquets >= m;
    }

    public static int find(int arr[], int m, int k) {

        // Not enough flowers
        if (m * k > arr.length) return -1;

        // Find min and max of array for binary search range
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for (int i : arr) {
            mini = Math.min(i, mini);
            maxi = Math.max(i, maxi);
        }

        int low = mini;
        int high = maxi;
        int ans = maxi;

        // Check possibilities, and eliminate accordingly
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (possible(arr, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans; // CAN ALSO RETURN LOW;
    }
}
