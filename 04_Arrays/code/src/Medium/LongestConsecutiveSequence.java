package Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = {};
        // Output: 4 => 5, 6, 7, 8

        System.out.println(better(arr));

    }

    public static int better(int[] arr) {
        // Sort the array: NlogN
        // Search for consecutive subsequence: N

        Arrays.sort(arr);

        int longest = 1;
        int last_num = arr.length > 0 ? arr[0] : 0;
        for (int i : arr) {
            if (i == last_num) {
                continue;
            } else {
                if (i == (last_num + 1)) {
                    last_num = i;
                    longest++;
                } else {
                    last_num = i;
                }
            }
        }
        return longest;
    }

    public static int optimal(int[] arr) {
        // Put everything in HashSet: O(N + (logN || 1))
        // Query the HashSet for next elements: O(2N)
        // O(2N) because set will be traversed at max of 2 times
        // When reverse sorted sequence is there.
        // Worst case example: {5, 4, 3, 2, 1}

        // TC: O(3N)

        HashSet<Integer> set = new HashSet<>();
        int longest = 0;

        for (int i : arr) {
            set.add(i);
        }

        for (int i : set) {
            // Check if current element is first in subsequence
            // NOTE: HashSet orders elements by default so this is only for learning
            if (!set.contains(i - 1)) {
                int count = 1;
                int num = i;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                longest = Math.max(longest, count);

            }
        }








        return longest;
    }
}
