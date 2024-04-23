package Easy;

public class FindOnceOthersTwice {
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        int ans = 0;
        for (int i : arr) {
            ans = ans ^ i;
        }

        // XOR of same will cancel each other
        // Only unique element will be remaining

        System.out.println(ans);
    }
}
