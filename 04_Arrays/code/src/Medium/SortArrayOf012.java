package Medium;

public class SortArrayOf012 {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        optimal(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void better(int[] arr) {
        // Count number of 0, 1, 2
        // Replace in another loop

        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for (int i : arr) {
            if (i == 0) {
                zeros++;
            } else if (i == 1) {
                ones++;
            } else {
                twos++;
            }
        }
        System.out.println(zeros + " " + ones + " " + twos);
        for (int i = 0; i < zeros; i++) {
            arr[i] = 0;
        }
        for (int i = zeros; i < zeros + ones; i++) {
            arr[i] = 1;
        }
        for (int i = zeros + ones; i < arr.length; i++) {
            arr[i] = 2;
        }

    }

    public static void optimal(int[] arr) {
        // Dutch National Flag Algorithm
        // Use 3 pointers: low, mid, high

        // [0...low-1] => 0
        // [low...mid-1] => 1
        // [mid...high] => {0, 1, 2}
        // [high+1...n-1] => 2

        // Start: low = 0; mid = 0; high = end

        // Todo: Sort [mid...high]

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while(mid <= high) {
            switch (arr[mid]) {
                case 0: {
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                }

                case 1: {
                    mid++;
                }

                case 2: {
                    int temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                }
            }
        }




    }
}
