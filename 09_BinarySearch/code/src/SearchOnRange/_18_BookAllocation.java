package SearchOnRange;

import java.util.Scanner;

public class _18_BookAllocation {
    public static void main(String[] args) {
        // ALL BOOKS AND STUDENTS MUST BE EXHAUSTED!!!!!!

/*
16
2 5 6 15 19 25 43 49 60 64 70 80 83 90 90 97
14
*/

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int ans = allocate(arr, m);
        System.out.println(ans);

    }

    public static int findStudentsReq(int[] arr, int maxPages) {
        int students = 1;
        int currentPages = 0;
        for (int pages : arr) {
            if (currentPages + pages > maxPages) {
                students++;
                currentPages = pages;
            }
            else {
                currentPages += pages;
            }
        }
        return students;
    }

    public static int allocate(int[] arr, int m) {

        // Max Value in array
        int low = Integer.MIN_VALUE;
        // Sum of all values in array
        int high = 0;
        int studentsReq = -1;
        for (int i : arr) {
            low = Math.max(low  , i);
            high += i;
        }


        while (low <= high) {
            int mid = low + (high - low)/2;
            studentsReq = findStudentsReq(arr, mid);
            if (studentsReq > m) low = mid + 1;
            else high = mid - 1;
        }

        return findStudentsReq(arr, low) == m ? low : -1;

    }
}
