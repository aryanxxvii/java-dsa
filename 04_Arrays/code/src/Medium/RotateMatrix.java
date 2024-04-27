package Medium;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
                };
        optimal(arr);
        for (int[] i_arr : arr) {
            System.out.println(Arrays.toString(i_arr));
        }
    }

    public static void optimal(int[][] arr) {
        // Transpose the matrix
        // Reverse each row of the matrix


        // Transpose
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[i].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Reverse rows
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr.length-1 - j];
                arr[i][arr.length-1 - j] = temp;
            }
        }
    }


}
