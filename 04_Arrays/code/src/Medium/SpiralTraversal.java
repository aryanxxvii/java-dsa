package Medium;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        answer(arr);
    }

    public static void answer(int[][] arr) {
        // Keep boundary variables
        // Decrease boundaries after each iteration


        int left = 0;
        int right = arr[0].length-1;
        int top = 0;
        int bottom = arr.length-1;
        while (left <= right || top <= bottom) {
            for (int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;

            // We need to check if top <= bottom before this loop
            // To cover {1, 2, 3, 4} etc. single array
            // top will move beneath bottom in 1-D array
            // So it will print 1, 2, 3, 4, 3, 2, 1
            // Left to Right, then again Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] +  " ");
                }
                left++;
            }
        }
    }
}
