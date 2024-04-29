package Hard;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,-4,-1,2};
        int K = 0;
        ArrayList<ArrayList<Integer>> ans = better(arr, K);
        System.out.println(ans);

    }

    public static ArrayList<ArrayList<Integer>> better(int[] arr, int K) {
        // Hashing => set

        // TC: O(N^2)
        // SC: O(N)

        // Make a set
        // Start with 2 pointers, i = 0, j = 1
        // Move j++
        // With every j-move, add the previous value of j to the map
        // Check if 'z = K - (i + j)' exists in the map
            // If exists, add [i, j, z] if NOT already in answer array
        // When j reaches end, reset the map, and move i++

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int inum1 = 0; inum1 < arr.length - 1; inum1++) {
            HashSet<Integer> set = new HashSet<>();
            for (int inum2 = inum1 + 1; inum2 < arr.length; inum2++) {
                ArrayList<Integer> tempList = new ArrayList<>();

                int remaining = K - (arr[inum1] + arr[inum2]);

                if (set.contains(remaining)) {
                    tempList.add(arr[inum1]);
                    tempList.add(arr[inum2]);
                    tempList.add(remaining);

                    Collections.sort(tempList);
                    if (!ans.contains(tempList)) {
                        ans.add(tempList);
                    }
                }
                set.add(arr[inum2]);
            }
            set.clear();
        }

        return ans;


    }

    public static ArrayList<ArrayList<Integer>> optimal(int[] arr, int K) {
        // Sort the array
        // Keep 1 index fixed (start form 0)
        // Apply Two Sum (2-pointer algo) to its right
        // Skip duplicates in each step

        int n = arr.length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k]));
                    ans.add(temp);
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return ans;
    }
}
