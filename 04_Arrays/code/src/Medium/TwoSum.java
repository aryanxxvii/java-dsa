package Medium;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int K = 14; // Output: {1, 3}
        int[] ans = optimal(arr, K);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static void brute(int[] arr, int K) {
        // Nested for-loop

        // TC: O(N^2)
        // SC: O(1)
    }

    public static int[] better(int[] arr, int K) {
        // Hashing

        // Put everything in hashmap
        // Check if complementary value exists in each loop

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = {-1, -1};
        for (int i = 0; i < arr.length; i++) {
            int rem = K - arr[i];
            if (map.containsKey(rem)) {
                int j = map.get(rem);
                ans[0] = j;
                ans[1] = i;
                return ans;
            }
            map.put(arr[i], i);
        }
        return ans;
    }

    public static int[] optimal(int[] arr, int K) {
        // 2-Pointer
        // Put one pointer at start
        // Put one pointer at end
        // Move both closer depending on need

        int i = 0;
        int j = arr.length-1;
        int[] ans = {-1, -1};
        while (i <= j) {
            int sum = arr[i] + arr[j];
            if (sum == K) {
                ans[0] = i;
                ans[1] = j;
                return ans;
            } else if (sum < K) {
                i++;
            } else {
                j--;
            }
        }

        return ans;


    }
}
