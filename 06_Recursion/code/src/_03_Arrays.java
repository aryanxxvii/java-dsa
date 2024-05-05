public class _03_Arrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4};
//        System.out.println(checkIfSorted(arr, 0));
        System.out.println(linearSearch(arr, 0, 3));
    }

    public static boolean checkIfSorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }

        return arr[index] < arr[index+1] && checkIfSorted(arr, index+1);
    }

    public static int linearSearch(int[] arr, int index, int find) {
        if (index == arr.length-1) {
            return -1;
        }

        if (arr[index] == find) {
            return index;
        }

        return linearSearch(arr, index+1, find);
    }

}
