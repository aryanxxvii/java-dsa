package OneDimensional;

public class _09_Peak {
    public static void main(String[] args) {

    }

    public static int peak(int[] arr) {
        int n = arr.length;

        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 1;
        if (arr[n-1] > arr[n-2]) return n-1;

        int low = 1;
        int high = n-2;

        while (low <= high) {
            int mid = low + (high - low)/2;

            // Element is peak
            if (
                    arr[mid] > arr[mid - 1] &&
                    arr[mid] > arr[mid + 1]
            ) return mid;

            // Element is on increasing slope => peak is on right side
            else if (
                 arr[mid] > arr[mid - 1]
            ) low = mid + 1;

            // Element is on increasing slope => peak is on left side
            // Don't use 'else if' because mid can be at local minimum
            /*

                \      /
                 \    /
                  \  /
                   \/ => mid => neither on increasing slope, nor decreasing slope

             */
            else high = mid - 1;
        }
        return -1;
    }

}
