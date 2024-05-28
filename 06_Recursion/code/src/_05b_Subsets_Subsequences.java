import java.util.ArrayList;

public class _05b_Subsets_Subsequences {
    public static void main(String[] args) {
        subsequences3("abcd", "");
    }

    public static void subsequences(String givenStr, String newStr) {
        // To print all subsequences, each element has 2 options: take, and not take
        // Make 2 calls for each character, all the element to newStr in one case, don't add in the other case

        // Base condition
        if (givenStr.isEmpty()) {
            System.out.println(newStr);
            return;
        }
        char toAdd = givenStr.charAt(0);
        subsequences(givenStr.substring(1), newStr + toAdd);
        subsequences(givenStr.substring(1), newStr);
    }

    // Return ArrayList
    public static ArrayList<String> subsequences2(String givenStr, String newStr) {
        if (givenStr.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(newStr);
            return list;
        }

        char toAdd = givenStr.charAt(0);
        ArrayList<String> left = subsequences2(givenStr.substring(1), newStr + toAdd);
        ArrayList<String> right = subsequences2(givenStr.substring(1), newStr);

        left.addAll(right);

        ArrayList<String> combined = new ArrayList<>(left);
        return combined;
    }


    public static void subsequences3(String givenStr, String newStr) {

            if (givenStr.length() == 0) {
                System.out.println(newStr);
                return;
            }

            // don't add char
            subsequences3(givenStr.substring(1), newStr);
            // add char
            char toAdd = givenStr.charAt(0);
            subsequences3(givenStr.substring(1), newStr + toAdd);
    }

}

