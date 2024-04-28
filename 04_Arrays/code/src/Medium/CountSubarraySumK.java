package Medium;

import java.util.HashMap;

public class CountSubarraySumK {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int K = 10;
        // Output: 2 => {3, 1, 2}, {2, 4}
        System.out.println(optimal(arr, K));
    }

    public static int optimal(int[] arr, int K) {
        // Hashing
        // Prefix Sum => [sum, count till now]
        // {1, 2, 0, 0, 1, 3}; K = 3
        // Keep track of how many times that sum has come to counter 0s in array
        // Increment count each time that sum is found

        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int remaining = sum - K;
            if (map.containsKey(remaining)) {
                int already = map.get(remaining);
                count += already; // Add to count
            }
            if (map.containsKey(sum)) {
                int already = map.get(sum);
                map.put(sum, already+1);
            } else {
                map.put(sum, 1);
            }

        }

        return count;
    }
}
