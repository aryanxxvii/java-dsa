package Easy;

public class LeftRotateByNPlaces {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int N = 3;
        optimal(arr, N); // Output: 4 5 6 7 1 2 3

        for (int k : arr) {
            System.out.print(k + " ");
        }
    }

    public static void brute(int[] arr, int N) {
        // Temp Array Approach
        // Time Complexity: O(N + d)
        // Space Complexity: O(d)
    }

    public static void optimal(int[] arr, int N) {
        if (N == 0) {
            return;
        }

        N = N % (arr.length);

        // Reverse both parts individually
        reverse(arr, N, arr.length-1);
        reverse(arr, 0, N-1);

        // Reverse whole array
        reverse(arr, 0, arr.length-1);



    }


    // Utility Functions
    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
