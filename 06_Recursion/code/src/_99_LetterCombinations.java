import java.util.ArrayList;
import java.util.List;

public class _99_LetterCombinations {
    public static void main(String[] args) {
        List<String> ans = letterCombinations("23");
        System.out.println(ans);


    }
    public static List<String> letterCombinations(String digits) {
        String[] keys = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        System.out.println(keys[digits.charAt(1) - '0']);
        List<String> ans = new ArrayList<>();
        find(keys, 0, digits, "", ans);


        return ans;
    }

    public static void find(String[] keys, int index, String digits, String combo, List<String> ans) {
        // base
        if (index == digits.length()) {
            String temp = new String(combo);
            ans.add(combo);
            return;
        }
        String str = keys[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            find(keys, index+1, digits, combo+(keys[digits.charAt(index) - '0'].charAt(i)), ans);
        }
    }
}
