package Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {7, 7, 2, 6, 7, 3, -8, -1};
        int K = 4;

        ArrayList<ArrayList<Integer>> ans = optimal(arr, K);
        System.out.println(ans);

    }

    public static ArrayList<ArrayList<Integer>> optimal(int[] arr, int K) {
        // Sort Array
        // Inside For-loop: choose num1
            // Skip duplicates
            // Inside For-loop: choose num2
                // Skip duplicates
                // Inside For-loop: Take 2 pointers: start, end
                // Apply Two-Sum algo
                // Skip duplicates

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (j > i + 1 && arr[j] == arr[j-1]) continue;

                int x = j + 1;
                int y = arr.length - 1;

                while (x < y) {
                    int sum = arr[i] + arr[j] + arr[x] + arr[y];

                    if (sum == K) {
                        ArrayList<Integer> tempList = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[x], arr[y]));
                        if (!ans.contains(tempList)) {
                            ans.add(tempList);
                        }
                        x++;
                        y--;

                        while (x < y && arr[x] == arr[x-1]) x++;
                        while (x < y && arr[y] == arr[y+1]) y--;
                    } else if (sum > K) {
                        y--;
                    } else if (sum < K) {
                        x++;
                    }
                }
            }
        }
        return ans;

    }
}
