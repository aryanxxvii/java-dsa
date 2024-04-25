package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement1 {
    public static void main(String[] args) {
        int[] arr = {4,4,2,4,3,4,4,3,2,4}; // Output: 4
        int ans = optimal(arr);
        System.out.println(ans);
    }

    public static int better(int[] arr) {
        // Hashing

        // Keep hashmap -> [element, count]
        // Find count > n/2 in hashmap

        // TC: O(N * 1) + O(N)
        // SC: O(N)

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() > (arr.length/2)) {
                return i.getKey();
            }
        }
        return -1;
    }

    public static int optimal(int[] arr) {
        // Moore's Voting Algorithm

        // Take first element = taken
        // Move through the array
        // Increment count if current element = taken
        // Decrement if NOT = taken
        // If count == 0, change taken to next current element
        // At the end, check if taken is majority by iterating once again

        // LOGIC:
        // When count becomes zero, that portion of array becomes irrelevant
        // The actual majority element will still be majority element of left-over array

        int taken = 0;
        int count = 0;

        for (int i : arr) {
            if (count == 0) {
                taken = i;
            }

            if (i == taken) {
                count++;
            } else {
                count--;
            }
        }

        int check = 0;

        if (count > 0) {
            for (int i : arr) {
                if (i == taken) {
                    check++;
                }
            }
            if (check > arr.length/2) {
                return taken;
            }
        }


        return -1;

    }

    public static int trick(int[] arr) {
        Arrays.sort(arr);
        int candidate = arr[arr.length/2];
        int count = 0;
        for (int i : arr) {
            if (i == candidate) {
                count++;
            }
        }
        if (count > arr.length/2) {
            return candidate;
        }
        return -1;
    }
}
