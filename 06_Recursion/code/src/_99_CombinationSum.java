import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int[] arr = { 1, 2, 3, 3, 5 };
        int k = 7;

        List<List<Integer>> ans = CombinationSum2(arr, arr.length, k);
        System.out.println(ans);

    }


    public static List<List<Integer>> CombinationSum2(int[] arr, int n, int k) {
        // Code Here
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> takenElements = new ArrayList<>();

        compute(ans, arr, k, takenElements, 0);

        return ans;
    }

    public static void compute(List<List<Integer>> ans, int[] arr, int k, List<Integer> takenElements, int sum) {

        if (sum == k) {
            List<Integer> temp = new ArrayList<>(takenElements);
            if (!ans.contains(temp)) {
                ans.add(temp);
            }
        }

        if (arr.length == 0) {
            return;
        }

        int toAdd = arr[0];
        takenElements.add(toAdd);
        compute(ans, Arrays.copyOfRange(arr, 1, arr.length), k, takenElements , sum+toAdd);

        takenElements.remove(takenElements.size()-1);
        compute(ans, Arrays.copyOfRange(arr, 1, arr.length), k, takenElements, sum);
    }
}
