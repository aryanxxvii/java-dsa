package SearchOnRange;

import java.util.Arrays;

public class _17_AggressiveCows {
    public static void main(String[]args) {

    }

    public static boolean canBePlaced(int[] arr, int cows, int dist) {

        // Place first cow at first index
        int countCows = 1;
        int lastCow = 0;
        for (int i = 1; i < arr.length; i++) {
            if (countCows == cows) return true;
            if (arr[i] - arr[lastCow] >= dist) {
                countCows++;
                lastCow = i;
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] arr, int cows) {
        Arrays.sort(arr);

        // Range => min(array) to max(array)
        // Range will have possible maximum minimum distances
        // Apply BS on this Range
        // Place 1st Cow on arr[0]
        // Place next cow as soon as distance between them is Range[mid]
        // If all cows CANNOT be placed with distance between them = Range[mid]
            // high = mid - 1;
        // If all cows CAN be placed separated by Range[mid],
            // low = mid + 1;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (canBePlaced(arr, cows, arr[mid])) low = mid + 1;
            else high = mid - 1;

        }
        return high;
    }
}
