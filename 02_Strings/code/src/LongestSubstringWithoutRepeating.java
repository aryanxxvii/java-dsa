import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        int num = longestSubstrDistinctChars("geeksforgeeks");
        System.out.println(num);
    }

    static int longestSubstrDistinctChars(String S){
        // code here
        int max = 0;

        int left = 0;
        int right = 0;

        HashSet<Character> set = new HashSet<>();

        while (right < S.length()) {
            char ch = S.charAt(right);
            if (set.contains(ch)) {
                while (left < right && set.contains(ch)) {
                    set.remove(S.charAt(left));
                    left++;
                }
            }
            set.add(S.charAt(right));
            right++;
            max = Math.max(max, right - left);
        }
return max;
    }
}
