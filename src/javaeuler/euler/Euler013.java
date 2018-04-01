package javaeuler.euler;

import javaeuler.tools.EulerProblem;
import javaeuler.tools.EulerReader;

import java.math.BigInteger;

public class Euler013 extends EulerProblem {
    public static void main(String[] args) {
        EulerProblem problem = new Euler013();
        System.out.println(problem.getSolution());
    }

    @Override
    public long getSolution() {
        BigInteger result = BigInteger.ZERO;
        EulerReader file = new EulerReader("resources/Euler013.txt");
        for (String line : file.readLines()) {
            result = result.add(new BigInteger(line));
        }
        return getNDigits(result, 10);
    }

    private static long getNDigits(BigInteger number, int n) {
        String result = number.toString();
        return Long.valueOf(result.substring(0, 10));
    }
}
