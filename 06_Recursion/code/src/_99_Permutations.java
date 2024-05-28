import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class _99_Permutations {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : a) {
            arr.add(i);
        }
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ans = uniquePerms(arr, arr.size());
        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        find(0, n, arr, new Integer[n], new HashSet<ArrayList<Integer>>(), ans);
        return ans;
    }

    public static void find(int index, int n, ArrayList<Integer> given, Integer[] arr, HashSet<ArrayList<Integer>> set, ArrayList<ArrayList<Integer>> ans) {
        // for every element, use for loop to place it at all available positions one by one
        // after each placement, call recursion for the next

        if (index == n) {
            ArrayList<Integer> list = new ArrayList<>();
            for (Integer i : arr) {
                list.add(i);
            }
            if (!set.contains(list)) {
                ans.add(list);
                set.add(list);
            }
            return;
        }

        for (int i = 0; i < n; i++){
            int toAdd = given.get(index);
            if (arr[i] == null) {
                arr[i] = toAdd;
                find(index+1, n, given, arr, set, ans);
                arr[i] = null;
            }
        }
    }
}
