package Hard;

import javax.swing.*;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = {1,2,-3,0,-4,-5};
        int[] arr2 = {1, 2, -3, 10000, -4, 5, 6, -1, 1, 2}; // will take 2 negatives in ans
        int[] arr3 = {1, 2, -3, 10000, 5, 6, -1, 1, 2}; // Whole array

        int ans = optimal(arr3);
        System.out.println(ans);
    }

    public static int optimal(int[] arr) {
/*
             Move from right to left:
                - Get max suffix product
                - update max if greater
             Move from left to right
                - Get max prefix
                - update max if greater
             Think of 0s as end of array
                {1, 2, 3, 0, 4, 5, 6, 0, 7, 8, 9} => {1, 2, 3} {4, 5, 6} {7, 8, 9}
                => Whenever current max == 0, turn it to 1
*/

        int maxProduct = Integer.MIN_VALUE;
        int prefixProduct = 1;
        int suffixProduct = 1;

        for (int i = 0; i < arr.length; i++) {
            int prefixIndex = i;
            int suffixIndex = arr.length-i-1;

            prefixProduct *= arr[prefixIndex];
            suffixProduct *= arr[suffixIndex];

            if (prefixProduct == 0 ) {
                prefixProduct = 1;
            }
            if (suffixProduct == 0 ) {
                suffixProduct = 1;
            }

            maxProduct = Math.max( Math.max(prefixProduct, suffixProduct), maxProduct );
        }
        return maxProduct;

    }


}
