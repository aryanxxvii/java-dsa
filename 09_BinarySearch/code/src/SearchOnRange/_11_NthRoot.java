package SearchOnRange;

public class _11_NthRoot {
    public static void main(String[] args) {

    }

    public static int nthroot(int k, int n) {
        int low = 1;
        int high = k;

        while (low <= high) {
            int mid = low + (high - low);
            int ans = 1;


            // TO STOP MULTIPLICATION ASAP, REMOVE OVERFLOW
            // 1 if == k
            // 0 if < k
            // 2 if > k
            int midN = 0;
            for (int i = 1; i <= n; i++) {
                ans = ans * mid;
                if (ans > k) {
                    midN = 2;
                } else if (ans == k) {
                    midN = 1;
                } else {
                    midN = 0;
                }
            }

            if (midN == 1) return mid;
            else if (midN == 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
