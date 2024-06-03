

class SudokuSolver {
    public static void main(String[] args) {
        int[][] grid = {
                {9, 5, 7, 0, 1, 3, 0, 8, 4},
                {4, 8, 3, 0, 5, 7, 1, 0, 6},
                {0, 1, 2, 0, 4, 9, 5, 3, 7},
                {1, 7, 0, 3, 0, 4, 9, 0, 2},
                {5, 0, 4, 9, 7, 0, 3, 6, 0},
                {3, 0, 9, 5, 0, 8, 7, 0, 1},
                {8, 4, 5, 7, 9, 0, 6, 1, 3},
                {0, 9, 1, 0, 3, 6, 0, 7, 5},
                {7, 0, 6, 1, 8, 5, 4, 0, 9}
        };

        boolean valid = SolveSudoku(grid);
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + "  ");
            }
            System.out.println();
        }
    }

    static boolean SolveSudoku(int[][] grid)
    {
        // add your code here

        boolean valid = find(grid, false, 0, 0, 1);
        return valid;

    }

    //Function to print grids of the Sudoku.
    static void printGrid (int[][] grid)
    {
        // add your code here
    }

    static boolean find(int[][] grid, boolean valid, int currCol, int currRow, int toPut) {
        if (currRow > 8) {
            valid = true;
            return valid;
        }

        if (currCol > 8) {
            find(grid, valid, 0, currRow+1, 1);
            return valid;
        }

        if (toPut > 9) {
            return false;
        }

        if (currRow < 9 && currRow < 9) {
            if (grid[currRow][currCol] == 0) {
                // check left
                boolean isValidInRow = true;
                boolean isValidInCol = true;
                for (int i = 0; i < 9; i++) {
                    if (grid[currRow][i] == toPut) {
                        isValidInRow = false;
                    }
                    if (grid[i][currCol] == toPut) {
                        isValidInCol = false;
                    }
                }

                if (!isValid)

                if (isValidInRow && isValidInCol) {
                    grid[currRow][currCol] = toPut;
                    find(grid, valid, currCol+1, currRow, 1);
                } else {
                    find(grid, valid, currCol, currRow, toPut+1);
                }
            } else {
                find(grid, valid, currCol+1, currRow, 1);
            }
        }




        return valid || false;
    }






}

