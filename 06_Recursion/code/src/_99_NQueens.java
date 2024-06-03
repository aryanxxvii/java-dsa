import java.util.ArrayList;

public class _99_NQueens {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = nQueen(4);
        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        find(0, n, new int[n+n], new int[n+n], new int[n], new ArrayList<Integer>(), ans);
        return ans;
    }


    public static void find(int col, int n, int[] diagonalL2R, int[] diagonalR2L, int[] left, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        if (col == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int row = 0; row < n; row++) {

            // check if no diagonal element + no element at left
            if (diagonalL2R[row + col] != 1 && diagonalR2L[n-1 - col + row] != 1 && left[row] != 1) {

                list.add(row+1);
                diagonalL2R[row+col] = 1;
                diagonalR2L[n-1 - col + row] = 1;
                left[row] = 1;

                find(col+1, n, diagonalL2R, diagonalR2L ,left, list, ans);

                list.remove(list.size()-1);
                diagonalL2R[row+col] = 0;
                diagonalR2L[n-1 - col + row] = 0;
                left[row] = 0;
            }

        }
    }


}
