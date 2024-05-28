import java.util.*;

public class _99_CombinationSum {
    /*
        Input:
            n = 5, k = 7
            arr[] = { 1, 2, 3, 3, 5 }
        Output:
            { { 1, 3, 3 }, { 2, 5 } }
        Explanation:
            1 + 3 + 3 = 7
            2 + 5 = 7
     */

    public static void main(String[] args) {
        int[] a = {7, 2, 6, 5};
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : a) {
            arr.add(i);
        }
        int k = 16;
        ArrayList<ArrayList<Integer>> ans = combinationSum(arr, k);
        System.out.println(ans);
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);
        find(A, B, 0, 0, new ArrayList <>(), ans);
        return ans;
    }

    public static void find(ArrayList<Integer> arr, int k, int index, int sum, ArrayList<Integer> total, ArrayList<ArrayList<Integer>> ans) {
        if (index == arr.size() || sum > k) {
            if (sum == k) {
                Collections.sort(total);
                if (!ans.contains(total)) ans.add(new ArrayList<>(total));
            }
            return;
        }

        // Take
        total.add(arr.get(index));
        // Don't move forward
        find(arr, k, index, sum + arr.get(index), total, ans);
        // Don't take
        total.remove(total.size() - 1);
        // Move forward
        find(arr, k, index+1, sum, total, ans);
    }


}