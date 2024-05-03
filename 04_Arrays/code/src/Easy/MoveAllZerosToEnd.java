package Easy;

public class MoveAllZerosToEnd {
    public static void main(String[] args) {

        // Note: Order of non-zero elements must be maintained

        int[] arr = {1, 0, 2, 3, 0, 4, 0, 1};

        int firstZeroIndex = 0;

        // Find first zero index
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                firstZeroIndex = i;
                break;
            }
        }

        // Iterate through array from firstZeroIndex to end
        // If non-zero found
            // Send it to firstZeroIndex
            // Move firstZeroIndex to next position

        // {0f, 1, 0, 0, 4} => {1, 0f, 0, 0, 4} => { 1, 4, 0f, 0, 0}


        for (int i = firstZeroIndex; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[firstZeroIndex] = arr[i];
                arr[i] = 0;
                firstZeroIndex++; // Move current firstZero to next position
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
