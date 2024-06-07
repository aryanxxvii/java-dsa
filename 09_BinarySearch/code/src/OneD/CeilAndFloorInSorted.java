package OneD;

import java.util.Arrays;

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}

public class CeilAndFloorInSorted {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        // code here Pair p2 = new Pair(3, 4);
        Arrays.sort(arr);
        int floor = findFloor(arr, x);
        int ceil = findCeil(arr, x);
        return new Pair(floor, ceil);
    }

    public int findFloor(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        int mid = 0;
        int floor = -1;
        while (high > low) {
            mid = low + (high - low)/2;

            if (arr[mid] > k) {
                high = mid;
            } else {
                floor = arr[mid];
                low = mid+1;
            }
        }
        return floor;

    }

    public int findCeil(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        int mid = 0;

        int ceil = -1;
        while (high > low) {
            mid = low + (high - low)/2;

            if (arr[mid] >= k) {
                ceil = arr[mid];
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return ceil;

    }
}
