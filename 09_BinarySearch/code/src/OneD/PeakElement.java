package OneD;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};

    }


    public static int findPeakElement(int[] arr) {
        int n = arr.length; // Size of array

        // Edge cases:
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;



        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }

            if (arr[mid] < arr[mid+1] && arr[mid] > arr[mid-1]) {
                low = mid + 1;
            }

            else high = mid - 1;
        }

        return -1;


        // check if mid is peak
        // check if /
        // check if \
    }
}
