import java.util.Arrays;

public class InbuiltSort {
    public static void main(String[] args) {
        // TC: O(NlogN)

        int[] arr = {5, 4, 1, 3, 2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
