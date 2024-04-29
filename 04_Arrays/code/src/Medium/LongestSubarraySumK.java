package Medium;

import java.util.HashMap;

public class LongestSubarraySumK {
    public static void main(String[] args) {
        int[] arr_positives = {2,3,5,1,1,1,1,6};
        int K = 10; // Output: 5
        int ans = optimal_only_positives(arr_positives, K);
        System.out.println(ans);
    }

    public static void brute_only_positives(int[] arr) {
        // Generate all sub-arrays
        // Return whichever is the longest with sum K
        // TC: O(n^2)
        // SC: O(1)
    }

    public static int better_both(int[] arr, int K) {
        // Hashing
        // Prefix Sum

        // TC: O(N * 1)
        // SC: O(N)

        // Array: {1, 5, 3, 6}
        // PrefixSum: {1, 6, 9, 15}

        // Hash the sums till each index => [sum, index]
        // In each loop, check each key in hashmap for complementary value
        // Eg: K = 2, 6 exists in hashmap => find 4 in hashmap => get length

        HashMap<Integer, Integer> map = new HashMap<>();
                int sum = 0;
                int max = 0;

                for (int i = 0; i < arr.length; i++) {
                    sum += arr[i];
                    if (sum == K) {
                        // i + 1, because we need length, starting from 0 index
                        max = Math.max(max, i+1);
            }

            if (map.containsKey(sum - K)) {
                int prevIndex = map.get(sum - K);

                // QUESTION: Why 'i - prevIndex' in original? Why no +1? => DO DRY RUN FOR ANS!
                // Bcs, we need to count from prevIndex's next index
                // Eg: K = 10, [0...2] (index) => sum = 4, [3...7] (index) => sum = 14
                // PrevIndex = 2, i = 7
                // Actual Length = 7 - 2 = 5
                max = Math.max(max, i-prevIndex);
            }
            if (!map.containsKey(sum)) {
                // Only add if iNOT already in map, to get the farthest value
                map.put(sum, i);
            }
        }

        return max;
    }

    public static int optimal_only_positives(int[] arr, int K) {
        // 2-Pointer

        // TC:
        // SC:

        // Take 2 pointers
        // Keep moving 'j' pointer till sum equals or exceeds K
        // Keep track of sum, length between the pointers
        // When sum exceeds K, move 'i' pointer to right

        int i = 0;
        int j = 0;

        int sum = 0;
        int max = 0;

        while (j < arr.length) {
            sum += arr[j];

            while (i <= j && sum > K) {
                sum -= arr[i];
                i++;
            }

            if (sum == K) {
                // Why +1 here?
                // Eg: {1, 2, 3}, K = 3
                // i = 0, j = 1 for sum == K
                // j - i + 1 = 2 = actual length
                max = Math.max(j - i + 1, max);
            }

            // By here, sum != K, and while loop ran till sum !> K, so sum < K
            // So, we can move 'j' to right
            j++;
        }
        return max;
    }
}
