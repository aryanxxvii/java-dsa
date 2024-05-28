import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _99_CombinationSum2 {

    public static void main(String[] args) {
        int[] arr = {  5, 1, 2, 3, 3 };
        int n = arr.length;
        int k = 7;
        Arrays.sort(arr);
        List<List<Integer>> ans = CombinationSum2(arr, n, k );
        System.out.println(ans);

    }

    public static List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        find(arr, k, 0, 0, new ArrayList<>(), ans);
        return ans;

    }

    public static void find(int[] arr, int k, int index, int sum, List<Integer> list, List<List<Integer>> ans) {
        if (index == arr.length || sum > k) {
            if (sum == k) {
                Collections.sort(list);
                if (!ans.contains(list)) ans.add(new ArrayList<>(list));
            }
            return;
        }

        // Take
        list.add(arr[index]);
        // Call
        find(arr, k, index + 1, sum + arr[index], list, ans);
        // Don't take
        list.remove(list.size() - 1);
        // Call
        find(arr, k, index + 1, sum, list, ans);
    }



}
