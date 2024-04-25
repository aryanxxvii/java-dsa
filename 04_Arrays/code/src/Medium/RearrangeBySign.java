package Medium;

import java.util.ArrayList;

public class RearrangeBySign {
    public static void main(String[] args) {
        int[] arr_equal = {1, 2, -3, -4};
        // Output: {1,-3,2,-4}

        int[] arr_unequal = {1,2,-4,-5,3,4};
        // Output: {1,-4,2,-5,3,4}

        int[] ans_equal = optimal_equal(arr_equal);
        for (int i : ans_equal) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] ans_unequal = optimal_unequal(arr_unequal);
        for(int i : ans_unequal) {
            System.out.print(i + " ");
        }
    }

    public static void brute(int[] arr) {
        // Make positive & negative arrays
        // Separate both
        // Merge both

        optimal_unequal(arr);
    }

    public static int[] optimal_equal(int[] arr) {
        // Positives -> even indices
        // Negatives -> odd indices
        // Make new array and place

        int[] ans = new int[arr.length];
        int p = 0;
        int n = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                ans[n] = arr[i];
                n += 2;
            } else {
                ans[p] = arr[i];
                p += 2;
            }
        }

        return ans;


    }

    public static int[] optimal_unequal(int[] arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int[] ans = new int[arr.length];

        for (int i : arr) {
            if (i < 0) {
                neg.add(i);
            } else {
                pos.add(i);
            }
        }

        if (pos.size() < neg.size()) {
            for (int i = 0; i < pos.size(); i++) {
                ans[2 * i] = pos.get(i);
                ans[2 * i + 1] = neg.get(i);
            }

            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                ans[index] = neg.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < neg.size(); i++) {
                ans[2 * i] = pos.get(i);
                ans[2 * i + 1] = neg.get(i);
            }

            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                ans[index] = pos.get(i);
                index++;
            }
        }
        return ans;


    }
}
