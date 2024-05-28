import java.sql.Array;
import java.util.ArrayList;

public class _99_SubsetSums {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] a = {5, 2, 1};
        for (int i : a) {
            arr.add(i);
        }
        ArrayList<Integer> ans = subsetSums(arr, arr.size());
        System.out.println(ans);
    }

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        find(arr, 0, 0, ans);
        return ans;
    }

    public static void find(ArrayList<Integer> arr, int index, int sum, ArrayList<Integer> ans) {
        if (index == arr.size()) {
            ans.add(sum);
            return;
        }

        // Take - Add
        // Call and Move
        find(arr, index + 1, sum + arr.get(index), ans);
        // Don't take - Remove
        // Call and Move
        find(arr, index + 1, sum, ans);
    }




}
