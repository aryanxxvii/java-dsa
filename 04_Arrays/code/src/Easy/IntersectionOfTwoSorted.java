package Easy;

import java.sql.Array;
import java.util.ArrayList;

public class IntersectionOfTwoSorted {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 3, 4, 5, 6};
        int[] arr2 = {3, 3, 5};

        ArrayList<Integer> Intersection = new ArrayList<>();

        int index1 = 0;
        int index2 = 0;

        while ((index1 < arr1.length) && (index2 < arr2.length)) {
            if (arr1[index1] == arr2[index2]) {
                Intersection.add(arr1[index1]);
                index1++;
                index2++;
            } else if (arr1[index1] < arr2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        System.out.println(Intersection); // Output: {3, 3, 5}

    }
}
