package javaeuler.euler;

import javaeuler.tools.EulerProblem;
import javaeuler.tools.MathTools;

public class Euler021 extends EulerProblem {
    /* Amicable Numbers
    Let d(n) be defined as the sum of proper divisors of n
    (numbers less than n which divide evenly into n).
    If d(a) = b and d(b) = a, where a ≠ b, then a and b are an
    amicable pair and each of a and b are called amicable numbers.

    For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
    therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

    Evaluate the sum of all the amicable numbers under 10000.
     */
    public static void main(String[] args) {
        EulerProblem problem = new Euler021();
        System.out.println(problem.getSolution());
    }

    private static boolean isOfAmicablePair(int num) {
        return ((MathTools.properDivisorSum(MathTools.properDivisorSum(num)) == num) &&
                       (MathTools.properDivisorSum(num) != num));
    }

    @Override
    public long getSolution() {
        long result = 0;
        for (int i = 2; i < 10000; i++) {
            if (isOfAmicablePair(i)) {
                result += i;
            }
        }
        return result;
    }
}
