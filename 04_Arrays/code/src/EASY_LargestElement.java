public class EASY_LargestElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 8, 1, 3, 5};
        int largest = Integer.MIN_VALUE;
        for (int i : arr) {
            largest = Math.max(largest, i);
        }
        System.out.println(largest);
    }
}
