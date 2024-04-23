package Easy;

public class MoveAllZerosToEnd {
    public static void main(String[] args) {

        // Note: Order of non-zero elements must be maintained

        int[] arr = {1, 0, 2, 3, 0, 4, 0, 1};

        int firstZeroIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                firstZeroIndex = i;
                break;
            }
        }
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
