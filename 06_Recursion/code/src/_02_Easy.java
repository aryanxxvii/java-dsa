public class _02_Easy {
    public static void main(String[] args) {
//        printNto1(5);
//        print1toN(5);
//        printNto1toN(5);
//        System.out.print(factorial(5));
//        System.out.println(sumNto1(10));
//        System.out.println(sumOfDigits(123));
//        System.out.println(reverseNumber(123, 0));
        System.out.println(countZeros(30204, 0));
    }

    public static void printNto1(int n) {
        System.out.print(n + " ");
        if (n > 1) {
            // Since return type is 'void', no need to return, simply call
            printNto1(n-1);
        }
    }

    public static void print1toN(int n) {
        // First call the function, then print
        // It will reach till n = 1, then start printing upwards
        if (n > 1) {
            print1toN(n-1);
        }
        System.out.print(n + " ");
    }

    public static void printNto1toN(int n) {
        // Base Condition
        if (n == 0) {
            return;
        }

        // Recurrence Relation
        System.out.print(n + " ");
        printNto1toN(n-1);
        System.out.print(n + " ");
    }

    public static int factorial(int n) {
        // Base condition => N == 0
        if (n == 0) {
            return 1;
        }

        // Factorial(N) = N * Factorial(N-1)
        return n * factorial(n-1);
    }

    public static int sumNto1(int n) {
        // Base Condition => N == 0/1 (handle last case)
        if (n == 1) {
            return 1;
        }
        // Sum(N) = N + Sum(N)
        return n + sumNto1(n-1);
    }

    public static int sumOfDigits(int n) {
        // Base Condition => N == 0
        if (n == 0) {
            return 0;
        }

        // Relation
        // SumOfDigits(N) = SumOfDigits(First...SecondLast) + LastDigit
        // F(123) => F(12) + 3
        // 123 % 10 = 3
        int lastDigit = n % 10;
        n = n / 10;
        return sumOfDigits(n) + lastDigit;
    }

    public static int reverseNumber(int a, int i) {
        if(a == 0) {
            return i;
        } else {
            // Add this digit to last by x10 prev part
            i = i*10 + a%10;
            return reverseNumber(a/10, i);
        }
    }

    public static int countZeros(int n, int c) {
        int digit = n % 10;
        n = n / 10;
        if (n == 0) {
            return c;
        }

        if (digit == 0) {
            return countZeros(n, c + 1);
        }
            return countZeros(n, c);
    }

}
