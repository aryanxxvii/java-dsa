import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Aryan", 29);
        map.put("Sarthak", 25);
        int marks = map.get("Aryan");
        System.out.println(marks);
    }
}