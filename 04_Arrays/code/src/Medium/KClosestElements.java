package Medium;

import java.util.ArrayList;

public class KClosestElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

                ArrayList<Integer> ans = findKClosest(arr, arr.length, 8, 20);
        int[] ansarr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansarr[i] = ans.get(i);
        }

        System.out.println(ans);
    }

    public static ArrayList<Integer> findKClosest(int[] arr, int n, int k, int x) {
        int fci = findClosestIndex(arr, n, x);
        ArrayList<Integer> queue = new ArrayList<>();
        if (arr[fci] != x) {
            queue.add(arr[fci]);
            k--;
        }
        int leftPointer = fci-1;
        int rightPointer = fci+1;
        // Make 2 pointers, after checking if they can be places (if elements left)
        while (leftPointer >= 0 && rightPointer < n) {
            if (k == 0) {
                break;
            }
            if ((x - arr[leftPointer]) < (arr[rightPointer] - x)) {
                if (arr[leftPointer] != x) {
                    queue.add(arr[leftPointer]);
                }
                leftPointer--;
            } else {
                if (arr[rightPointer] != x) {
                    queue.add(arr[rightPointer]);
                }
                rightPointer++;
            }
            k--;
        }

        while (leftPointer >= 0 && k > 0) {
            queue.add(arr[leftPointer]);
            leftPointer--;
            k--;
        }

        while (rightPointer < n && k > 0) {
            queue.add(arr[rightPointer]);
            rightPointer++;
            k--;
        }


        return queue;
    }

    // Returns closest index of value closest to x
    // Add the value here to the queue first
    public static int findClosestIndex(int[] arr, int n, int x) {
        int rightClosest = n-1;
        int leftClosest = 0;
        int low = 0;
        int high = n-1;
        int mid = low + (high - low)/2;

        while (low < high) {
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                if ((arr[rightClosest] - x) > (arr[mid] - x)) {
                    rightClosest = mid;
                }
                high = mid;

            } else if (arr[mid] < x) {
                if ((x - arr[leftClosest]) > (x - arr[mid])) {
                    leftClosest = mid;
                }
                low = mid + 1;

            }

            mid = low + (high - low)/2;
        }
        if ((x - arr[leftClosest]) < (arr[rightClosest] - x)) {
            return leftClosest;
        } else {
            return rightClosest;
        }
    }
}
