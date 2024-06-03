import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class _99_Permutations {

    public static void main(String[] args) {
        int[] a = {1, 2, 1};
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : a) {
            arr.add(i);
        }
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ans = uniquePerms(arr, arr.size());
        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[n];
        Collections.sort(arr);  // Ensure the initial array is sorted
        find(arr, new ArrayList<>(), used, ans);
        return ans;
    }

    public static void find(ArrayList<Integer> arr, ArrayList<Integer> current, boolean[] used, ArrayList<ArrayList<Integer>> ans) {
        if (current.size() == arr.size()) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (used[i]) continue;
            if (i > 0 && arr.get(i) == arr.get(i - 1) && !used[i - 1]) continue; // Skip duplicates

            used[i] = true;
            current.add(arr.get(i));
            find(arr, current, used, ans);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
