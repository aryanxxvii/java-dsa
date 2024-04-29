package Hard;

import java.util.Arrays;

public class MajorityElement2 {
    public static void main(String[] args) {
        // Find integers appearing >N/3 times
        int[] arr = {11,33,33,11,33,11};
        int[] ans = optimal(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static void better(int[] arr) {
        // Hashmap

        // TC: O(N) * O(logN)
        // SC: O(N)

        // Make a map, [num, count]
        // Iterate over array
        // Add num to map, increase count
        // If count > N floor 3: add to answer
    }

    public static int[] optimal(int[] arr) {
        // Voting Algorithm
        // Keep 2 count vars, and 2 element vars
        // Order of conditions is important

        int[] ans = {-1, -1};

        int first = arr[0];
        int second = arr[0];
        int firstCount = 0;
        int secondCount = 0;

        for (int i : arr) {
            if (i == first) {
                firstCount++;
            } else if (i == second) {
                secondCount++;
            } else if (firstCount == 0) {
                first = i;
                firstCount = 1;
            } else if (secondCount == 0) {
                second = i;
                secondCount = 1;
            } else {
                firstCount--;
                secondCount--;
            }
        }

        int firstCheck = 0;
        int secondCheck = 0;

        for (int i : arr) {
            if (i == first) {
                firstCheck++;
            } else if (i == second) {
                secondCheck++;
            }
        }

        if (firstCheck > arr.length/3) {
            ans[0] = first;
        }
        if (secondCheck > arr.length/3) {
            ans[1] = second;
        }

        return ans;
    }
}
