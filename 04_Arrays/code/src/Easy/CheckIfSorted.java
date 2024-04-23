package Easy;

public class CheckIfSorted {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 4, 5};
        int[] arr2 = {3, 5, 2, 4, 2};

        System.out.println(check(arr1));
        System.out.println(check(arr2));

    }

    public static boolean check(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
