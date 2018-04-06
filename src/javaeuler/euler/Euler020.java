package javaeuler.euler;

import javaeuler.tools.EulerProblem;

import java.math.BigInteger;

public class Euler020 extends EulerProblem {
    /* Factorial Digit Sum
    n! means n × (n − 1) × ... × 3 × 2 × 1

    For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
    and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

    Find the sum of the digits in the number 100!
     */

    public static void main(String[] args) {
        EulerProblem problem = new Euler020();
        System.out.println(problem.getSolution());
    }

    private BigInteger factorial(BigInteger num) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger n = num;
             n.compareTo(BigInteger.ZERO) > 0;
             n = n.subtract(BigInteger.ONE)) {
            result = result.multiply(n);
        }
        return result;
    }

    private long sumDigits(BigInteger num) {
        long result = 0;
        for (char digit : num.toString().toCharArray()) {
            result += Character.getNumericValue(digit);
        }
        return result;
    }

    public long getSolution() {
        return sumDigits(factorial(new BigInteger("100")));
    }
}
