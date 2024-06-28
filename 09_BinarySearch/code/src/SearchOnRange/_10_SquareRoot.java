package SearchOnRange;

public class _10_SquareRoot {
    public static void main(String[] args) {

    }

    public static int floorSqrt(int n) {

        int low = 1;
        int high = n;
        int val = n;
        while (low <= high) {
            int mid = low + (high - low)/2;
            val = mid * mid;

            if (val <= n) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return val;
    }

}
