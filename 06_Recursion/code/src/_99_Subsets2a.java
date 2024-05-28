import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class _99_Subsets2a {
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        ArrayList<ArrayList<Integer>>ans = printUniqueSubsets(nums);
        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        find(nums, set, 0,  new ArrayList<>(), ans, nums.length);
        return ans;
    }

    public static void find(int[] nums, HashSet<ArrayList<Integer>> set,int index, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans, int length) {
        if (index == length) {
            if (!set.contains(list)) {
                ArrayList<Integer> temp = new ArrayList<>(list);
                ans.add(temp);
                set.add(temp);
            }
            return;
        }

        // Take
        list.add(nums[index]);
        find(nums, set, index + 1, list, ans, length);
        // Don't Take
        list.remove(list.size() - 1);
        find(nums, set, index + 1, list, ans, length);

    }
}



