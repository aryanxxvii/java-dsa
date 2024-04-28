package Hard;

import java.util.ArrayList;

public class PascalTriangle {
    /*
    - Variation 1:
        - Given row, col, tell number at that position
    - Variation 2:
        - Given row, print complete row
    - Variation 3:
        - Given row, print complete triangle till that row
    */

    public static void main(String[] args) {

        int ansOne = variationOne(4, 2);
        System.out.println(ansOne);

        ArrayList<Integer> ansTwo = variationTwo(4);
        System.out.println(ansTwo);

        ArrayList<ArrayList<Integer>> ansThree = variationThree(4);
        System.out.println(ansThree);

    }

    public static int variationOne(int row, int col) {
        // Formula: (r-1) C (c-1)

        int n = row - 1;
        int r = col - 1;

        return choose(n, r);
    }

    public static ArrayList<Integer> variationTwo(int row) {
        // Nth row has N elements
        // Run 'choose()' for each element

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ans.add(choose(row - 1, i));
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> variationThree(int row) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            for (int j = 0; j < row; j++) {
                int val = choose(i, j);
                temp.add(val);
            }
            ans.add(temp);
        }
        return ans;
    }

    // UTILITY FUNCTIONS
    public static int choose(int n, int r) {
        int ans = 1;

        for (int i = 0; i < r; i++) {
            ans = ans * (n-i);
            ans = ans / (i+1);
        }
        return ans;
    }
}


