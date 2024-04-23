package Easy;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {1, 11, 7, 8, 2, 3, 5, 6, 8};
        int largest = arr[0];
        int second_largest = Integer.MIN_VALUE;

        for (int i : arr) {
            if ((largest > i) && (i > second_largest)) {
                second_largest = i;
            }
            largest = Math.max(largest, i);

        }
        System.out.println(second_largest);
    }
}
