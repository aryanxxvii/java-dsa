package Hard;

import java.util.HashMap;

public class CountSubarraysXorK {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int K = 6;

        System.out.println(optimal(arr, K));
    }

    public static int optimal(int[] arr, int K) {
        // Hashing
        // Prefix-XOR => [xor, count]
        // Insert (0, 1) in map initially

/*
        Inverse of XOR = XOR
            If you have: c = a^b;
            You can get a or b back if you have the other value available:
            a = c^b; // or b^c (order is not important)
            b = c^a; // or a^c

        XOR of number with 0 = number
*/

        HashMap<Integer, Integer> map = new HashMap<>();
        int currentXor = 0;
        int finalCount = 0;

        map.put(0, 1);

        for (int i : arr) {
            currentXor = currentXor ^ i;
            // x ^ K (total till i) = currentXor (total till i)
            // x = currentXor ^ K
            int neededXor = currentXor ^ K;
            if(map.containsKey(neededXor)) {
                int already = map.get(neededXor);
                finalCount += already;
                map.put(neededXor, already);
            }

            if (map.containsKey(currentXor)) {
                int already = map.get(currentXor);
                map.put(currentXor, already + 1);

            } else {
                map.put(currentXor, 1);
            }
        }
        return finalCount;

    }
}
