import java.util.ArrayList;
import java.util.List;

public class _06_Permutations {
    /*

        1. ""/abc
        2. _a_/bc => can add b/c at either _ (underscore) positions
        3. _a_b_/c => can add c at any of the 3 _ positions

        To Note:
            - After each layer, the choices, and thereby, the following recursive calls increase (len(left_string) + 1)
            - Can use simple for-loop to make recursion calls
     */


    public static void main(String[] args) {
        String givenStr = "abc";
        List<String> ans = new ArrayList<>();
        permutations(ans, givenStr, "");
        System.out.println(ans);

        int count = countPermutations(givenStr, "");
        System.out.println(count);

    }

    public static void permutations(List<String> ans, String givenStr, String newStr) {
        if (givenStr.isEmpty()) {
            ans.add(new String(newStr));
            return;
        }

        char toAdd = givenStr.charAt(0);

        for (int i = 0; i <= newStr.length(); i++) {
            String left = newStr.substring(0, i);
            String right = newStr.substring(i);
            permutations(ans,  givenStr.substring(1), left + toAdd + right);
        }
    }


    public static int countPermutations(String givenStr, String newStr) {

        if (givenStr.isEmpty()) {
            return 1;
        }

        char toAdd = givenStr.charAt(0);
        int count = 0;
        for (int i = 0; i < newStr.length() + 1; i++) {
            String left = newStr.substring(0, i);
            String right = newStr.substring(i);
            count = count + countPermutations(givenStr.substring(1), left + toAdd + right);
        }

        return count;

    }
}

