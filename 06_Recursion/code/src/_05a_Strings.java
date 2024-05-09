public class _05a_Strings {
    public static void main(String[] args) {
//        String ans = removeLetter("Hello", "", 0, 'l');
//        String ans = removeLetter2("Hello", 0, 'l');
        String ans = removeString("Hello I am Aryan", "Aryan");

        System.out.println(ans);
    }

    // WITH newStr as parameter
    public static String removeLetter(String givenStr, String newStr, int position, char toRemove) {
        // Base condition
        if (position == givenStr.length()) {
            return newStr;
        }

        // Send as it is
        if (givenStr.charAt(position) == toRemove) {
            return removeLetter(givenStr, newStr, position + 1, toRemove);
        }

        // Append a character
        return removeLetter(givenStr, newStr + givenStr.charAt(position), position+1, toRemove);
    }

    // WITHOUT newStr => direct return
    public static String removeLetter2(String givenStr, int position, char toRemove) {
        // Recurrence Relation:
        // F(string) = current_char/"" + F(string-1)

        if (position == givenStr.length()) {
            return "";
        }

        if (givenStr.charAt(position) == toRemove) {
            return removeLetter2(givenStr, position + 1, toRemove);
        }

        return givenStr.charAt(position) + removeLetter2(givenStr, position + 1, toRemove);
    }

    public static String removeString(String givenStr, String toRemove) {
        if (givenStr.isEmpty()) {
            return "";
        }

        if (givenStr.startsWith(toRemove)) {
            return removeString(givenStr.substring(toRemove.length()), toRemove);
        }

        return givenStr.charAt(0) + removeString(givenStr.substring(1), toRemove);

    }
}
