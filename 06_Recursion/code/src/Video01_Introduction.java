public class Video01_Introduction {

    /*
        ===== INTRODUCTION TO RECURSION =====

        -> Recursion:    Function calling itself
        -> Base Condition:   Condition where recursion will stop making new calls
                            Without Base Condition => stack overflow
        -> Recurrence Relation: Recursion in the form of a formula. Eg. Fib(N) = Fib(N-1) + Fib(N-2)
        - Can convert any recursion solution into iteration and vice versa
        - Applications in Dynamic Programming
        - Space complexity

        - Try to see if there is a smaller version of the big problem
            - If yes, solve using recursion

        - Make sure to return the result of the function call of the return type

     */

    public static void main(String[] args) {
        System.out.println(nthFibonacciNumber(6));

        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(recursiveBinarySearch(arr, 3, 0, arr.length-1));
    }

    public static int nthFibonacciNumber(int n) {
        // Step 1: Find recurrence relation
            // Fib(N) = Fib(N-1) + Fib(N-2)
                // Can apply recursion because 1 big problem has been broken down in to 2
                // Fib(5) = Fib(4) + Fib(3) => [ Fib(3) + Fib(2) ] + [ Fib(2) + Fib(1) ] => ...
        // Step 2: Find base condition
            // If N < 2, return N

        if (n < 2) {
            return n;
        }
        return nthFibonacciNumber(n-1) + nthFibonacciNumber(n-2);
    }

    /*

        ====== WORKING WITH VARIABLES IN RECURSION =====

        Types of variables
        - Arguments
        - Return
        - Body of function

     */

    public static int recursiveBinarySearch(int[] arr, int target, int start, int end) {
        // Comparing
        // Dividing into 2 halves

        // Recurrence Relation: F(N) = O(1) + F(N/2)

        if (start > end) {
            // Did not find target
            return -1;
        }

        int mid = start + (end - start)/2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            // Make sure to return the result of the function call of the return type
            // ! If the next recursion call results in 'mid' or '-1', we won't get the result without this return
            return recursiveBinarySearch(arr, target, start, mid - 1);
        }

        // else
        return recursiveBinarySearch(arr, target, mid + 1, end);

    }
}
