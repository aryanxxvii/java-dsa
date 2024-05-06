public class _04_Patterns {
    public static void main(String[] args) {
        triangle(5, 0);
        invertedTriangle(5, 0);
    }

    public static void triangle(int r, int c) {
        /*
            Print (n = 4):
            * * * *
            * * *
            * *
            *

            Decide the placement of the recursive call by looking at the output.
            Here, first we print N-Stars, so the value of N becomes smaller after each call.
            So, first print N-Stars, then call the recursive call for N-1.

            If we were to print inverted triangle, first we would have printed 1 Star, then 2 Stars ... then N stars.
            Here the value of N should first go from N to 1 from the recursive calls, then for printing, 1 to N.
            So, first call the recursive call for N-1, then start printing from down to up.
         */
        if (r == 0) {
            return;
        }

        if (c < r) {
            System.out.print("* ");
            triangle(r, c+1);
        } else {
            System.out.println();
            triangle(r-1, 0);
        }
    }

    public static void invertedTriangle(int r, int c) {
        if (r == 0) {
            return;
        }

        if (c < r) {
            invertedTriangle(r, c+1);
            System.out.print("* ");
        } else {
            invertedTriangle(r-1, 0);
            System.out.println();
        }
    }

}
