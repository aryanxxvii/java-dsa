package Questions;

import java.util.Arrays;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(checkValid("[[]i]"));

    }

    public static boolean checkValid(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Arrays.asList('{', '(', '[').contains(c)) st.add(c);
            else if (Arrays.asList('}', ')', ']').contains(c)) {
                if (st.isEmpty()) return false;
                char x = st.pop();
                switch (c) {
                    case ']':
                        if ( x != '[' ) return false;
                        break;
                    case '}':
                        if ( x != '{' ) return false;
                        break;
                    case ')':
                        if ( x != '(' ) return false;
                        break;
                }
            }
        }
        return true;
    }

}
