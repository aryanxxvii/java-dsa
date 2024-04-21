public class Main {
    public static void main(String[] args) {

//        String Equality
        String x = "Aryan";
        String y = "Aryan";
        String z = new String("Aryan");

        System.out.println(x == y);
        System.out.println(x == z);
        System.out.println(x.equals(z));

//    StringBuilder
        StringBuilder builder = new StringBuilder();
        builder.append("Aryan"); // Aryan
        builder.setCharAt(0, 'X'); // Xryan - same object
        System.out.println(builder.toString());

    }
}