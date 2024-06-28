package SearchOnRange;

public class _15_ShipPackagesDDays {
    public static void main(String[] args) {

    }

    public static int findDays(int[] arr, int capacity) {
        int days = 1;
        int load = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + load > capacity) {
                days += 1;
                load = arr[i];
            } else load += arr[i];
        }
    return days;
    }

    public static int answer(int[] arr, int d) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i : arr) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }

        while (low <= high) {
            int mid = low + (high - low)/2;
            int numberOfDays = findDays(arr, mid);
            if (numberOfDays <= d) {
                high = mid - 1;
            } else low = mid + 1;
        }
    return low;
    }
}
