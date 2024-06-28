package SearchOnRange;

public class _18_BookAllocation {
    public static void main(String[] args) {

    }

    public static int allocate(int[] arr, int m) {

        // Max Value in array
        int low = Integer.MIN_VALUE;
        // Sum of all values in array
        int high = 0;

        for (int i : arr) {
            low = Math.max(low, i);
            high += i;
        }

    }
}
