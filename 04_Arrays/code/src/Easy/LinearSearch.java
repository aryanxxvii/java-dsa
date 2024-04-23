package Easy;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4, 5, 5, 5, 6, 7};
        int find = 4;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == find) {
                System.out.println(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(-1);
        }
    }
}
