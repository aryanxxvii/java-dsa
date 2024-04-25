package Medium;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4}; // Output: 6
        int ans = optimal(arr);
        System.out.println(ans);
    }

    public static void brute(int[] arr) {
        // Find out all sub-arrays
    }

    public static int optimal(int[] arr) {
        // Kadane's Algorithm

        // Move through the array
        // Keep track of sum and max
        // If sum < 0, make sum = 0
        // Don't carry negative sum forward

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            sum += i;
            if (sum < 0) {
                sum = 0;
            } else {
                max = Math.max(max, sum);
            }
        }

        // To consider sum of empty array as 0
        max = Math.max(0, max);

        return max;
    }
}
