package OneDimensional;

public class _03_Occurences {
    public static void main(String[] args) {

    }

    public static void firstAndLastOccurences() {
        // If == k:
            // First occurence: change first to mid, go left
            // Last occurence: change last to mid, go right


        // Alternative Way

        // First: Lower Bound
        // Last: Upper Bound - 1

        // Check if element exists in the array:
            // (1) lowerBound() != (n OR -1) &&
            // (2) arr[lowerBound] == k

            // (1) Checks if hypothetical index is not returned (when last value < k)
            // (2) Checks if element exists at lower bound (or greater value was returned)
    }

    public static int firstOccurence(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;
        int first = -1;

        while (low <=  high) {
            int mid = low + (high - low)/2;

            if (arr[mid] == k) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return first;
    }

    public static int lastOccurence(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arr[mid] == k) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return last;
    }
}
