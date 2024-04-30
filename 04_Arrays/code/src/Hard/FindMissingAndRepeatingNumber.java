package Hard;

import java.util.Arrays;

public class FindMissingAndRepeatingNumber {
    public static void main(String[] args) {
        int[] arr = {3,1,2,5,3}; // 3, 4
        int[] ans = optimal(arr);
        System.out.println(Arrays.toString(ans));

    }

    public static void better(int[] arr) {
        // Hashing
        // Keep count of each number
        // Return numbers with count 2 and 0
    }

    public static int[] optimal(int[] arr) {
        // Take sum of all numbers in array => actualSum
        // Take sum till max number (array length) => theoreticalSum
        // actualSum - theoreticalSum = X - Y
        // sum of squares of actual nums - sum of squares of theoretical nums = X^2 - Y^2
        // solve the two equations
        int n = arr.length;
        int tSum = n*(n+1)/2;
        int aSum = 0;
        for ( int i : arr ) {
            aSum += i;
        }

        // X - Y
        int e1 =  aSum - tSum;

        int tSqSum = n * (n+1) * (2*n+1) / 6;
        int aSqSum = 0;
        for (int i : arr) {
            aSqSum += i*i;
        }

        // X^2 - Y^2
        int e2 = aSqSum - tSqSum;

        // X + Y
        int e3 = e2/e1;

        // X,  Y
        int X = (e1 + e3) / 2;
        int Y = e3 - X;

        int[] ans = new int[2];
        ans[0] = X;
        ans[1] = Y;

        return ans;
    }

}
