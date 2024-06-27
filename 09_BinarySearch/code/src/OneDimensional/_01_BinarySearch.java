package OneDimensional;

public class _01_BinarySearch {
    public static void main(String[] args) {

    }

    public static int binarySearch(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arr[mid] == k) return mid;
            else if (arr[mid] < k) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int recBinarySearch(int[] arr, int k, int low, int high) {

        if (low > high) {
            return -1;
        }
        int mid = low + (high - low)/2;
        if (arr[mid] == k) {
            return mid;
        } else if (arr[mid] < k) {
            return recBinarySearch(arr, k, low, mid-1);
        } else {
            return recBinarySearch(arr, k, mid+1, high);
        }
    }
}
