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
