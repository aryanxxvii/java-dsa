package Hard;

import java.lang.reflect.Array;
import java.util.*;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] arr2 = {{1, 4}, {4, 5}};
        List<List<Integer>> ans = optimal(arr2);
        System.out.println(ans);
    }

    public static List<List<Integer>> brute(int[][] arr) {
        // Add elements covered in original array to Set
        // Loop through set to find consecutive elements
        // Add start, end of each consecutive-set to tempList

        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> givenNums = new HashSet<>();

        for (int[] inside : arr) {
            for (int i = inside[0]; i <= inside[inside.length-1]; i++) {
                givenNums.add(i);
            }
        }
        Iterator<Integer> it = givenNums.iterator();

        while(it.hasNext()) {
            int num = it.next();
            List<Integer> tempList = new ArrayList<>();
            int start = num;
            int end = num;
            while (givenNums.contains(num+1)) {
                num++;
                end = num;
                if (it.hasNext()) it.next();
            }

            tempList.add(start);
            tempList.add(end);
            ans.add(tempList);
        }
        return ans;
    }

    public static List<List<Integer>> optimal(int[][] arr) {
        // Sort the [][]array
        // Check if end of previous group is less than start of next group
            // Check first element of next []arr and last element of arraylist ans
        // If yes, merge them
        // {1, 4}, {3, 5} => 3 < 4 => {1, 5}
        // If not, form new interval

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // Form new interval condition
            if (ans.isEmpty() || arr[i][0] > ans.getLast().get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                // Merge both

                // To handle {{2, 5}, {3, 4}}, where next group is subset, so we need Max, otherwise 5 will get replaced by 4 in ans
                int newEnd = Math.max(ans.getLast().get(1), arr[i][1]);
                ans.getLast().set(1, newEnd);
            }
        }



        return ans;
    }
}
