package Medium;

import java.util.ArrayList;

public class Leaders {
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        optimal(arr);
    }

    public static void optimal(int[] arr) {
        // Move from right to left
        // Check if new element is greater than current max

        ArrayList<Integer> ans = new ArrayList<>();
        int current_max = Integer.MIN_VALUE;
        for (int i = arr.length-1; i >= 0; i--) {
            if (i == arr.length-1) {
                current_max = arr[i];
                ans.add(arr[i]);
            } else {
                if (arr[i] > current_max) {
                    current_max = arr[i];
                    ans.add(arr[i]);
                }
            }
        }

        for (int i : ans.reversed()) {
            System.out.print(i + " ");
        }

    }
}

