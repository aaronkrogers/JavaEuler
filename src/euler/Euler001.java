package euler;

import java.util.HashSet;
import java.util.Set;

public class Euler001 {
    private static Set<Integer> results = new HashSet<>();

    public static void main(String[] args) {
        int result = 0;

        multiplesOfX(3, 1000);
        multiplesOfX(5, 1000);

        for (int i : results) {
            result += i;
        }

        System.out.println(result);
    }


    private static void multiplesOfX(int x, int max) {
        int multiplier = 1;

        while (x * multiplier < max) {
            results.add(x * multiplier);
            multiplier += 1;
        }
    }
}
