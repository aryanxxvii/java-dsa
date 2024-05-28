import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class _99_Subsets2b {
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        ArrayList<ArrayList<Integer>>ans = printUniqueSubsets(nums);
        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        find(nums, nums.length, 0, new ArrayList<>(), ans);
        return ans;
    }


    public static void find(int[] nums, int length, int index, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        for (int i = index; i < length; i++) {
            // skip same
            if (i == index) {
                list.add(nums[i]);
                find(nums, length, i+1, list, ans);
                list.remove(list.size() - 1);
            }
            if (i != index && nums[i] != nums[i-1]) {
                list.add(nums[i]);
                find(nums, length, i+1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

}
