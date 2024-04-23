package Easy;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class UnionOfTwoSorted {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = {2,3,4,4,5,11,12};

        ArrayList<Integer> Union = new ArrayList<>();



        int index1 = 0;
        int index2 = 0;
        while ((index1 < arr1.length) && (index2 < arr2.length)) {
            if (arr1[index1] == arr2[index2]) {
                Union.add(arr1[index1]);
                index1++;
                index2++;
            } else if (arr1[index1] > arr2[index2]) {
                Union.add(arr2[index2]);
                index2++;
            } else {
                Union.add(arr1[index1]);
                index1++;
            }
        }

        while (index1 < arr1.length) {
            Union.add(arr1[index1]);
            index1++;
        }
        while (index2 < arr2.length) {
            Union.add(arr2[index2]);
            index2++;
        }


        // Output: {1,2,3,4,5,6,7,8,9,10,11,12}

        System.out.println(Union);

    }



}
