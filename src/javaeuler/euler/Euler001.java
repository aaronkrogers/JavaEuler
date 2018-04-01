package javaeuler.euler;

import javaeuler.tools.EulerProblem;

import java.util.HashSet;
import java.util.Set;

public class Euler001 extends EulerProblem {
    /* Multiples of 3 and 5
    If we list all the natural numbers below 10 that
    are multiples of 3 or 5, we get 3, 5, 6 and 9.
    The sum of these multiples is 23.
    Find the sum of all the multiples of 3 or 5 below 1000.
    */
    private static final int LIMIT = 1000;

    public static void main(String[] args) {
        EulerProblem problem = new Euler001();
        System.out.println(problem.getSolution());
    }

    public long getSolution() {
        // create a Collection for storing multiples of 3 or 5
        // using a Set to eliminate duplicate values
        Set<Integer> multiplesOf3or5 = new HashSet<>();

        long result = 0;
        multiplesOf3or5.addAll(multiplesOfX(3));
        multiplesOf3or5.addAll(multiplesOfX(5));

        for (int i : multiplesOf3or5) {
            result += i;
        }

        return result;
    }

    private static Set<Integer> multiplesOfX(int x) {
        Set<Integer> results = new HashSet<>();
        int multiplier = 1;

        while (x * multiplier < LIMIT) {
            results.add(x * multiplier);
            multiplier += 1;
        }
        return results;
    }
}
