import java.util.ArrayList;
import java.util.List;

public class _07_DiceRoll {
    /*
        Given a number K, find number of ways to get sum K using N-dice rolls
     */

    public static void main(String[] args) {
        dice("", 4);
    }

    public static void dice(String rolls, int K) {
        if (K == 0) {
            System.out.println(rolls);
            return;
        }

        for (int i = 1; i <= 6 && i <= K; i++) {
            dice(rolls + i, K - i);
        }
    }

    public static List<String> diceArray(String rolls, int K) {
        if (K == 0) {
            List<String> list = new ArrayList<>();
            list.add(rolls);
            return list;
        }

        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 6 && i <= K; i++) {
            list.addAll(diceArray(rolls + i, K + i));
        }

        return list;
    }


}
