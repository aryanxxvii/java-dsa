package Medium;

import java.util.Arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] arr1 = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
                };
        int[][] arr = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
                };

        optimal(arr);
        for (int[] i_arr : arr) {
            System.out.println(Arrays.toString(i_arr));
        }
    }

    public static void optimal(int[][] arr) {
        // Store zero positions in rows, columns
        // Go over the rows, column arrays and change the initial array
        // NOTE: Can move additional arrays inside the original array to save space

        boolean[] rows = new boolean[arr.length]; // Initially 'false'
        boolean[] cols = new boolean[arr[0].length]; // Initially 'false'

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == 0) {
                    rows[row] = true;
                    cols[col] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                setRowZero(arr, i);
            }
        }
        for (int i = 0; i < cols.length; i++) {
            if (cols[i]) {
                setColZero(arr, i);
            }
        }
    }

    // UTILITY FUNCTIONS
    public static void setColZero(int[][] arr, int K) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][K] = 0;
        }
    }
    public static void setRowZero(int[][] arr, int K) {
        Arrays.fill(arr[K], 0);
    }
}
