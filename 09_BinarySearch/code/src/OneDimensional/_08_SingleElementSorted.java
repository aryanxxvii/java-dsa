package OneDimensional;

public class _08_SingleElementSorted {
    public static void main(String[] args) {

    }

    public static int findSingle(int[] arr) {
        int n = arr.length;

        // (even, odd) => Left half of single element
        // (odd, even) => Right half of single element

        // Edge Cases
        if (n == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[n-1] != arr[n-2]) return arr[n-1];

        int low = 1;
        int high = n-2;
        while (low <= high) {
            int mid = low + (high - low)/2;

            // If mid is the single element
            if (arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]) return mid;

            // We are in left half of single element
            // If mid is on odd index, pair should be on the left index
            // If mid is on even index, pair should be on the right index
            if ((mid%2 == 1 && arr[mid] == arr[mid-1]) ||
                (mid%2 == 0 && arr[mid] == arr[mid+1])
            ) {
                // Eliminate left half
                low = mid + 1;

            // We are in the right half of single element
            } else if (
                    (mid%2 == 1 && arr[mid] == arr[mid+1]) ||
                    (mid%2 == 0 && arr[mid] == arr[mid-1])
            ) {
                // Eliminate right half
                high = mid - 1;
            }
        }
        return -1;
    }
}
