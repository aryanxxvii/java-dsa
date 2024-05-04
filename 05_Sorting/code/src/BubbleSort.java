import java.util.Arrays;

public class BubbleSort {
/*
    Large elements come to the end of array by swapping with adjacent elements
    5, 4, 1, 3, 2
    0th Turn:   4, 5, 1, 3, 2
                4, 1, 5, 3, 2
                4, 1, 3, 5, 2
                4, 1, 3, 2, 4
    1st Turn:   Go till n-2
                1, 4, 3, 2, 5 and so on...

*/
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
